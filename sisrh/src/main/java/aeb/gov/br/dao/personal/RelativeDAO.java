package aeb.gov.br.dao.personal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.personal.Relative;

@Repository
public interface RelativeDAO extends CrudRepository<Relative, Long> {

	public List<Relative> findAllByEmployee(Employee employee);

}
