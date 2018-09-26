package aeb.gov.br.controller.leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aeb.gov.br.model.leave.LeaveType;
import aeb.gov.br.service.leave.LeaveTypeService;

@Controller
@RequestMapping(value = "/leaveType")
public class LeaveTypeController {

	private LeaveTypeService leaveTypeService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<LeaveType>> getLeaveTypes() {
		return ResponseEntity.ok(leaveTypeService.getLeaveTypes());
	}

	@Autowired
	public void setLeaveTypeService(LeaveTypeService leaveTypeService) {
		this.leaveTypeService = leaveTypeService;
	}

}
