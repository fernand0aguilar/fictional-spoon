package aeb.gov.br.ldap.rules.user;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public interface GroupsRule {
	public List<String> prepareGroups(Attributes attributes) throws NamingException;
}
