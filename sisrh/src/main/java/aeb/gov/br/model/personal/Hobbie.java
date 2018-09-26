package aeb.gov.br.model.personal;

import java.io.Serializable;

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

@Entity
@Table(name = "hobbie")
public class Hobbie implements Serializable {

	private static final long serialVersionUID = 4967611340910859259L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hobbie_id_seq")
	@SequenceGenerator(name = "hobbie_id_seq", sequenceName = "hobbie_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_HOBBIE")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FUNCIONARIO", nullable = false)
	private Employee employee;

	@Column(name = "DSC_DESCRIPTION", nullable = true)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
