package aeb.gov.br.controller.leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aeb.gov.br.model.leave.Leave;
import aeb.gov.br.service.leave.LeaveService;

@Controller
@RequestMapping(value = "/leave")
public class LeaveController {

	private LeaveService leaveService;

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Leave> registerLeave(@RequestBody Leave leave) {
		return ResponseEntity.ok(leaveService.saveLeave(leave));
	}
	
	@RequestMapping(value="/calculate", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Leave> calculateLeave(@RequestBody Leave leave) {
		return ResponseEntity.ok(leaveService.calculateLeave(leave));
	}
	
	@Autowired
	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
}
