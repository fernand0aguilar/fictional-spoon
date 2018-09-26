package aeb.gov.br.service.organizational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.organizational.EmployeeCategoryDAO;
import aeb.gov.br.model.organizational.EmployeeCategory;

@Service
public class EmployeeCategoryService {

	private EmployeeCategoryDAO employeeCategoryDAO;

	public Iterable<EmployeeCategory> list() {
		return employeeCategoryDAO.findAll(new Sort(Direction.ASC, "category"));
	}

	@Autowired
	public void setEmployeeCategoryDAO(EmployeeCategoryDAO employeeCategoryDAO) {
		this.employeeCategoryDAO = employeeCategoryDAO;
	}

}
