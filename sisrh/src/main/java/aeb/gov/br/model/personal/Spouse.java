package aeb.gov.br.model.personal;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "conjuge")
public class Spouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309874186614838579L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conjuge_id_seq")
	@SequenceGenerator(name = "conjuge_id_seq", sequenceName = "conjuge_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_CONJUGE")
	private Long id;

	@Column(name = "DSC_CONJUGE", nullable = false)
	private String name;

	@Column(name = "DTA_NASCIMENTO_CONJUGE", nullable = false)
	private GregorianCalendar birthDate;

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

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

}
