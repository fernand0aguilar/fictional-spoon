package aeb.gov.br.model.personal.health;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "empresa_plano_de_saude")
public class HealthInsuranceCompany implements Serializable {

	private static final long serialVersionUID = -758940189903973664L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_plano_de_saude_id_seq")
	@SequenceGenerator(name = "empresa_plano_de_saude_id_seq", sequenceName = "empresa_plano_de_saude_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_EMPRESA_PLANO_DE_SAUDE")
	private Long id;

	@Column(name = "DSC_NOME")
	private String name;

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

}
