package aeb.gov.br.dao.personal.health;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.health.HealthInsurance;

@Repository
public interface HealthInsuranceDAO extends CrudRepository<HealthInsurance, Long> {

}
