package aeb.gov.br.service.outter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.outter.PublicCompanyDAO;
import aeb.gov.br.model.outter.PublicCompany;

@Service
public class PublicCompanyService {

	private PublicCompanyDAO publicCompanyDAO;

	public Iterable<PublicCompany> listAllPublicCompanies() {
		return publicCompanyDAO.findAll();
	}

	@Autowired
	public void setPublicCompanyDAO(PublicCompanyDAO publicCompanyDAO) {
		this.publicCompanyDAO = publicCompanyDAO;
	}

}
