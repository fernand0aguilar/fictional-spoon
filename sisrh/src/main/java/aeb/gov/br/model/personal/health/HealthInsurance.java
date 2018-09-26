package aeb.gov.br.model.personal.health;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "plano_saude")
public class HealthInsurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4961610937355534064L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plano_saude_id_seq")
	@SequenceGenerator(name = "plano_saude_id_seq", sequenceName = "plano_saude_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_PLANO_SAUDE")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EMPRESA_PLANO_DE_SAUDE")
	private HealthInsuranceCompany healthInsuranceCompany;

	@Column(name = "DSC_NUMERO", nullable = true)
	private String number;

	@Column(name = "DTA_VALIDADE", nullable = true)
	private GregorianCalendar expirationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HealthInsuranceCompany getHealthInsuranceCompany() {
		return healthInsuranceCompany;
	}

	public void setHealthInsuranceCompany(HealthInsuranceCompany healthInsuranceCompany) {
		this.healthInsuranceCompany = healthInsuranceCompany;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public GregorianCalendar getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(GregorianCalendar expirationDate) {
		this.expirationDate = expirationDate;
	}

}
