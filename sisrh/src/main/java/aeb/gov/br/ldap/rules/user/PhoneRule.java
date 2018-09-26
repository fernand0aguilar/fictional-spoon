package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import aeb.gov.br.entities.Phone;

public interface PhoneRule {
	
	public Phone preparePhone(Attributes attributes) throws NamingException;

}
