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

import aeb.gov.br.model.localization.Building;
import aeb.gov.br.service.localization.BuildingService;

@RestController
@Service
@RequestMapping("/building")
@Scope("request")
public class BuildingController {
	private BuildingService buildingService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Building>> listBuilding() {
		return new ResponseEntity<Iterable<Building>>(buildingService.getAllBuilding(), HttpStatus.OK);
	}

	@Autowired
	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}
}
