package aeb.gov.br.controller.outter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.model.outter.Company;
import aeb.gov.br.service.outter.CompanyService;

@RestController
@RequestMapping(value = "/company")
@Scope("request")
public class CompanyController {

	private CompanyService companyService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Company>> listCompanies() {
		return ResponseEntity.ok(companyService.listAllCompanies());
	}

	@Autowired
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

}
