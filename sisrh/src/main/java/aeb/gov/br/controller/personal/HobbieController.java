package aeb.gov.br.controller.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.personal.Hobbie;
import aeb.gov.br.service.personal.HobbieService;

@Controller
@RequestMapping("/hobbie")
@Scope("request")
public class HobbieController extends BaseController {

	private HobbieService hobbieService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Hobbie>> listHobbies() throws Exception {
		return new ResponseEntity<Iterable<Hobbie>>(
				hobbieService.listHobbies(super.validateUserSession().getSessionUserId()), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Hobbie> saveHobbie(@RequestBody Hobbie hobbie) throws Exception {
		hobbie.setEmployee(new Employee(super.validateUserSession().getSessionUserId()));
		return ResponseEntity.ok(hobbieService.saveHobbie(hobbie));
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<Hobbie> deleteHobbie(@RequestBody Hobbie hobbie) throws Exception {
				
		hobbieService.deleteHobbie(hobbie);
		
		return new ResponseEntity<Hobbie>(hobbie, HttpStatus.OK);
	}

	@Autowired
	public void setHobbieService(HobbieService hobbieService) {
		this.hobbieService = hobbieService;
	}

}
