package aeb.gov.br.model.DTO;

import java.io.Serializable;

import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.telephony.Phone;

public class EmployeePhoneDTO implements Serializable {

	private static final long serialVersionUID = 4000676855865037988L;

	private Employee employee;
	private Phone phone;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
