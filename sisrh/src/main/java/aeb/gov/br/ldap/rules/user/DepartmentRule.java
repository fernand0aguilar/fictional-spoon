package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import aeb.gov.br.entities.Department;

public interface DepartmentRule {

	public Department prepareDepartment(Attributes attributes) throws NamingException;
}
