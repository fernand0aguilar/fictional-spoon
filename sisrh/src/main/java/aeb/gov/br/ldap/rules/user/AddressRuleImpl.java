package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.stereotype.Component;

import aeb.gov.br.entities.Address;

@Component
public class AddressRuleImpl extends AebRule implements AddressRule {

	public Address prepareAddress(Attributes attributes) throws NamingException {
		Address address = new Address();

		address.setStreetAddress(getStringFieldFromLdap("StreetAddress", attributes));
		address.setPostalCode(getStringFieldFromLdap("postalCode", attributes));

		return address;
	}
}
