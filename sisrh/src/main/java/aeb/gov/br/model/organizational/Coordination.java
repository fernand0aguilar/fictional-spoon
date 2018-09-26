package aeb.gov.br.model.organizational;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import aeb.gov.br.model.personal.Employee;

@Entity
@Table(name = "coordenacao")
public class Coordination implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 927583253969565643L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coordenacao_id_seq")
	@SequenceGenerator(name = "coordenacao_id_seq", sequenceName = "coordenacao_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_COORDENACAO")
	private Long id;

	@Column(name = "DSC_NOME", nullable = false)
	private String name;

	@Column(name = "DSC_SIGLA", nullable = false)
	private String achronym;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DIRETORIA", nullable = false)
	private Directory directory;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FUNCIONARIO_COORDENADOR", nullable = true)
	@JsonBackReference
	private Employee coordinator;

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

	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}

	public Employee getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Employee coordinator) {
		this.coordinator = coordinator;
	}

}
