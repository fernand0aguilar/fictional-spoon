package aeb.gov.br.model.leave;

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
@Table(name = "saida")
public class Leave implements Serializable {

	private static final long serialVersionUID = 5060079511906139785L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saida_id_seq")
	@SequenceGenerator(name = "saida_id_seq", sequenceName = "saida_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_SAIDA")
	private Long id;

	@Column(name = "DTA_DIA_SAIDA")
	private GregorianCalendar date;

	@Column(name = "DTA_DIA_FIM_SAIDA")
	private GregorianCalendar endDate;

	@Column(name = "NUM_DURACAO")
	private Long duration;

	@Column(name = "TXT_OBSERVACAO")
	private String observation;

	@Column(name = "BOL_vigente")
	private boolean valid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_SAIDA")
	private LeaveType leaveType;

	@ManyToOne
	@JoinColumn(name = "ID_FUNCIONARIO")
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
