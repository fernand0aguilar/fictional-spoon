package aeb.gov.br.model.outter;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import aeb.gov.br.model.localization.Address;
import aeb.gov.br.model.telephony.Phone;

@Entity
@Table(name = "empresa")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6964366440503133518L;

	@Id
	@Column(name = "ID_EMPRESA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_id_seq")
	@SequenceGenerator(name = "empresa_id_seq", sequenceName = "empresa_id_seq", allocationSize = 1, initialValue = 1000)
	private Long id;

	@Column(name = "DSC_NOME", nullable = false)
	private String name;
	@Column(name = "DSC_NOME_FANTASIA", nullable = false)
	private String fantasyName;
	@Column(name = "DSC_CNPJ", nullable = false)
	private String cnpj;
	@Column(name = "DSC_URL_SITE", nullable = true)
	private String siteUrl;
	@Column(name = "DSC_EMAIL", nullable = false)
	private String email;
	@Column(name = "BOL_VIGENTE", nullable = false)
	private boolean present;
	@Column(name = "DSC_OBS", nullable = true)
	private String observation;

	@JsonIgnore
	@Column(name = "DTA_CADASTRO", nullable = false)
	private GregorianCalendar registryDate;
	@JsonIgnore
	@Column(name = "DTA_UPDATE", nullable = false)
	private GregorianCalendar updateDate;

	@OneToOne
	@JoinColumn(name = "ID_ENDERECO", nullable = false)
	private Address address;

	@OneToOne
	@JoinColumn(name = "ID_TELEFONE", nullable = false)
	private Phone phone;
	@OneToOne
	@JoinColumn(name = "ID_TELEFONE_SECUNDARIO", nullable = true)
	private Phone secundaryPhone;
	@OneToOne
	@JoinColumn(name = "ID_TELEFONE_FAX", nullable = true)
	private Phone fax;

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

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public GregorianCalendar getRegistryDate() {
		return registryDate;
	}

	public void setRegistryDate(GregorianCalendar registryDate) {
		this.registryDate = registryDate;
	}

	public GregorianCalendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(GregorianCalendar updateDate) {
		this.updateDate = updateDate;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Phone getSecundaryPhone() {
		return secundaryPhone;
	}

	public void setSecundaryPhone(Phone secundaryPhone) {
		this.secundaryPhone = secundaryPhone;
	}

	public Phone getFax() {
		return fax;
	}

	public void setFax(Phone fax) {
		this.fax = fax;
	}

}
