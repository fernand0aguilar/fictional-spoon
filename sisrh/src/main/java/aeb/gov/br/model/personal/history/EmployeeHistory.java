package aeb.gov.br.model.personal.history;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import aeb.gov.br.model.organizational.Coordination;
import aeb.gov.br.model.organizational.Directory;
import aeb.gov.br.model.organizational.Division;
import aeb.gov.br.model.organizational.EmployeeCategory;
import aeb.gov.br.model.organizational.EmployeeRole;
import aeb.gov.br.model.personal.Employee;

@Entity
@Table(name = "historico_funcionario")
public class EmployeeHistory implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6345169626396236408L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_funcionario_id_seq")
	@SequenceGenerator(name = "historico_funcionario_id_seq", sequenceName = "historico_funcionario_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_HISTORICO_FUNCIONARIO")
	private Long id;

	@Column(name = "DTA_ALTERACAO", nullable = false)
	private GregorianCalendar updateDate;

	@Column(name = "BOL_ATIVO", nullable = false)
	private boolean active;

	@Column(name = "DTA_SAIDA", nullable = true)
	private GregorianCalendar exitDate;

	@OneToOne
	@JoinColumn(name = "ID_FUNCIONARIO", nullable = false)
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIA_FUNCIONARIO", nullable = false)
	private EmployeeCategory employeeCategory;
	@ManyToOne
	@JoinColumn(name = "ID_DIRETORIA", nullable = false)
	private Directory directory;
	@ManyToOne
	@JoinColumn(name = "ID_COORDENACAO", nullable = true)
	private Coordination coordination;
	@ManyToOne
	@JoinColumn(name = "ID_DIVISAO", nullable = true)
	private Division division;
	@ManyToOne
	@JoinColumn(name = "ID_CARGO_FUNCIONARIO", nullable = false)
	private EmployeeRole employeeRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GregorianCalendar getUpdateDate() {
		return updateDate;
	}

	public EmployeeHistory setUpdateDate(GregorianCalendar updateDate) {
		this.updateDate = updateDate;
		return this;
	}

	public boolean isActive() {
		return active;
	}

	public EmployeeHistory setActive(boolean active) {
		this.active = active;
		return this;
	}

	public GregorianCalendar getExitDate() {
		return exitDate;
	}

	public EmployeeHistory setExitDate(GregorianCalendar exitDate) {
		this.exitDate = exitDate;
		return this;
	}

	public Employee getEmployee() {
		return employee;
	}

	public EmployeeHistory setEmployee(Employee employee) {
		this.employee = employee;
		return this;
	}

	public EmployeeCategory getEmployeeCategory() {
		return employeeCategory;
	}

	public EmployeeHistory setEmployeeCategory(EmployeeCategory employeeCategory) {
		this.employeeCategory = employeeCategory;
		return this;
	}

	public Directory getDirectory() {
		return directory;
	}

	public EmployeeHistory setDirectory(Directory directory) {
		this.directory = directory;
		return this;
	}

	public Coordination getCoordination() {
		return coordination;
	}

	public EmployeeHistory setCoordination(Coordination coordination) {
		this.coordination = coordination;
		return this;
	}

	public Division getDivision() {
		return division;
	}

	public EmployeeHistory setDivision(Division division) {
		this.division = division;
		return this;
	}

	public EmployeeRole getEmployeeRole() {
		return employeeRole;
	}

	public EmployeeHistory setEmployeeRole(EmployeeRole employeeRole) {
		this.employeeRole = employeeRole;
		return this;
	}

}
