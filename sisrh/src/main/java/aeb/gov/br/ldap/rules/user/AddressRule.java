package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import aeb.gov.br.entities.Address;


public interface AddressRule {

	public Address prepareAddress(Attributes attributes) throws NamingException;
}
