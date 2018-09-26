package aeb.gov.br.service.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeb.gov.br.dao.personal.MaritalStatusDAO;
import aeb.gov.br.model.personal.MaritalStatus;

@Service
@Transactional
public class MaritalStatusService {

	private MaritalStatusDAO maritalStatusDAO;

	public Iterable<MaritalStatus> getMaritalStatus() {
		return maritalStatusDAO.findAll(new Sort(Direction.ASC, "status"));
	}

	@Autowired
	public void setMaritalStatusDAO(MaritalStatusDAO maritalStatusDAO) {
		this.maritalStatusDAO = maritalStatusDAO;
	}

}
