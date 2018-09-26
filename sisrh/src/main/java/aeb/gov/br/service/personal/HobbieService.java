package aeb.gov.br.service.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeb.gov.br.dao.personal.HobbieDAO;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.personal.Hobbie;

@Service
@Transactional
public class HobbieService {
	private HobbieDAO hobbieDAO;

	public Hobbie saveHobbie(Hobbie hobbie) {
		return hobbieDAO.save(hobbie);
	}

	public Iterable<Hobbie> listHobbies(Long employeeId) {
		return hobbieDAO.findAllByEmployee(new Employee(employeeId));
	}
	
	public void deleteHobbie(Hobbie hobbie){
		hobbieDAO.delete(hobbie);
	}

	@Autowired
	public void setHobbieDAO(HobbieDAO hobbieDAO) {
		this.hobbieDAO = hobbieDAO;
	}

}
