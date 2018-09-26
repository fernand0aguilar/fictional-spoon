package aeb.gov.br.model.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.util.StringUtil;

@Component
public class EmployeeValidator {

	private Employee employee;
	private List<String> errorMessages;

	public List<String> validateEmptyFields() {
		List<String> messages = new ArrayList<String>();
		
		/*Validator name*/
		if (StringUtil.isEmpty(employee.getName())) {
			messages.add("O campo Nome está inválido");
		} 
		
		/*Validator CPF*/
		if (StringUtil.isEmpty(employee.getCpf())) {
			messages.add("O campo CPF está em branco");
		}
		else if (!StringUtil.checkCPF(employee.getCpf())){
			messages.add("O campo CPF está em inválido");
		}

		/*Validator bloodType*/
		if(StringUtil.isEmpty(employee.getBloodType())){
			messages.add("O campo tipo sanguíneo está inválido");
		}
		
		/*Validator bithdate*/
		if (employee.getBirthDate() == null) {
			messages.add("O campo Data de Nascimento está inválido");
		} 

		/*Validator networkLogin*/
		if(StringUtil.isEmpty(employee.getNetworkLogin())){
			messages.add("O campo login de rede está inválido");
		}

				/*Validator aebMail*/
		if(StringUtil.isEmpty(employee.getAebMail())){
			messages.add("O campo Email AEB está inválido");
		}

		/*Validator address*/
		if (employee.getAddress() != null) {
			// Do nothing
		} else {
			messages.add("O endereço deve estar preenchido");
		}
		
		//TODO - Validate spouse
		//TODO - Validate electionDocument
		//TODO - Validate laborData
		
		/*Validator filiation*/
		if (employee.getFiliation() != null) {
			if (StringUtil.isEmpty(employee.getFiliation().getMotherName())) {
				messages.add("O campo Nome Mãe não foi preenchido");
			}
		} else {
			messages.add("O campo Nome Mãe não foi preenchido");
		}
		
		/*Validator emergencyContact*/
		if (employee.getEmergencyContact() != null) {
			if (employee.getEmergencyContact().getName() != null) {
				if (employee.getEmergencyContact().getPhone() == null
						|| employee.getEmergencyContact().getPhone().getNumber() == null
						|| employee.getEmergencyContact().getPhone().getNumber().equals("")) {
					messages.add("O campo DDD e/ou Telefone de emergência está(ão) inválidos");
				} else {
					// Do nothing
				}
			} else {
				employee.setEmergencyContact(null);
			}
		} 
		
		/*Validator employeeCategory*/
		if (employee.getEmployeeCategory() == null) {
			messages.add("O campo categoria funcionário está inválido");
		} 
		
		//TODO - Validate maritialStatus
		
		/*Validator registryDate*/
//		if(employee.getRegistryDate() == null){
//			messages.add("O campo data de registro está inválido");
//		}
		
		/*Validator employeeRole*/
		if (employee.getEmployeeRole() == null) {
			messages.add("O campo Cargo Funcionário está inválido");
		}		
		
		//TODO - Validate phoneNumber
		
		/*Validator Rg*/
		if (employee.getRg() != null) {
			if (StringUtil.isEmpty(employee.getRg().getRg())) {
				messages.add("O campo RG está inválido");
			} else {
				// Do nothing
			}
			if (employee.getRg().getIssuingCompany() == null) {
				messages.add("O campo Emissor está inválido");
			} else {
				// Do nothing
			}
			if (employee.getRg().getExpeditionDate() == null) {

			} else {
				// Do nothing
			}
		} else {
			messages.add("O campo RG não está preenchido");
		}
		
		/*Validator placeOfBirth*/
		if (employee.getPlaceOfBirth() == null) {
			messages.add("O campo Naturalidade está inválido");
		}
		
		//TODO - Validate skinColor
		if(employee.getInsideCompanyPhone() != null){
			if(employee.getInsideCompanyPhone().getNumber() == null){
				messages.add("O campo Ramal está inválido");
			}
		}
		
		//TODO - Validate outsideEmployee
		//TODO - Validate publicEmployee
		//TODO - Validate healthInsurance
		
		/*Validator birthDistrict*/
		if (employee.getBirthDistrict() == null) {
			messages.add("O campo UF de Nascimento está inválido");
		}
		
		/*Validator exitDate*/
//		if(employee.getExitDate() == null){
//			messages.add("O campo exit date está inválido");
//		}
		
		/*Validator entryDate*/
		if(employee.getEntryDate() == null){
			messages.add("O campo Data de entrada na AEB está inválido");
		}
		
		/*Validator directory.Name*/
		if (employee.getDirectory() == null || StringUtil.isEmpty(employee.getDirectory().getName())) {
			messages.add("O campo Diretoria está inválido");
		}
		
		return messages;

	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages() {
		this.errorMessages = validateEmptyFields();
	}

	public List<String> isEmployeeValid(Employee employee) {

		this.employee = employee;

		return validateEmptyFields();
	}

	public Employee prepareEmployee(Employee employeeToValidate) {

		if (employeeToValidate.getEmergencyContact() != null) {
			if (employeeToValidate.getEmergencyContact().getName() != null) {
				if (employeeToValidate.getEmergencyContact().getPhone() == null
						|| employeeToValidate.getEmergencyContact().getPhone().getNumber() == null
						|| employeeToValidate.getEmergencyContact().getPhone().getNumber().equals("")) {
					employeeToValidate.setEmergencyContact(null);
				} else {
					// Do nothing
				}
			} else {
				employeeToValidate.setEmergencyContact(null);
			}
		} else {
			// Do nothing
		}
		
		if(employeeToValidate.getInsideCompanyPhone() != null){
			if(employeeToValidate.getInsideCompanyPhone().getNumber() == null){
				employeeToValidate.setInsideCompanyPhone(null);
			}
			else if(employeeToValidate.getInsideCompanyPhone().getNumber().isEmpty()){
				employeeToValidate.setInsideCompanyPhone(null);
			}
		} else {
			// Do nothing
		}
		
		return employeeToValidate;
	}
}
