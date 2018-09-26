package aeb.gov.br.model.localization;

import java.io.Serializable;

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
@Table(name = "endereco")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 615613533621560594L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_id_seq")
	@SequenceGenerator(name = "endereco_id_seq", sequenceName = "endereco_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_ENDERECO")
	private Long id;

	@Column(name = "DSC_CEP", nullable = false)
	private String zipcode;
	@Column(name = "DSC_LOGRADOURO", nullable = false)
	private String address;
	@Column(name = "DSC_NUMERO", nullable = true)
	private String number;
	@Column(name = "DSC_COMPLEMENTO", nullable = true)
	private String complement;
	@Column(name = "DSC_BAIRRO", nullable = true)
	private String neighborhood;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CIDADE", nullable = true)
	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
