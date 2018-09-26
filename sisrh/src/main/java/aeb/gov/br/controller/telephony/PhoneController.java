package aeb.gov.br.controller.telephony;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.model.localization.UF;
import aeb.gov.br.model.telephony.Phone;
import aeb.gov.br.service.telephony.PhoneService;

@RestController
@Service
@RequestMapping("/phone")
@Scope("request")
public class PhoneController {
	private PhoneService phoneService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Phone>> listPhone() {
		return new ResponseEntity<Iterable<Phone>>(phoneService.getAllPhone(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllRamal", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Phone>> getAllRamal() {
		return ResponseEntity.ok(phoneService.getAllRamal());
	}
	
	@Autowired
	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}
}
