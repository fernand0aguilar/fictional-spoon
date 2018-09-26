package aeb.gov.br.dao.personal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.Filiation;

@Repository
public interface FiliationDAO extends CrudRepository<Filiation, Long> {

}
