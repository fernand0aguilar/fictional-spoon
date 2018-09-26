package aeb.gov.br.controller.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.views.PerRolePDFView;

@Controller
@RequestMapping("/perRole")
@Scope("request")
public class PerRoleReport extends BaseController {

	private PerRolePDFView perRolePdfView;

	@RequestMapping(method = RequestMethod.GET)
	public PerRolePDFView reportPerRole() {
		return perRolePdfView;
	}

	@Autowired
	public void setPerRolePdfView(PerRolePDFView perRolePdfView) {
		this.perRolePdfView = perRolePdfView;
	}

}
