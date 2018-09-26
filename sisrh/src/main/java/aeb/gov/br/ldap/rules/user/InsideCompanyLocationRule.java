package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import aeb.gov.br.entities.InsideCompanyLocation;

public interface InsideCompanyLocationRule {
	
	public InsideCompanyLocation prepareInsideCompanyLocation(Attributes attributes) throws NamingException;

}
