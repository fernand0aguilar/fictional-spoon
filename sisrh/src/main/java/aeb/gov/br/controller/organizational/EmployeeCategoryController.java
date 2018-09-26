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
import aeb.gov.br.model.organizational.EmployeeCategory;
import aeb.gov.br.service.organizational.EmployeeCategoryService;

@RestController
@RequestMapping(value = "/category")
@Scope("request")
public class EmployeeCategoryController extends BaseController {
	private EmployeeCategoryService employeeCategoryService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<EmployeeCategory>> list() {
		return new ResponseEntity<Iterable<EmployeeCategory>>(employeeCategoryService.list(), HttpStatus.OK);
	}

	@Autowired
	public void setEmployeeCategoryService(EmployeeCategoryService employeeCategoryService) {
		this.employeeCategoryService = employeeCategoryService;
	}

}
