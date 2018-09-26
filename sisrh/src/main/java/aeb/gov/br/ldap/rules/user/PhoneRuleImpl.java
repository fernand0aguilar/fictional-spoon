package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.stereotype.Component;

import aeb.gov.br.entities.Phone;

@Component
public class PhoneRuleImpl extends AebRule implements PhoneRule {

	public Phone preparePhone(Attributes attributes) throws NamingException {
		Phone phone = new Phone();
		phone.setBranchLine(getStringFieldFromLdap("telephonenumber", attributes));
		return phone;
	}

}
