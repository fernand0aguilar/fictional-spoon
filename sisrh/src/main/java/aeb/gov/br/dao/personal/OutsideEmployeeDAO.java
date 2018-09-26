package aeb.gov.br.dao.personal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.OutsideEmployee;

@Repository
public interface OutsideEmployeeDAO extends CrudRepository<OutsideEmployee, Long> {

}
