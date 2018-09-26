package aeb.gov.br.service.organizational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.organizational.EmployeeRoleDAO;
import aeb.gov.br.model.organizational.EmployeeRole;

@Service
public class EmployeeRoleService {
	private EmployeeRoleDAO employeeRoleDAO;

	public Iterable<EmployeeRole> list() {
		return employeeRoleDAO.findAll(new Sort(Direction.ASC, "description"));
	}

	@Autowired
	public void setEmployeeRoleDAO(EmployeeRoleDAO employeeRoleDAO) {
		this.employeeRoleDAO = employeeRoleDAO;
	}

}
