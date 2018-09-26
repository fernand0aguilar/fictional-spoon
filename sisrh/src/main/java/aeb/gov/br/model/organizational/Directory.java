package aeb.gov.br.model.organizational;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import aeb.gov.br.model.personal.Employee;

@Entity
@Table(name = "diretoria")
public class Directory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8044554565882048955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diretoria_id_seq")
	@SequenceGenerator(name = "diretoria_id_seq", sequenceName = "diretoria_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_DIRETORIA")
	private Long id;

	@Column(name = "DSC_NOME", nullable = false)
	private String name;
	@Column(name = "DSC_SIGLA", nullable = false)
	private String achronym;
	@Column(name = "DSC_EMAIL", nullable = false)
	private String email;
	@Column(name = "DSC_OBS", nullable = true)
	private String observation;
	@Column(name = "BOL_EXTINTO", nullable = false)
	private boolean extinct;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FUNCIONARIO_DIRETOR", nullable = true)
	@JsonBackReference
	private Employee director;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public boolean isExtinct() {
		return extinct;
	}

	public void setExtinct(boolean extinct) {
		this.extinct = extinct;
	}

	public Employee getDirector() {
		return director;
	}

	public void setDirector(Employee director) {
		this.director = director;
	}

}
