package aeb.gov.br.model.personal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "cor_pele")
public class Color implements Serializable {

	private static final long serialVersionUID = -4769629977771589498L;

	@Column(name = "ID_COR_PELE")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cor_pele_id_seq")
	@SequenceGenerator(name = "cor_pele_id_seq", sequenceName = "cor_pele_id_seq", allocationSize = 1, initialValue = 1000)
	private Long id;

	@Column(name = "DSC_COR_DE_PELE")
	private String name;

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

}
