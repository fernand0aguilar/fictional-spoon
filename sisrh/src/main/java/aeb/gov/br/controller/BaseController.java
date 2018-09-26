package aeb.gov.br.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import aeb.gov.br.exception.AebError;
import aeb.gov.br.security.UserSession;
import aeb.gov.br.security.UserSessionFactory;
import aeb.gov.br.service.personal.EmployeeService;

public abstract class BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	private UserSessionFactory usuarioSessaoFactory;
	private UserSession userSession;
	private EmployeeService employeeService;

	public UserSession validateUserSession() throws Exception {
		logger.info("iniciando busca por usuario");
		userSession = usuarioSessaoFactory.createInstance();
		if (userSession != null && userSession.getSessionUserId() > 0) {
			return userSession;
		} else {
			throw new AebError();
		}
	}

	public UserSessionFactory getUsuarioSessaoFactory() {
		return usuarioSessaoFactory;
	}

	@Autowired
	public void setUsuarioSessaoFactory(UserSessionFactory usuarioSessaoFactory) {
		this.usuarioSessaoFactory = usuarioSessaoFactory;
	}

	@Autowired
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
