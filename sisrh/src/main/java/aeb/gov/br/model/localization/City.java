package aeb.gov.br.model.localization;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "cidade")
@JsonInclude(Include.NON_EMPTY)
public class City implements Serializable {

	private static final long serialVersionUID = 346707027537264984L;

	@Id
	@Column(name = "ID_CIDADE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_id_seq")
	@SequenceGenerator(name = "cidade_id_seq", sequenceName = "cidade_id_seq", allocationSize = 1, initialValue = 1000)
	private Long id;

	@Column(name = "DSC_SIGLA_CIDADE", nullable = true)
	private String achronym;
	@Column(name = "DSC_NOME_CIDADE", nullable = false)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_UF", nullable = false)
	private UF uf;

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

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

}
