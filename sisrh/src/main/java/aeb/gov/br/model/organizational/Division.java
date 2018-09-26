package aeb.gov.br.model.organizational;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import aeb.gov.br.model.personal.Employee;

@Entity
@Table(name = "divisao")
public class Division implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7783604400551037264L;

	@Id
	@Column(name = "ID_DIVISAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "divisao_id_seq")
	@SequenceGenerator(name = "divisao_id_seq", sequenceName = "divisao_id_seq", allocationSize = 1, initialValue = 1000)
	private Long id;

	@Column(name = "DSC_NOME", nullable = false)
	private String name;
	@Column(name = "DSC_SIGLA", nullable = false)
	private String achronym;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COORDENACAO", nullable = true)
	private Coordination coordination;

	@OneToOne
	@JoinColumn(name = "ID_FUNCIONARIO_DIVISAO", nullable = true)
	@JsonBackReference
	private Employee divisionBoss;

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

	public Coordination getCoordination() {
		return coordination;
	}

	public void setCoordination(Coordination coordination) {
		this.coordination = coordination;
	}

	public Employee getDivisionBoss() {
		return divisionBoss;
	}

	public void setDivisionBoss(Employee divisionBoss) {
		this.divisionBoss = divisionBoss;
	}

}
