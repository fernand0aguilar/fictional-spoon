package aeb.gov.br.controller.education;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.personal.education.EducationalBackground;
import aeb.gov.br.service.education.EducationalBackgroundService;

@RestController
@Scope("request")
@RequestMapping("/educationalBackground")
public class EducationalBackgroundController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(EducationalBackgroundController.class);

	private EducationalBackgroundService educationalBackgroundService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<EducationalBackground> insertEducationalBackground(
			@RequestBody EducationalBackground educationalBackground) throws Exception {

		educationalBackground.setEmployee(new Employee(super.validateUserSession().getSessionUserId()));
		
		return new ResponseEntity<EducationalBackground>(educationalBackgroundService.insert(educationalBackground),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/edit", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<EducationalBackground> editEducationalBackground(
			@RequestBody EducationalBackground educationalBackground) throws Exception{
		
		educationalBackground.setEmployee(new Employee(super.validateUserSession().getSessionUserId()));
		return new ResponseEntity<EducationalBackground>(educationalBackgroundService.edit(educationalBackground),HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<EducationalBackground> deleteEducationalBackground(@RequestBody EducationalBackground educationalBackground) throws Exception {
		
		educationalBackground.setEmployee(new Employee(super.validateUserSession().getSessionUserId()));
		
		educationalBackgroundService.delete(educationalBackground);
		
		return new ResponseEntity<EducationalBackground>(educationalBackground,HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<EducationalBackground>> listEducationalBacground() throws Exception {
		logger.debug("Iniciando a busca para usuário");
		Long id = super.validateUserSession().getSessionUserId();
		logger.debug("id do usuário = " + id);
		Iterable<EducationalBackground> list = educationalBackgroundService.listEducationalBackground(id);
		return ResponseEntity.ok(list);
	}

	@Autowired
	public void setEducationalBackgroundService(EducationalBackgroundService educationalBackgroundService) {
		this.educationalBackgroundService = educationalBackgroundService;
	}

}
