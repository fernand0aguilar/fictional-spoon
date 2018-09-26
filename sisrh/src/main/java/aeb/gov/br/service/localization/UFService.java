package aeb.gov.br.service.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.localization.UFDAO;
import aeb.gov.br.model.localization.UF;

@Service
public class UFService {

	private UFDAO ufDAO;

	public Iterable<UF> getAllUf() {
		return ufDAO.findAll();
	}
	
	
	@Autowired
	public void setUfDAO(UFDAO ufDAO) {
		this.ufDAO = ufDAO;
	}
}
