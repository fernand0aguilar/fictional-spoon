package aeb.gov.br.controller.personal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aeb.gov.br.entities.PhoneListDTO;
import aeb.gov.br.service.personal.PhoneListService;

@Controller
@RequestMapping(value = "/phoneList")
public class PhoneListController {

	private PhoneListService phoneListService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<PhoneListDTO>> searchEmployee(@RequestParam(name = "q") String query) {
		return ResponseEntity.ok(phoneListService.searchForPhoneList(query));
	}

	@Autowired
	public void setPhoneListService(PhoneListService phoneListService) {
		this.phoneListService = phoneListService;
	}

}
