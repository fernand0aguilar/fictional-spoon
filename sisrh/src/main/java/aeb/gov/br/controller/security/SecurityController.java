package aeb.gov.br.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.entities.User;
import aeb.gov.br.entities.security.LoginForm;
import aeb.gov.br.exception.AebError;
import aeb.gov.br.exception.security.AebNotFound;
import aeb.gov.br.ldap.service.security.LoginUserLdapService;
import aeb.gov.br.model.DTO.EmployeeDTO;
import aeb.gov.br.security.SessionAttributeService;
import aeb.gov.br.security.UserSession;
import aeb.gov.br.service.personal.EmployeeService;

@RestController
@Scope("request")
@RequestMapping("/security")
public class SecurityController extends BaseController {

	private LoginUserLdapService loginUserLdapService;
	private SessionAttributeService sessionAttributeService;
	private EmployeeService employeeService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<EmployeeDTO> login(@RequestBody LoginForm loginForm)
			throws AebNotFound, AebError {
		User user = loginUserLdapService.loginOnActiveDirectory(loginForm);

		EmployeeDTO employeeDTO = employeeService.searchEmployee(loginForm.getUsername(), user);

		sessionAttributeService.iniciarSessao(new UserSession(employeeDTO.getEmployee().getId()));

		return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);

	}

	@Autowired
	public void setLoginUserLdapService(LoginUserLdapService loginUserLdapService) {
		this.loginUserLdapService = loginUserLdapService;
	}

	@Autowired
	public void setSessionAttributeService(SessionAttributeService sessionAttributeService) {
		this.sessionAttributeService = sessionAttributeService;
	}

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
