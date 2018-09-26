package aeb.gov.br.controller.outter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.model.outter.PublicCompany;
import aeb.gov.br.service.outter.PublicCompanyService;

@Controller
@RequestMapping(value = "publicCompany")
@Scope("request")
public class PublicCompanyController extends BaseController {

	private PublicCompanyService publicCompanyService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<PublicCompany>> listAllPublicCompanies() {

		return ResponseEntity.ok(publicCompanyService.listAllPublicCompanies());
	}

	@Autowired
	public void setPublicCompanyService(PublicCompanyService publicCompanyService) {
		this.publicCompanyService = publicCompanyService;
	}

}
