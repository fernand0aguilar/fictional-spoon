package aeb.gov.br.dao.personal.history;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.history.EmployeeHistory;

@Repository
public interface EmployeeHistoryDAO extends CrudRepository<EmployeeHistory, Long> {

}
