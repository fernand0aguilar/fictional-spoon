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
import aeb.gov.br.model.personal.Color;
import aeb.gov.br.service.personal.ColorService;

@RestController
@Scope("request")
@RequestMapping(value = "/skinColor")
public class ColorController extends BaseController {

	private ColorService colorService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Color>> getSkinColors() {
			return new ResponseEntity<Iterable<Color>>(colorService.getColors(), HttpStatus.OK);
	}

	@Autowired
	public void setColorService(ColorService colorService) {
		this.colorService = colorService;
	}

}
