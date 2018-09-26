package aeb.gov.br.model.localization;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "uf")
public class UF implements Serializable {

	private static final long serialVersionUID = -6800827493976594653L;

	@Id
	@Column(name = "ID_UF")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uf_id_seq")
	@SequenceGenerator(name = "uf_id_seq", sequenceName = "uf_id_seq", allocationSize = 1, initialValue = 1000)
	private Long id;

	@Column(name = "DSC_SIGLA", nullable = false)
	private String achronym;
	@Column(name = "DSC_NOME", nullable = false)
	private String name;

	@OneToMany(mappedBy = "uf", fetch = FetchType.LAZY)
	private List<City> cities;

	public UF() {
		super();
	}

	public UF(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAchronym() {
		return achronym;
	}

	public void setAchronym(String achronym) {
		this.achronym = achronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
