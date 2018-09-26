package aeb.gov.br.model.organizational;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cargo_funcionario")
public class EmployeeRole implements Serializable {

	private static final long serialVersionUID = 4890422602703173965L;

	@Id
	@Column(name = "ID_CARGO_FUNCIONARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cargo_funcionario_id_seq")
	@SequenceGenerator(name = "cargo_funcionario_id_seq", sequenceName = "cargo_funcionario_id_seq", allocationSize = 1, initialValue = 1000)
	private Long id;

	@Column(name = "DSC_CARGO", nullable = false)
	private String description;
	@Column(name = "DSC_OBS", nullable = true)
	private String observation;

	private transient int numberOfEmployee = 0;

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

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

}
