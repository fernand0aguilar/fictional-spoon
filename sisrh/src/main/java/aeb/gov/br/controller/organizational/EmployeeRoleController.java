package aeb.gov.br.controller.organizational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.model.organizational.EmployeeRole;
import aeb.gov.br.service.organizational.EmployeeRoleService;

@RestController
@RequestMapping(value = "/employeeRole")
@Scope("request")
public class EmployeeRoleController extends BaseController {

	private EmployeeRoleService employeeRoleService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<EmployeeRole>> listAll() {
		return new ResponseEntity<Iterable<EmployeeRole>>(employeeRoleService.list(), HttpStatus.OK);
	}

	@Autowired
	public void setEmployeeRoleService(EmployeeRoleService employeeRoleService) {
		this.employeeRoleService = employeeRoleService;
	}

}
