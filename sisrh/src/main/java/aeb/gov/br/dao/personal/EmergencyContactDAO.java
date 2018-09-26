package aeb.gov.br.dao.personal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.EmergencyContact;

@Repository
public interface EmergencyContactDAO extends CrudRepository<EmergencyContact, Long> {

}
