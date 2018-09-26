package aeb.gov.br.controller.organizational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.model.organizational.Division;
import aeb.gov.br.service.organizational.DivisionService;

@RestController
@RequestMapping("/division")
@Scope("request")
public class DivisionController {

	private DivisionService divisionService;
	
	@RequestMapping(value="/fromCoordination", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Division>> listFromCoordination(@RequestParam Long id) {
		return new ResponseEntity<Iterable<Division>>(divisionService.getFromCoordination(id), HttpStatus.OK);
	}

	@Autowired
	public void setDivisionService(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

}
