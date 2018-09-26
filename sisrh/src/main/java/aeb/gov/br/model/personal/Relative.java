package aeb.gov.br.model.personal;

import java.io.Serializable;
import java.util.GregorianCalendar;

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

@Entity
@Table(name = "dependente")
public class Relative implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3032204642531129231L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dependente_id_seq")
	@SequenceGenerator(name = "dependente_id_seq", sequenceName = "dependente_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_DEPENDENTE")
	private Long id;

	@Column(name = "DSC_CPF", nullable = false)
	private String cpf;

	@Column(name = "DTA_NASCIMENTO", nullable = false)
	private GregorianCalendar birthDate;

	@Column(name = "DSC_NOME", nullable = true)
	private String name;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_FILIACAO", nullable = false)
	private Filiation filiation;

	@ManyToOne
	@JoinColumn(name = "ID_FUNCIONARIO", nullable = false)
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Filiation getFiliation() {
		return filiation;
	}

	public void setFiliation(Filiation filiation) {
		this.filiation = filiation;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
