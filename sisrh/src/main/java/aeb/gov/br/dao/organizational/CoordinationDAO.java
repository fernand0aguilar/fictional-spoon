package aeb.gov.br.dao.organizational;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.organizational.Coordination;
import aeb.gov.br.model.personal.Employee;

@Repository
public interface CoordinationDAO extends CrudRepository<Coordination, Long> {

	public Iterable<Coordination> findByDirectory_id(Long id);

	public Coordination findByCoordinator(Employee coordinator);

}
