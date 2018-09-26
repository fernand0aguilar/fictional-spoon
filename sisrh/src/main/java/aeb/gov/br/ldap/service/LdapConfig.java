package aeb.gov.br.ldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;

public abstract class LdapConfig {
	private LdapTemplate ldapTemplate;

	public LdapTemplate getLdapTemplate() {
		return ldapTemplate;
	}

	@Autowired
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

}