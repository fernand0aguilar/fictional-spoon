package aeb.gov.br.service.personal;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import aeb.gov.br.dao.organizational.CoordinationDAO;
import aeb.gov.br.dao.organizational.DirectoryDAO;
import aeb.gov.br.dao.organizational.DivisionDAO;
import aeb.gov.br.dao.personal.EmployeeDAO;
import aeb.gov.br.dao.personal.history.EmployeeHistoryDAO;
import aeb.gov.br.entities.User;
import aeb.gov.br.exception.security.AebNotFound;
import aeb.gov.br.model.DTO.EmployeeDTO;
import aeb.gov.br.model.DTO.EmployeePhoneDTO;
import aeb.gov.br.model.organizational.Coordination;
import aeb.gov.br.model.organizational.Directory;
import aeb.gov.br.model.organizational.Division;
import aeb.gov.br.model.organizational.EmployeeCategory;
import aeb.gov.br.model.organizational.EmployeeRole;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.personal.history.EmployeeHistory;
import aeb.gov.br.model.telephony.EnumPhoneCategory;
import aeb.gov.br.model.telephony.Phone;
import aeb.gov.br.model.telephony.PhoneCategory;
import aeb.gov.br.model.validators.EmployeeValidator;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

	private EmployeeDAO employeeDAO;
	private EmployeeValidator employeeValidator;
	private EmployeeHistoryDAO employeeHistoryDAO;
	
	private CoordinationDAO coordinationDAO;
	private DirectoryDAO directoryDAO;
	private DivisionDAO divisionDAO;


	@Transactional(propagation = Propagation.REQUIRED)
	public EmployeeDTO searchEmployee(String username, User user) throws AebNotFound {
		Employee employee = employeeDAO.findByNetworkLoginAndActiveTrue(username);
		if (employee != null) {
			if (employee.getDirectory() != null) {
				employee.getDirectory().getId();
			}
			if (employee.getCoordination() != null) {
				employee.getCoordination().getId();
			}
			if (employee.getDivision() != null) {
				employee.getDivision().getId();
			}
			EmployeeDTO employeeDTO = new EmployeeDTO(employee, parseGroups(user));
			return employeeDTO;
		} else {
			throw new AebNotFound();
		}
	}

	public List<String> validateEmployeeFields(Employee employee) {
		List<String> messages = employeeValidator.isEmployeeValid(employee);
		return messages;
	}

	private Employee validateEmployee(Employee employee) {

		return employeeValidator.prepareEmployee(employee);
	}

	public Employee searchEmployee(Long id) {
		Employee employee = employeeDAO.findOne(id);
		employee.getDirectory().getName();

		try {
			employee.getCoordination().getName();
		} catch (NullPointerException e) {
			log.debug("O funcionário não possui coordenação");
		}
		try {
			employee.getDivision().getName();
		} catch (NullPointerException e) {
			log.debug("O funcionário não possui divisão");
		}
		return employee;

	}

	public Employee searchEmployeeByNetworkLogin(String networkLogin) {
		return employeeDAO.findByNetworkLogin(networkLogin);
	}

	public Employee updateEmployee(Employee employee) {
		try {
			employee.getEmergencyContact().getPhone().setPhoneCategory(new PhoneCategory(EnumPhoneCategory.HOME));
		} catch (NullPointerException e) {
			// nothing to do.
		}
		return saveEmployee(validateEmployee(employee));
	}

	public void insertEmployee(Employee employee) {
		Employee oldEmployee = employeeDAO.findByCpf(employee.getCpf());

		if (oldEmployee != null) {
			employee.setId(oldEmployee.getId());
			employee.setExitDate(null);
		}
		
		employee.setRegistryDate(new GregorianCalendar());
		employee.setActive(true);

		employee = validateEmployee(employee);

		try {
			employee.getEmergencyContact().getPhone().setPhoneCategory(new PhoneCategory(EnumPhoneCategory.HOME));
		} catch (NullPointerException e) {
			// nothing to do.
		}

		saveEmployee(employee);
	}

	public Iterable<Employee> getBirthdaysOfMonth(int month) {
		return employeeDAO.findByMothOfBirthday(month);

	}

	public Page<Employee> list(Pageable pageable) {
		return employeeDAO.findAll(pageable);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void createInsideCompanyPhone(EmployeePhoneDTO employeePhoneDTO) {
		Phone phone = employeePhoneDTO.getPhone();
		phone.setPhoneCategory(new PhoneCategory(EnumPhoneCategory.INTERNAL));

		Employee employee = employeeDAO.findOne(employeePhoneDTO.getEmployee().getId());
		employee.setInsideCompanyPhone(phone);

		employeeDAO.save(employee);
		updateEmployeeHistory(employee);

	}

	@Transactional(readOnly = false)
	public void removeUser(Long userId, GregorianCalendar disableDate) {
		Employee employee = employeeDAO.findOne(userId);
		employee.setActive(false);
		employee.setExitDate(disableDate);
		employeeDAO.save(employee);

		/* Treating case of email cant be sent. */
		try {
			updateEmployeeHistory(employee);
		} catch (Exception e) {
			System.out.println("Email nao foi possivel de ser enviado.");
		}
	}

	public Page<Employee> listAllWithName(String name, Pageable pageable) {
		return employeeDAO.findByName(name, pageable);
	}

	public int getNumberFromRole(EmployeeRole role) {
		return employeeDAO.countByEmployeeRoleAndActiveTrue(role);

	}

	public Iterable<Employee> getEmployeeByRole(EmployeeRole role) {
		return employeeDAO.findAllByEmployeeRoleAndActiveTrue(role);
	}

	public int getNumberFromCategory(EmployeeCategory employeeCategory) {
		return employeeDAO.countByEmployeeCategoryAndActiveTrue(employeeCategory);
	}

	public Iterable<Employee> getEmployeeByCategory(EmployeeCategory employeeCategory) {
		return employeeDAO.findAllByEmployeeCategoryAndActiveTrue(employeeCategory);
	}

	public String prepareNetworkLogin(String name) {
		// Normalizing name to be prepareted
		name = Normalizer.normalize(name, Normalizer.Form.NFD);
		name = name.toLowerCase();
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		name = pattern.matcher(name).replaceAll("");

		String networkName = null;
		String[] names = name.split(" ");
		int lastNameToUse = names.length - 1;

		while (networkName == null && lastNameToUse > 0) {
			String tempNetworkName = names[0] + "." + names[lastNameToUse];
			Employee employee = employeeDAO.findByNetworkLogin(tempNetworkName);

			if (employee == null) {
				networkName = tempNetworkName;
			} else {
				lastNameToUse--;
			}
		}

		if (lastNameToUse == 0) {
			networkName = names[0];
		}

		return networkName;
	}

	private List<String> parseGroups(User user) {
		List<String> groups = new ArrayList<String>();

		for (String group : user.getGroups()) {
			if (group.startsWith("AEBRh")) {
				groups.add(group);
			}
		}

		return groups;
	}

	private void updateEmployeeHistory(Employee employee) {

		EmployeeHistory employeeHistory = new EmployeeHistory().setActive(employee.isActive())
				.setCoordination(employee.getCoordination()).setDirectory(employee.getDirectory())
				.setDivision(employee.getDivision()).setEmployee(employee)
				.setEmployeeCategory(employee.getEmployeeCategory()).setEmployeeRole(employee.getEmployeeRole())
				.setExitDate(employee.isActive() ? null : new GregorianCalendar())
				.setUpdateDate(new GregorianCalendar());

		employeeHistoryDAO.save(employeeHistory);
	}

	private Employee saveEmployee(Employee employee) {
		employeeDAO.save(employee);
		updateEmployeeHistory(employee);

		return employee;

	}
	
	public ArrayList<Employee> getEmployeeByBoss(Employee boss) {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		Coordination coo;
		Directory dir;
		Division div;
		
		// Get employees from boss's coordination
		if((coo = coordinationDAO.findByCoordinator(boss))!=null){
			emps.addAll(employeeDAO.findAllByCoordination(coo));
		}
		// Get employees from boss's directory
		if((dir = directoryDAO.findByDirector(boss))!=null){
			emps.addAll(employeeDAO.findAllByDirectory(dir));
		}
		// Get employees from boss's division
		if((div = divisionDAO.findByDivisionBoss(boss))!=null){
			emps.addAll(employeeDAO.findAllByDivision(div));
		}
		if(emps.isEmpty()) return null;
		return emps;
	}

	@Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Autowired
	public void setCoordinationDAO(CoordinationDAO coordinationDAO) {
		this.coordinationDAO = coordinationDAO;
	}

	@Autowired
	public void setDirectoryDAO(DirectoryDAO directoryDAO) {
		this.directoryDAO = directoryDAO;
	}

	@Autowired
	public void setDivisionDAO(DivisionDAO divisionDAO) {
		this.divisionDAO = divisionDAO;
	}

	@Autowired
	public void setEmployeeValidator(EmployeeValidator employeeValidator) {
		this.employeeValidator = employeeValidator;
	}

	@Autowired
	public void setEmployeeHistoryDAO(EmployeeHistoryDAO employeeHistoryDAO) {
		this.employeeHistoryDAO = employeeHistoryDAO;
	}


}
