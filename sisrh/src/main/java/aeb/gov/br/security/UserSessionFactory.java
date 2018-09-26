package aeb.gov.br.security;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UserSessionFactory extends AbstractFactoryBean<UserSession> implements Serializable {

	private static final long serialVersionUID = 6948849144806031803L;

	static String AEB_SESSION_USER = "aeb.security.session.user@security.aeb.com.br";

	private HttpServletRequest request;

	private UserSession sessionUser;

	@Override
	public boolean isSingleton() {
		return false;
	}

	public UserSessionFactory() {
		super();
	}

	public Class<UserSession> getObjectType() {
		return UserSession.class;
	}

	@Autowired
	public void setRequest(final HttpServletRequest request) {
		this.request = request;
	}

	private void buildObject() {
		if (request == null) {
			return;
		}

		final HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}

		this.sessionUser = (UserSession) session.getAttribute(AEB_SESSION_USER);

	}

	@Override
	public UserSession createInstance() throws Exception {
		buildObject();
		return sessionUser;
	}

	public UserSession getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(UserSession sessionUser) {
		this.sessionUser = sessionUser;
	}
}