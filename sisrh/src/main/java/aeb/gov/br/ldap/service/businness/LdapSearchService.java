package aeb.gov.br.ldap.service.businness;

import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import aeb.gov.br.entities.User;
import aeb.gov.br.entities.UserName;
import aeb.gov.br.exception.AebError;
import aeb.gov.br.exception.AebNullUserInfoException;
import aeb.gov.br.exception.security.AebNotFound;
import aeb.gov.br.ldap.rules.user.AEBUserRuleImpl;
import aeb.gov.br.ldap.service.LdapConfig;

@Service
public class LdapSearchService extends LdapConfig {

	static Logger logger = LoggerFactory.getLogger(LdapSearchService.class);

	private AEBUserRuleImpl userRuleImpl;

	public LdapSearchService() {
		super();
	}

	public List<User> searchAllUsersFromActiveDirectory() throws AebError, NamingException {
		return getLdapTemplate().search(LdapQueryBuilder.query().where("objectclass").is("user").and("memberOf")
				.is("cn=Usuarios,ou=Grupos,dc=aeb,dc=gov,dc=br"), userRuleImpl);
	}

	public User searchUserBoss(UserName user) throws AebError, AebNullUserInfoException, NamingException, AebNotFound {
		List<User> bossUser = getLdapTemplate()
				.search(LdapQueryBuilder.query().where("sAMAccountName").is(user.getUsername()), userRuleImpl);

		if (!bossUser.isEmpty()) {
			return searchRealBoss(bossUser.get(0));
		}

		throw new AebNotFound("Boss not found");
	}

	public User searchUser(UserName username) throws AebNotFound, AebError, NamingException {
		List<User> users = getLdapTemplate().search(
				LdapQueryBuilder.query().where("objectclass").is("user").and("sAMAccountName")
						.is(username.getUsername()).and("useraccountcontrol").not().is("2.840.113556.1.4.803:=2"),
				userRuleImpl);

		User user = null;

		if (!users.isEmpty()) {
			user = users.get(0);
		}else {
			throw new AebNotFound();
		}

		return user;
	}

	public List<User> searchUsersEmployees(UserName username) throws AebError, NamingException, AebNotFound {
		User user = this.searchUser(username);

		List<User> users = getLdapTemplate().search(
				LdapQueryBuilder.query().where("objectCategory").is("user").and("manager").is(user.getPath()),
				userRuleImpl);

		return users;
	}

	public User searchUserTitle(UserName username) throws AebError, NamingException {

		List<User> users = getLdapTemplate()
				.search(LdapQueryBuilder.query().where("sAMAccountName").is(username.getUsername()), userRuleImpl);

		User user = null;

		if (!users.isEmpty()) {
			user = users.get(0);
		}

		return user;
	}

	private User searchRealBoss(User boss) throws AebError, NamingException, AebNotFound {

		List<User> bossUser = getLdapTemplate().search(
				LdapQueryBuilder.query().where("objectCategory").is("user").and(boss.getBossName()).is(""),
				userRuleImpl);

		if (!bossUser.isEmpty()) {
			return bossUser.get(0);
		}

		throw new AebNotFound("Boss not found");

	}

	@Autowired
	public void setUserRuleImpl(AEBUserRuleImpl userRuleImpl) {
		this.userRuleImpl = userRuleImpl;
	}

}
