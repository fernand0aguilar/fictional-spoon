package aeb.gov.br.model.localization;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "predio")
public class Building implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4642353869111420746L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "predio_id_seq")
	@SequenceGenerator(name = "predio_id_seq", sequenceName = "predio_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_PREDIO")
	private Long id;

	@Column(name = "DSC_PREDIO", nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
