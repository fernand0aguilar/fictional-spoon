package aeb.gov.br.controller.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aeb.gov.br.views.PerVacationsPDFView;

@Controller
@RequestMapping("/perVacations")
@Scope("request")
public class PerVacationsReport {

	private PerVacationsPDFView perVacationsPdfView;
	
	@RequestMapping(method = RequestMethod.GET)
	public PerVacationsPDFView reportPerVacations(@RequestParam Long userId) {
		perVacationsPdfView.setBossId(userId);
		return perVacationsPdfView;
	}

	@Autowired
	public void setPerVacationsPdfView(PerVacationsPDFView perVacationsPdfView) {
		this.perVacationsPdfView = perVacationsPdfView;
	}
}
