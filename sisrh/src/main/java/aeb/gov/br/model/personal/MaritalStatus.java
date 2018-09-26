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
@Table(name = "estado_civil")
public class MaritalStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5153757243665457644L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_civil_id_seq")
	@SequenceGenerator(name = "estado_civil_id_seq", sequenceName = "estado_civil_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_ESTADO_CIVIL")
	private Long id;

	@Column(name = "DSC_ESTADO_CIVIL", nullable = false)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
