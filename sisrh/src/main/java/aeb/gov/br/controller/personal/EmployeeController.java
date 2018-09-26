package aeb.gov.br.controller.personal;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.model.DTO.EmployeePhoneDTO;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.service.personal.EmployeeService;

@RestController
@Scope("request")
@RequestMapping("/employee")
public class EmployeeController {
	private EmployeeService employeeService;

	@RequestMapping(value = "/validateFields", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<String>> validateFields(@RequestBody Employee employee) {
		List<String> invalidFields = employeeService.validateEmployeeFields(employee);
		return ResponseEntity.ok(invalidFields);
	}

	@RequestMapping(value = "/calculateNetworkName", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> calculateNetworkName(@RequestParam String name) {
		return ResponseEntity.ok(employeeService.prepareNetworkLogin(name));
	}

	@RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Page<Employee>> listEmployee(Pageable pageable) {
		return new ResponseEntity<Page<Employee>>(employeeService.list(pageable), HttpStatus.OK);
	}

	@RequestMapping(value = "/insertEmployee", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> insertEmployee(@RequestBody Employee employee) {
		employeeService.insertEmployee(employee);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/birthdaysOfMonth/{month}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Employee>> getBirthdaysOfMonth(@PathVariable int month) {
		return new ResponseEntity<Iterable<Employee>>(employeeService.getBirthdaysOfMonth(month), HttpStatus.OK);
	}

	@RequestMapping(value = "/createInsideCompanyPhone", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> createInsideCompanyPhone(
			@RequestBody EmployeePhoneDTO employeePhoneDTO) {
		this.employeeService.createInsideCompanyPhone(employeePhoneDTO);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/removeUser", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<String> removeUser(@RequestParam Long userId,
			@RequestParam long disableDateLong) {
		GregorianCalendar disableDate = new GregorianCalendar();
		disableDate.setTimeInMillis(disableDateLong);

		this.employeeService.removeUser(userId, disableDate);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/listEmployeeWithName", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Page<Employee>> listEmployeesWithName(@RequestParam String query,
			Pageable pageable) {
		return ResponseEntity.ok(employeeService.listAllWithName(query, pageable));
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Employee> findEmployeeById(@RequestParam Long userId) {
		return new ResponseEntity<Employee>(employeeService.searchEmployee(userId), HttpStatus.OK);
	}

	@RequestMapping(value = "/findByNetworkLogin", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Employee> findEmployeeByNetworkLogin(@RequestParam String username) {
		return new ResponseEntity<Employee>(employeeService.searchEmployeeByNetworkLogin(username), HttpStatus.OK);
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
