package aeb.gov.br.dao.organizational;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.organizational.Division;
import aeb.gov.br.model.personal.Employee;

@Repository
public interface DivisionDAO extends CrudRepository<Division, Long> {

	public Iterable<Division> findByCoordination_id(Long id);

	public Division findByDivisionBoss(Employee boss);

}
