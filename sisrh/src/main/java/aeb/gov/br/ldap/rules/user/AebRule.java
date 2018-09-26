package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public abstract class AebRule {

	public String getStringFieldFromLdap(String field, Attributes attributes) throws NamingException {
		try {
			return attributes.get(field).get().toString();
		} catch (NullPointerException e) {
			return "Non Existing";
		}
	}
	
	public Long getLongFromLdap(String field, Attributes attributes) throws NumberFormatException, NamingException {
		try {
			return Long.parseLong(attributes.get(field).get().toString());
		} catch (Exception e) {
			return new Long(0);
		}
	}
}
