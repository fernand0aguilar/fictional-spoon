package aeb.gov.br.entities;

import java.io.Serializable;

import aeb.gov.br.model.localization.InternalPlace;
import aeb.gov.br.model.organizational.Coordination;
import aeb.gov.br.model.organizational.Directory;
import aeb.gov.br.model.organizational.Division;
import aeb.gov.br.model.organizational.EmployeeCategory;
import aeb.gov.br.model.organizational.EmployeeRole;
import aeb.gov.br.model.personal.PublicEmployee;
import aeb.gov.br.model.telephony.Phone;

public class PhoneListDTO implements Serializable {

	private static final long serialVersionUID = 3196791116974242077L;
	private String name;
	private String email;
	private String networkLogin;
	private EmployeeCategory employeeCategory;
	private EmployeeRole employeeRole;
	private Directory directory;
	private Coordination coordination;
	private Division division;
	private String localidade;
	private PublicEmployee publicEmployee;
	private Phone insideCompanyPhone;
	private InternalPlace internalPlace;

	private PhoneListDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getNetworkLogin() {
		return networkLogin;
	}

	private void setNetworkLogin(String networkLogin) {
		this.networkLogin = networkLogin;
	}

	public EmployeeCategory getEmployeeCategory() {
		return employeeCategory;
	}

	private void setEmployeeCategory(EmployeeCategory employeeCategory) {
		this.employeeCategory = employeeCategory;
	}

	public EmployeeRole getEmployeeRole() {
		return employeeRole;
	}

	private void setEmployeeRole(EmployeeRole employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Directory getDirectory() {
		return directory;
	}

	private void setDirectory(Directory directory) {
		this.directory = directory;
	}

	public Coordination getCoordination() {
		return coordination;
	}

	private void setCoordination(Coordination coordination) {
		this.coordination = coordination;
	}

	public Division getDivision() {
		return division;
	}

	private void setDivision(Division division) {
		this.division = division;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public PublicEmployee getPublicEmployee() {
		return publicEmployee;
	}

	private void setPublicEmployee(PublicEmployee publicEmployee) {
		this.publicEmployee = publicEmployee;
	}

	public Phone getInsideCompanyPhone() {
		return insideCompanyPhone;
	}

	private void setInsideCompanyPhone(Phone insideCompanyPhone) {
		this.insideCompanyPhone = insideCompanyPhone;
	}

	public String getLocalidade() {
		return localidade;
	}

	public InternalPlace getInternalPlace() {
		return internalPlace;
	}

	private void setInternalPlace(InternalPlace internalPlace) {
		this.internalPlace = internalPlace;
	}

	public static class PhoneListBuilder {

		private String name;
		private String email;
		private String networkLogin;
		private EmployeeCategory employeeCategory;
		private EmployeeRole employeeRole;
		private Directory directory;
		private Coordination coordination;
		private Division division;
		private PublicEmployee publicEmployee;
		private Phone insideCompanyPhone;
		private InternalPlace internalPlace;

		public PhoneListDTO build() {
			PhoneListDTO phoneListDTO = new PhoneListDTO();

			phoneListDTO.setName(this.name);
			phoneListDTO.setEmail(this.email);
			phoneListDTO.setNetworkLogin(this.networkLogin);
			phoneListDTO.setEmployeeCategory(this.employeeCategory);
			phoneListDTO.setEmployeeRole(this.employeeRole);
			phoneListDTO.setDirectory(this.directory);
			phoneListDTO.setCoordination(this.coordination);
			phoneListDTO.setDivision(this.division);
			phoneListDTO.setLocalidade(this.getLocalidade());
			phoneListDTO.setPublicEmployee(this.publicEmployee);
			phoneListDTO.setInsideCompanyPhone(this.insideCompanyPhone);
			phoneListDTO.setInternalPlace(this.internalPlace);
			
			return phoneListDTO;
		}

		private PhoneListBuilder() {
			super();
		}

		public static PhoneListBuilder getInstance() {
			return new PhoneListBuilder();
		}

		public PhoneListBuilder withInternalPlace(InternalPlace internalPlace) {
			this.internalPlace = internalPlace;
			return this;
		}

		public PhoneListBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public PhoneListBuilder withNetworkLogin(String networkLogin) {
			this.networkLogin = networkLogin;
			return this;
		}

		public PhoneListBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public PhoneListBuilder withDirectory(Directory directory) {
			this.directory = directory;
			return this;
		}

		public PhoneListBuilder withCoordination(Coordination coordination) {
			this.coordination = coordination;
			return this;
		}

		public PhoneListBuilder withDivision(Division division) {
			this.division = division;
			return this;
		}

		public PhoneListBuilder withRole(EmployeeRole employeeRole) {
			this.employeeRole = employeeRole;
			return this;
		}

		public PhoneListBuilder withCategory(EmployeeCategory employeeCategory) {
			this.employeeCategory = employeeCategory;
			return this;
		}

		public PhoneListBuilder withPublicEmployee(PublicEmployee publicEmployee) {
			this.publicEmployee = publicEmployee;
			return this;
		}

		public PhoneListBuilder withInsideCompanyPhone(Phone insideCompanyPhone) {
			this.insideCompanyPhone = insideCompanyPhone;
			return this;
		}

		private String getLocalidade() {
			if (this.division != null) {
				return this.division.getName();
			} else if (this.coordination != null) {
				return this.coordination.getName();
			} else {
				return this.directory.getName();
			}
		}

	}

}
