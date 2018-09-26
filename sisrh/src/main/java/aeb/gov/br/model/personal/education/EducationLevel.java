package aeb.gov.br.model.personal.education;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "nivel_formacao")
public class EducationLevel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 308114887842148310L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nivel_formacao_id_seq")
	@SequenceGenerator(name = "nivel_formacao_id_seq", sequenceName = "nivel_formacao_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_NIVEL_FORMACAO")
	private Long id;

	@Column(name = "DSC_NIVEL_FORMACAO", nullable = false)
	private String level;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
