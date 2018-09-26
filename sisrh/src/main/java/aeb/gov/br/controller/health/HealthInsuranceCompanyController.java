package aeb.gov.br.controller.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.model.personal.health.HealthInsuranceCompany;
import aeb.gov.br.service.health.HealthInsuranceCompanyService;

@RestController
@Scope("request")
@RequestMapping("/healthInsuranceCompany")
public class HealthInsuranceCompanyController {

	private HealthInsuranceCompanyService healthInsuranceCompanyService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<HealthInsuranceCompany>> list() {
		return new ResponseEntity<Iterable<HealthInsuranceCompany>>(healthInsuranceCompanyService.list(),
				HttpStatus.OK);
	}

	@Autowired
	public void setHealthInsuranceCompanyService(HealthInsuranceCompanyService healthInsuranceCompanyService) {
		this.healthInsuranceCompanyService = healthInsuranceCompanyService;
	}
}
