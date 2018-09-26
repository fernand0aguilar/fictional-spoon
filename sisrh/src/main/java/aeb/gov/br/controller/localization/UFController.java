package aeb.gov.br.controller.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.model.localization.UF;
import aeb.gov.br.service.localization.UFService;

@RestController
@Service
@RequestMapping("/uf")
@Scope("request")
public class UFController {

	private UFService ufService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<UF>> listUf() {
		return new ResponseEntity<Iterable<UF>>(ufService.getAllUf(), HttpStatus.OK);
	}
	

	@Autowired
	public void setUfService(UFService ufService) {
		this.ufService = ufService;
	}

}
