package aeb.gov.br.ldap.service.security;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ldap.AuthenticationException;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import aeb.gov.br.entities.User;
import aeb.gov.br.entities.security.LoginForm;
import aeb.gov.br.exception.AebError;
import aeb.gov.br.exception.security.AebNotFound;
import aeb.gov.br.ldap.rules.user.AEBUserRuleImpl;
import aeb.gov.br.ldap.service.LdapConfig;

@Service
@Scope("request")
public class LoginUserLdapService extends LdapConfig {

	private AEBUserRuleImpl userRuleImpl;
	private static final Logger logger = LoggerFactory.getLogger(LoginUserLdapService.class);

	public LoginUserLdapService() {
		super();
	}

	public User loginOnActiveDirectory(LoginForm loginForm) throws AebNotFound, AebError {
		logger.info("Login into the system");
		User user = null;

		try {
			getLdapTemplate().authenticate(LdapQueryBuilder.query().where("sAMAccountName").is(loginForm.getUsername()),
					loginForm.getPassword());
			logger.debug("Authenticated suscessfull");

			List<User> users = getLdapTemplate().search(
					LdapQueryBuilder.query().where("objectclass").is("user").and("sAMAccountName")
							.is(loginForm.getUsername()).and("useraccountcontrol").not().is("2.840.113556.1.4.803:=2"),
					userRuleImpl);

			if (!users.isEmpty()) {
				user = users.get(0);
			} else {
				throw new AebNotFound();
			}

		} catch (AuthenticationException e) {
			throw new AebNotFound();
		} catch (EmptyResultDataAccessException e2) {
			throw new AebNotFound();
		}

		return user;
	}

	@Autowired
	public void setUserRuleImpl(AEBUserRuleImpl userRuleImpl) {
		this.userRuleImpl = userRuleImpl;
	}

}
