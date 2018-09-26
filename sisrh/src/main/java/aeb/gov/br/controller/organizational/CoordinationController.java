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

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.model.organizational.Coordination;
import aeb.gov.br.service.organizational.CoordinationService;

@RestController
@Scope("request")
@RequestMapping("/coordination")
public class CoordinationController extends BaseController {

	private CoordinationService coordinationService;

	@RequestMapping(value = "/fromDirectory", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Coordination>> list(@RequestParam Long id) {
		System.out.println(id);
		return new ResponseEntity<Iterable<Coordination>>(coordinationService.findAllFromDirectory(id), HttpStatus.OK);
	}

	@Autowired
	public void setCoordinationService(CoordinationService coordinationService) {
		this.coordinationService = coordinationService;
	}

}
