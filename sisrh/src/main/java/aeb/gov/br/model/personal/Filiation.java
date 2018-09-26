package aeb.gov.br.model.personal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "filiacao")
public class Filiation implements Serializable {

	private static final long serialVersionUID = 4715463915835948545L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filiacao_id_seq")
	@SequenceGenerator(name = "filiacao_id_seq", sequenceName = "filiacao_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_FILIACAO")
	private Long id;

	@Column(name = "DSC_NOME_PAI", nullable = true)
	private String fatherName;

	@Column(name = "DSC_NOME_MAE", nullable = false)
	private String motherName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

}
