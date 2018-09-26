package aeb.gov.br.model.personal;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import aeb.gov.br.model.localization.Address;
import aeb.gov.br.model.localization.InternalPlace;
import aeb.gov.br.model.localization.UF;
import aeb.gov.br.model.organizational.Coordination;
import aeb.gov.br.model.organizational.Directory;
import aeb.gov.br.model.organizational.Division;
import aeb.gov.br.model.organizational.EmployeeCategory;
import aeb.gov.br.model.organizational.EmployeeRole;
import aeb.gov.br.model.personal.health.HealthInsurance;
import aeb.gov.br.model.telephony.Phone;
import aeb.gov.br.util.StringUtil;

@Entity
@Table(name = "funcionario")
public class Employee implements Serializable {

	private static final long serialVersionUID = 8310489769536540240L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_id_seq")
	@SequenceGenerator(name = "funcionario_id_seq", sequenceName = "functionario_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_FUNCIONARIO")
	private Long id;

	@Column(name = "INT_MATRICULA", nullable = false)
	private int registerNumber;

	@Column(name = "DSC_NOME", nullable = false)
	private String name;

	@Column(name = "BOL_SEXO", nullable = false)
	private boolean sex;

	@Column(name = "DSC_CPF", nullable = false, unique = true)
	private String cpf;

	@Column(name = "DSC_FATOR_RH", nullable = true)
	private String bloodType;

	@Column(name = "DTA_NASCIMENTO", nullable = false)
	private GregorianCalendar birthDate;

	@Column(name = "DTA_SAIDA", nullable = true)
	private GregorianCalendar exitDate;

	@Column(name = "BOL_TERMO_RESPONSABILIDADE", nullable = false)
	private boolean responsibilityTerm;

	@Column(name = "DSC_EMAIL", nullable = false)
	private String aebMail;

	@Column(name = "DSC_LOGIN_REDE", nullable = false)
	private String networkLogin;

	@Column(name = "DSC_NATURALIDADE", nullable = false)
	private String placeOfBirth;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO", nullable = true)
	private Address address;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_RG", nullable = false)
	private RG rg;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DOCUMENTO_MILITAR", nullable = true)
	private MilitaryDocument militaryDocument;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CONJUGE", nullable = true)
	private Spouse spouse;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DOCUMENTO_ELEITORAL", nullable = true)
	private ElectionDocument electionDocument;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_UF_NASCIMENTO", nullable = true)
	private UF birthDistrict;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DADOS_TRABALHISTAS", nullable = true)
	private LaborData laborData;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_FILIACAO", nullable = false)
	private Filiation filiation;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CONTATO_EMERGENCIA", nullable = true)
	private EmergencyContact emergencyContact;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CATEGORIA_FUNCIONARIO", nullable = false)
	private EmployeeCategory employeeCategory;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CARGO_FUNCIONARIO", nullable = false)
	private EmployeeRole employeeRole;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ESTADO_CIVIL", nullable = true)
	private MaritalStatus maritalStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DIRETORIA", nullable = false)
	@JsonManagedReference
	private Directory directory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COORDENACAO", nullable = true)
	@JsonManagedReference
	private Coordination coordination;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DIVISAO", nullable = true)
	@JsonManagedReference
	private Division division;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PLANO_SAUDE", nullable = true)
	private HealthInsurance healthInsurance;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_COR_PELE", nullable = true)
	private Color skinColor;

	@Column(name = "BOL_ATIVO", nullable = false)
	private boolean active;

	@Column(name = "DTA_CADASTRO", nullable = false)
	private GregorianCalendar registryDate;

	@Column(name = "DTA_ENTRADA", nullable = false)
	private GregorianCalendar entryDate;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_RAMAL", nullable = true)
	private Phone insideCompanyPhone;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TERCEIRO", nullable = true)
	private OutsideEmployee outsideEmployee;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_SERVIDOR", nullable = true)
	private PublicEmployee publicEmployee;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "telefone_funcionario", joinColumns = @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO"), inverseJoinColumns = @JoinColumn(name = "ID_TELEFONE", referencedColumnName = "ID_TELEFONE"))
	private List<Phone> phoneNumbers;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_LOCAL_INTERNO", nullable = true)
	private InternalPlace internalPlace;

	public Employee() {
		super();
	}

	public Employee(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		cpf = StringUtil.replaceCpfCharacteres(cpf);

		this.cpf = cpf;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

	public GregorianCalendar getExitDate() {
		return exitDate;
	}

	public void setExitDate(GregorianCalendar exitDate) {
		this.exitDate = exitDate;
	}

	public boolean isResponsibilityTerm() {
		return responsibilityTerm;
	}

	public void setResponsibilityTerm(boolean responsibilityTerm) {
		this.responsibilityTerm = responsibilityTerm;
	}

	public String getAebMail() {
		return aebMail;
	}

	public void setAebMail(String aebMail) {
		this.aebMail = aebMail;
	}

	public String getNetworkLogin() {
		return networkLogin;
	}

	public void setNetworkLogin(String networkLogin) {
		this.networkLogin = networkLogin;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MilitaryDocument getMilitaryDocument() {
		return militaryDocument;
	}

	public void setMilitaryDocument(MilitaryDocument militaryDocument) {
		this.militaryDocument = militaryDocument;
	}

	public Spouse getSpouse() {
		return spouse;
	}

	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}

	public ElectionDocument getElectionDocument() {
		return electionDocument;
	}

	public void setElectionDocument(ElectionDocument electionDocument) {
		this.electionDocument = electionDocument;
	}

	public LaborData getLaborData() {
		return laborData;
	}

	public void setLaborData(LaborData laborData) {
		this.laborData = laborData;
	}

	public Filiation getFiliation() {
		return filiation;
	}

	public void setFiliation(Filiation filiation) {
		this.filiation = filiation;
	}

	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public EmployeeCategory getEmployeeCategory() {
		return employeeCategory;
	}

	public void setEmployeeCategory(EmployeeCategory employeeCategory) {
		this.employeeCategory = employeeCategory;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}

	public Coordination getCoordination() {
		return coordination;
	}

	public void setCoordination(Coordination coordination) {
		this.coordination = coordination;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public GregorianCalendar getRegistryDate() {
		return registryDate;
	}

	public void setRegistryDate(GregorianCalendar registryDate) {
		this.registryDate = registryDate;
	}

	public EmployeeRole getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(EmployeeRole employeeRole) {
		this.employeeRole = employeeRole;
	}

	public List<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Color getSkinColor() {
		return skinColor;
	}

	public void setSkinColor(Color skinColor) {
		this.skinColor = skinColor;
	}

	public Phone getInsideCompanyPhone() {
		return insideCompanyPhone;
	}

	public void setInsideCompanyPhone(Phone insideCompanyPhone) {
		this.insideCompanyPhone = insideCompanyPhone;
	}

	public OutsideEmployee getOutsideEmployee() {
		return outsideEmployee;
	}

	public void setOutsideEmployee(OutsideEmployee outsideEmployee) {
		this.outsideEmployee = outsideEmployee;
	}

	public PublicEmployee getPublicEmployee() {
		return publicEmployee;
	}

	public void setPublicEmployee(PublicEmployee publicEmployee) {
		this.publicEmployee = publicEmployee;
	}

	public HealthInsurance getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(HealthInsurance healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public UF getBirthDistrict() {
		return birthDistrict;
	}

	public void setBirthDistrict(UF birthDistrict) {
		this.birthDistrict = birthDistrict;
	}

	public GregorianCalendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(GregorianCalendar entryDate) {
		this.entryDate = entryDate;
	}

	public InternalPlace getInternalPlace() {
		return internalPlace;
	}

	public void setInternalPlace(InternalPlace internalPlace) {
		this.internalPlace = internalPlace;
	}

}
