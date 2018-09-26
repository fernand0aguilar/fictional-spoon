package aeb.gov.br.service.organizational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.organizational.DivisionDAO;
import aeb.gov.br.model.organizational.Division;

@Service
public class DivisionService {

	private DivisionDAO divisionDAO;

	public Iterable<Division> getFromCoordination(Long id) {
		return divisionDAO.findByCoordination_id(id);
	}

	@Autowired
	public void setDivisionDAO(DivisionDAO divisionDAO) {
		this.divisionDAO = divisionDAO;
	}

}
