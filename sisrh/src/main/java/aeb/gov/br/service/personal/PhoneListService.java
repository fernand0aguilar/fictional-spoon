package aeb.gov.br.service.personal;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.personal.PhoneListDAO;
import aeb.gov.br.entities.PhoneListDTO;
import aeb.gov.br.entities.PhoneListDTO.PhoneListBuilder;
import aeb.gov.br.model.personal.Employee;

@Service
@Transactional
public class PhoneListService {

	private PhoneListDAO phoneListDAO;

	public List<PhoneListDTO> searchForPhoneList(String query) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");

        System.out.println(query);
		List<Employee> employees = phoneListDAO.getPhoneListEntries(query.trim());

		List<PhoneListDTO> phoneListDTO = new ArrayList<PhoneListDTO>();

		for (Employee employee : employees) {
			phoneListDTO.add(fetchData(employee));

		}
		return phoneListDTO;

	}

	private PhoneListDTO fetchData(Employee employee) {
		fetchDirection(employee);
		feetchCoordination(employee);
		feetchDivision(employee);
		fetchRole(employee);
		fetchCategory(employee);
		fetchPublicEmployee(employee);
		fetchInternalPlace(employee);
		return buildDTO(employee);

	}

	private PhoneListDTO buildDTO(Employee employee) {
		return PhoneListBuilder.getInstance()
				.withName(employee.getName())
				.withEmail(employee.getAebMail())
				.withNetworkLogin(employee.getNetworkLogin())
				.withCategory(employee.getEmployeeCategory())
				.withRole(employee.getEmployeeRole())
				.withDirectory(employee.getDirectory())
				.withCoordination(employee.getCoordination())
				.withDivision(employee.getDivision())
				.withPublicEmployee(employee.getPublicEmployee())
				.withInsideCompanyPhone(employee.getInsideCompanyPhone())
				.withInternalPlace(employee.getInternalPlace())
				.build();
	}

	private void fetchInternalPlace(Employee employee) {
		try {
			employee.getInternalPlace().getId();
		} catch(NullPointerException e) {
			// Nothing to do.
		}
	}

	private void fetchPublicEmployee(Employee employee) {
		try {
			employee.getPublicEmployee().getId();
			employee.getPublicEmployee().getPublicCompany().getId();
		} catch (NullPointerException e) {
			// Nothing to do.
		}
	}

	private void fetchCategory(Employee employee) {
		try {
			employee.getEmployeeCategory().getId();
		} catch (NullPointerException e) {
			// Nothing to do.
		}
	}

	private void fetchRole(Employee employee) {
		try {
			employee.getEmployeeRole().getId();
		} catch (NullPointerException e) {
			// Nothing to do.
		}
	}

	private void feetchCoordination(Employee employee) {
		try {
			employee.getCoordination().getId();
		} catch (NullPointerException e) {
			// Nothing to do
		}
	}

	private void feetchDivision(Employee employee) {
		try {
			employee.getDivision().getId();
		} catch (NullPointerException e) {
			// Nothing to do
		}
	}

	private void fetchDirection(Employee employee) {
		try {
			employee.getDirectory().getId();
		} catch (NullPointerException e) {
			// Nothing to do
		}
	}

	@Autowired
	public void setPhoneListDAO(PhoneListDAO phoneListDAO) {
		this.phoneListDAO = phoneListDAO;
	}

}
