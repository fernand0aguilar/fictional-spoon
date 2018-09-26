package aeb.gov.br.model.outter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import aeb.gov.br.model.localization.Address;
import aeb.gov.br.model.localization.City;
import aeb.gov.br.model.localization.UF;
import aeb.gov.br.model.telephony.Phone;

@Entity
@Table(name = "orgao")
public class PublicCompany implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204678225353218267L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orgao_id_seq")
	@SequenceGenerator(name = "orgao_id_seq", sequenceName = "orgao_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_ORGAO")
	private Long id;

	@Column(name = "DSC_NOME", nullable = false)
	private String name;
	@Column(name = "DSC_SIGLA", nullable = false)
	private String achronym;
	@Column(name = "DSC_CODIGO", nullable = false)
	private String code;
	@Column(name = "DSC_URL_SITE", nullable = false)
	private String siteUrl;

	@OneToOne
	@JoinColumn(name = "ID_ENDERECO", nullable = false)
	private Address address;
	@OneToOne
	@JoinColumn(name = "ID_CIDADE", nullable = false)
	private City city;
	@OneToOne
	@JoinColumn(name = "ID_UF", nullable = false)
	private UF uf;

	@OneToOne
	@JoinColumn(name = "ID_TELEFONE_FAX", nullable = true)
	private Phone fax;

	@OneToOne
	@JoinColumn(name = "ID_TELEFONE", nullable = false)
	private Phone phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAchronym() {
		return achronym;
	}

	public void setAchronym(String achronym) {
		this.achronym = achronym;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Phone getFax() {
		return fax;
	}

	public void setFax(Phone fax) {
		this.fax = fax;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
