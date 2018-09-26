package aeb.gov.br.service.personal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.personal.RelativeDAO;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.personal.Relative;

@Service
public class RelativeService {

	private RelativeDAO relativeDAo;

	public List<Relative> getAllDependents(Employee employee) {
		return relativeDAo.findAllByEmployee(employee);
	}

	public Relative save(Relative relative) {
		return relativeDAo.save(relative);
	}

	public void delete(long id) {
		relativeDAo.delete(id);
	}

	@Autowired
	public void setRelativeDAo(RelativeDAO relativeDAo) {
		this.relativeDAo = relativeDAo;
	}

}
