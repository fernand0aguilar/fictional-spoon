package aeb.gov.br.service.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.personal.health.HealthInsuranceCompanyDAO;
import aeb.gov.br.model.personal.health.HealthInsuranceCompany;

@Service
public class HealthInsuranceCompanyService {

	private HealthInsuranceCompanyDAO healthInsuranceCompanyDAO;

	public Iterable<HealthInsuranceCompany> list() {
		return healthInsuranceCompanyDAO.findAll();
	}

	@Autowired
	public void setHealthInsuranceCompanyDAO(HealthInsuranceCompanyDAO healthInsuranceCompanyDAO) {
		this.healthInsuranceCompanyDAO = healthInsuranceCompanyDAO;
	}

	
}
