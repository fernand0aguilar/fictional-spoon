package aeb.gov.br.entities;

import java.io.Serializable;

public class Department implements Serializable {

	private static final long serialVersionUID = 6276228031910691315L;
	
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
