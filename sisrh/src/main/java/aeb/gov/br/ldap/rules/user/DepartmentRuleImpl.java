package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.stereotype.Component;

import aeb.gov.br.entities.Department;

@Component
public class DepartmentRuleImpl extends AebRule implements DepartmentRule {

	public Department prepareDepartment(Attributes attributes) throws NamingException {
		Department department = new Department();

		department.setDepartmentName(getStringFieldFromLdap("department", attributes));
		return department;
	}
}
