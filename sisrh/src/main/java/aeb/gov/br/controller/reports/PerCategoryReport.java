package aeb.gov.br.controller.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeb.gov.br.views.PerCategoryPDFView;

@Controller
@RequestMapping("/perCategory")
@Scope("request")
public class PerCategoryReport {
	
	private PerCategoryPDFView perCategoryPDFView;
	
	@RequestMapping(method = RequestMethod.GET)
	public PerCategoryPDFView reportPerCategory() {
		return perCategoryPDFView;
	}
	
	@Autowired
	public void setPerCategoryPDFView(PerCategoryPDFView perCategoryPDFView) {
		this.perCategoryPDFView = perCategoryPDFView;
	}
	
	

}
