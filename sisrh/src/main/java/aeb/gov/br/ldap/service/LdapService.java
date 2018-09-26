package aeb.gov.br.ldap.service;

import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LdapService {

	private static final Logger logger = LoggerFactory.getLogger(LdapService.class);
	private Hashtable<String, String> authHash;

	public LdapService() {
		logger.info("Initializing LDAPService");
		authHash = new Hashtable<String, String>(11);
		logger.info("Finished LDAPService inittialization");
	}

}
