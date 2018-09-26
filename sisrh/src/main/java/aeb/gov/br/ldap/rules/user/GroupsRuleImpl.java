package aeb.gov.br.ldap.rules.user;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.stereotype.Component;

@Component
public class GroupsRuleImpl extends AebRule implements GroupsRule {

	@SuppressWarnings("rawtypes")
	@Override
	public List<String> prepareGroups(Attributes attributes) throws NamingException {

		List<String> groups = new ArrayList<String>();
		for (Enumeration vals = attributes.get("memberOf").getAll(); vals.hasMoreElements();) {

			Pattern pattern = Pattern.compile("CN=(.+?(?=,))");
			String group = (String) vals.nextElement();

			Matcher matcher = pattern.matcher(group);

			if (matcher.find()) {
				groups.add(matcher.group(0).split("=")[1]);
			}

		}

		return groups;
	}

}
