package aeb.gov.br.ldap.rules.user;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.stereotype.Component;

import aeb.gov.br.entities.InsideCompanyLocation;

@Component
public class InsideCompanyLocationRuleImpl extends AebRule implements InsideCompanyLocationRule {

	public InsideCompanyLocation prepareInsideCompanyLocation(Attributes attributes) throws NamingException {
		InsideCompanyLocation insideCompanyLocation = new InsideCompanyLocation();

		insideCompanyLocation.setRoom(getStringFieldFromLdap("physicalDeliveryOfficeName", attributes));
		return insideCompanyLocation;
	}

}
