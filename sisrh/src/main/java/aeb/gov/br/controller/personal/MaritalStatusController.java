package aeb.gov.br.controller.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.model.personal.MaritalStatus;
import aeb.gov.br.service.personal.MaritalStatusService;

@RestController
@Scope("request")
@RequestMapping("/maritalStatus")
public class MaritalStatusController extends BaseController {

	private MaritalStatusService maritalStatusService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<MaritalStatus>> getMaritalStatus() {
		return new ResponseEntity<Iterable<MaritalStatus>>(maritalStatusService.getMaritalStatus(), HttpStatus.OK);
	}

	@Autowired
	public void setMaritalStatusService(MaritalStatusService maritalStatusService) {
		this.maritalStatusService = maritalStatusService;
	}

}
