package aeb.gov.br.dao.personal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.LaborData;

@Repository
public interface LaborDataDAO extends CrudRepository<LaborData, Long> {

}
