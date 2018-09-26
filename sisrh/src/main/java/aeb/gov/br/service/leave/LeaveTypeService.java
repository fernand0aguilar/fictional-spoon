package aeb.gov.br.service.leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.leave.LeaveTypeDAO;
import aeb.gov.br.model.leave.LeaveType;

@Service
public class LeaveTypeService {

	private LeaveTypeDAO leaveTypeDAO;

	public Iterable<LeaveType> getLeaveTypes() {

		return leaveTypeDAO.findAll();
	}

	@Autowired
	public void setLeaveTypeDAO(LeaveTypeDAO leaveTypeDAO) {
		this.leaveTypeDAO = leaveTypeDAO;
	}

}
