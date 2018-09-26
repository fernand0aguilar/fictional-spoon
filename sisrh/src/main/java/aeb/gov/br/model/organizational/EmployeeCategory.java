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
@Table(name = "categoria_funcionario")
public class EmployeeCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8944440608154213498L;

	@Id
	@Column(name = "ID_CATEGORIA_FUNCIONARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_funcionario_id_seq")
	@SequenceGenerator(name = "categoria_funcionario_id_seq", sequenceName = "categoria_funcionario_id_seq", allocationSize = 1, initialValue = 1000)
	private Long id;

	@Column(name = "DSC_CATEGORIA_FUNCIONARIO", nullable = false)
	private String category;

	private transient int numberOfEmployees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

}
