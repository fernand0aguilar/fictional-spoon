package aeb.gov.br.controller.localization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.model.localization.InternalPlace;
import aeb.gov.br.service.localization.InternalPlaceService;

@RestController
@Service
@RequestMapping("/internalPlace")
@Scope("request")
public class InternalPlaceController {
	private InternalPlaceService internalPlaceService;

	@RequestMapping(value = "/validateFields", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<String>> validateFields(@RequestBody InternalPlace internalPlace) {
		List<String> invalidFields = internalPlaceService.validateFields(internalPlace);
		return ResponseEntity.ok(invalidFields);
	}
	
	@RequestMapping(value = "/insertInternalPlace", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> insertInternalPlace(@RequestBody InternalPlace internalPlace) {
		internalPlaceService.insertInternalPlace(internalPlace);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Autowired
	public void setInternalPlaceService(InternalPlaceService internalPlaceService) {
		this.internalPlaceService = internalPlaceService;
	}
}
