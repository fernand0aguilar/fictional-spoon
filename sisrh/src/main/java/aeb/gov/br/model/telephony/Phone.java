package aeb.gov.br.model.telephony;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
public class Phone implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4992862480519932519L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone_id_seq")
	@SequenceGenerator(name = "telefone_id_seq", sequenceName = "telefone_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_TELEFONE")
	private Long id;

	@Column(name = "DSC_DDD", nullable = true)
	private String ddd;
	@Column(name = "DSC_NUMERO", nullable = false)
	private String number;
	@Column(name = "DSC_CODIGO_PAIS", nullable = true)
	private String countryCode;
	
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIA_TELEFONE", nullable = false)
	private PhoneCategory phoneCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public PhoneCategory getPhoneCategory() {
		return phoneCategory;
	}

	public void setPhoneCategory(PhoneCategory phoneCategory) {
		this.phoneCategory = phoneCategory;
	}

}
