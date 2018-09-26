package aeb.gov.br.ldap.rules.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.stereotype.Component;

import aeb.gov.br.entities.User;

@Component
public class AEBUserRuleImpl extends AebRule implements AEBUserRule, AttributesMapper<User> {

	private AddressRule addressRule;
	private DepartmentRule departmentRule;
	private InsideCompanyLocationRule insideCompanyLocationRule;
	private PhoneRule phoneRule;
	private GroupsRule groupsRule;

	@Override
	public User mapFromAttributes(Attributes attributes) throws NamingException {
		User user = new User();

		user.setName(getStringFieldFromLdap("displayName", attributes));
		user.setTitle(getStringFieldFromLdap("title", attributes));
		user.setBossName(getBossName(getStringFieldFromLdap("manager", attributes)));
		user.setAccountName(getStringFieldFromLdap("sAMAccountName", attributes));
		user.setComumName(getStringFieldFromLdap("cn", attributes));
		user.setPath(getStringFieldFromLdap("distinguishedName", attributes));
		user.setUserStatus(getLongFromLdap("UserAccountControl", attributes));

		user.setAddress(addressRule.prepareAddress(attributes));
		user.setDepartment(departmentRule.prepareDepartment(attributes));
		user.setInsideCompanyLocation(insideCompanyLocationRule.prepareInsideCompanyLocation(attributes));
		user.setPhone(phoneRule.preparePhone(attributes));

		user.setGroups(groupsRule.prepareGroups(attributes));

		return user;
	}

	private String getBossName(String bossName) {
		if (bossName != null) {
			Pattern pattern = Pattern.compile("CN=(.+?(?=,))");

			Matcher matcher = pattern.matcher(bossName);

			if (matcher.find()) {
				bossName = matcher.group(0).split("=")[1];
			}
		}
		return bossName;
	}

	@Autowired
	public void setAddressRule(AddressRule addressRule) {
		this.addressRule = addressRule;
	}

	@Autowired
	public void setDepartmentRule(DepartmentRule departmentRule) {
		this.departmentRule = departmentRule;
	}

	@Autowired
	public void setInsideCompanyLocationRule(InsideCompanyLocationRule insideCompanyLocationRule) {
		this.insideCompanyLocationRule = insideCompanyLocationRule;
	}

	@Autowired
	public void setPhoneRule(PhoneRule phoneRule) {
		this.phoneRule = phoneRule;
	}

	@Autowired
	public void setGroupsRule(GroupsRule groupsRule) {
		this.groupsRule = groupsRule;
	}

}
