package aeb.gov.br.dao.leave;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.leave.Leave;
import aeb.gov.br.model.leave.LeaveType;

@Repository
public interface LeaveDAO extends CrudRepository<Leave, Long> {

	ArrayList<Leave> findAllByLeaveType(LeaveType leaveType);

}
