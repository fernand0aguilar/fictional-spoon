package aeb.gov.br.controller.personal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.personal.Relative;
import aeb.gov.br.service.personal.RelativeService;

@RestController
@Scope("request")
@RequestMapping(value = "/relative")
public class RelativeController extends BaseController {

	private RelativeService relativeService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Relative>> getAllDependent() throws Exception {

		List<Relative> dependents = relativeService
				.getAllDependents(new Employee(super.validateUserSession().getSessionUserId()));
		return ResponseEntity.ok(dependents);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Relative> saveRelative(@RequestBody Relative relative) throws Exception {

		System.out.println(relative.getBirthDate());
		System.out.println("OOOIEIIEJKAHLSDSLK");

		relative.setEmployee(new Employee(super.validateUserSession().getSessionUserId()));

		try {
		return ResponseEntity.ok(relativeService.save(relative));
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<String> deleteRelative(@RequestParam long id) {

		relativeService.delete(id);

		return ResponseEntity.ok("");
	}

	@Autowired
	public void setRelativeService(RelativeService relativeService) {
		this.relativeService = relativeService;
	}

}
