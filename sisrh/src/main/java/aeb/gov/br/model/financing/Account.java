package aeb.gov.br.model.financing;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import aeb.gov.br.model.personal.Employee;

@Entity
@Table(name = "conta")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8980703266350517284L;

	@Id
	@SequenceGenerator(name = "conta_id_seq", sequenceName = "conta_id_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_id_seq")
	@Column(name = "ID_CONTA")
	private Long id;

	@Column(name = "DSC_AGENCIA", nullable = false)
	private String agency;
	@Column(name = "DSC_CONTA", nullable = false)
	private String accountNumber;
	@Column(name = "BOL_ATIVA", nullable = false)
	private boolean active;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BANCO", nullable = false)
	private Bank bank;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FUNCIONARIO", nullable = false)
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
