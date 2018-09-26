package aeb.gov.br.controller.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.model.personal.education.EducationLevel;
import aeb.gov.br.service.education.EducationalLevelService;

@RestController
@Scope("request")
@RequestMapping("/educationLevel")
public class EducationLevelController extends BaseController {

	private EducationalLevelService educationalLevelService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<EducationLevel>> list() {
		return new ResponseEntity<Iterable<EducationLevel>>(educationalLevelService.list(), HttpStatus.OK);
	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<EducationLevel>> teste() {
		return new ResponseEntity<Iterable<EducationLevel>>(educationalLevelService.list(), HttpStatus.OK);
	}

	@Autowired
	public void setEducationalLevelService(EducationalLevelService educationalLevelService) {
		this.educationalLevelService = educationalLevelService;
	}

}
