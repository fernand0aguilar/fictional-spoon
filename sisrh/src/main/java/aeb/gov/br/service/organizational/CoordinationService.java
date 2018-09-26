package aeb.gov.br.service.organizational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeb.gov.br.dao.organizational.CoordinationDAO;
import aeb.gov.br.model.organizational.Coordination;

@Service
@Transactional
public class CoordinationService {

	private CoordinationDAO coordinationDAO;

	public Iterable<Coordination> findAllFromDirectory(Long directoryId) {
		return coordinationDAO.findByDirectory_id(directoryId);
	}

	@Autowired
	public void setCoordinationDAO(CoordinationDAO coordinationDAO) {
		this.coordinationDAO = coordinationDAO;
	}

}
