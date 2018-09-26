package aeb.gov.br.service.leave;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeb.gov.br.dao.leave.LeaveDAO;
import aeb.gov.br.dao.leave.LeaveTypeDAO;
import aeb.gov.br.model.leave.Leave;
import aeb.gov.br.model.leave.LeaveType;

@Service
@Transactional
public class LeaveService {

	private LeaveDAO leaveDAO;
	private LeaveTypeDAO leaveTypeDAO;

	public Leave saveLeave(Leave leave) {
		leave.setValid(true);
		return leaveDAO.save(leave);
	}

	public Leave calculateLeave(Leave leave) {
		GregorianCalendar endDate = new GregorianCalendar();
		endDate.setTimeInMillis(leave.getDate().getTimeInMillis());

		endDate.add(GregorianCalendar.DAY_OF_MONTH, leave.getDuration().intValue() - 1);

		leave.setEndDate(endDate);
		return leave;
	}

	public ArrayList<Leave> getAllVacation() {
		LeaveType vacation = leaveTypeDAO.findByCode("01.22");
		return leaveDAO.findAllByLeaveType(vacation);
	}

	@Autowired
	public void setLeaveDAO(LeaveDAO leaveDAO) {
		this.leaveDAO = leaveDAO;
	}
	
	@Autowired
	public void setLeaveTypeDAO(LeaveTypeDAO leaveTypeDAO) {
		this.leaveTypeDAO = leaveTypeDAO;
	}

}
