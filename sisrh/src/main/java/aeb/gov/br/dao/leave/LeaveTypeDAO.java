package aeb.gov.br.dao.leave;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.leave.LeaveType;

@Repository
public interface LeaveTypeDAO extends CrudRepository<LeaveType, Long> {

	LeaveType findByCode(String code);
}
