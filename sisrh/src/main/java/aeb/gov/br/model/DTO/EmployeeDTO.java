package aeb.gov.br.model.DTO;

import java.io.Serializable;
import java.util.List;

import aeb.gov.br.model.personal.Employee;

public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 795887559257891755L;
	private Employee employee;
	private List<String> group;

	public EmployeeDTO(Employee employee, List<String> group) {
		super();
		this.employee = employee;
		this.group = group;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<String> getGroup() {
		return group;
	}

	public void setGroup(List<String> group) {
		this.group = group;
	}

}
