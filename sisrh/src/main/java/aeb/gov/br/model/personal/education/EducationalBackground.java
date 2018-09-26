package aeb.gov.br.model.personal.education;

import java.io.Serializable;
import java.util.GregorianCalendar;

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

import aeb.gov.br.model.personal.Employee;

@Entity
@Table(name = "formacao")
public class EducationalBackground implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8964640471893143023L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formacao_id_seq")
	@SequenceGenerator(name = "formacao_id_seq", sequenceName = "formacao_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_FORMACAO")
	private Long id;

	@Column(name = "DSC_CURSO", nullable = true)
	private String course;
	@Column(name = "DSC_INSTITUICAO", nullable = false)
	private String institution;
	@Column(name = "DTA_INICIO", nullable = true)
	private GregorianCalendar begin;
	@Column(name = "DTA_ATUALIZACAO", nullable = true)
	private GregorianCalendar update;
	@Column(name = "DTA_CONCLUSAO", nullable = true)
	private GregorianCalendar conclusion;
	@Column(name = "DSC_OBS", nullable = true)
	private String observation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_NIVEL_FORMACAO", nullable = false)
	private EducationLevel educationLevel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FUNCIONARIO", nullable = false)
	private Employee employee;

	public EducationalBackground() {
		super();
		this.update = new GregorianCalendar();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public GregorianCalendar getBegin() {
		return begin;
	}

	public void setBegin(GregorianCalendar begin) {
		this.begin = begin;
	}

	public GregorianCalendar getUpdate() {
		return update;
	}

	public void setUpdate(GregorianCalendar update) {
		this.update = update;
	}

	public GregorianCalendar getConclusion() {
		return conclusion;
	}

	public void setConclusion(GregorianCalendar conclusion) {
		this.conclusion = conclusion;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
