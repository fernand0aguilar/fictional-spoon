package aeb.gov.br.service.outter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.outter.CompanyDAO;
import aeb.gov.br.model.outter.Company;

@Service
public class CompanyService {

	private CompanyDAO companyDAO;

	public Iterable<Company> listAllCompanies() {
		return companyDAO.findAll();
	}

	@Autowired
	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

}
