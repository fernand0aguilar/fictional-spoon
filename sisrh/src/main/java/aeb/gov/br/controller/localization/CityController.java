package aeb.gov.br.controller.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.model.localization.City;
import aeb.gov.br.service.localization.CityService;

@RestController
@RequestMapping("/city")
@Scope("request")
public class CityController {

	private CityService cityService;

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<City> getCity(@RequestParam Long id) {
		return new ResponseEntity<City>(cityService.find(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/findByUf", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<City>> listCityFromUf(@RequestParam Long id) {
		return new ResponseEntity<Iterable<City>>(cityService.getCityFromUf(id), HttpStatus.OK);
	}

	@Autowired
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

}
