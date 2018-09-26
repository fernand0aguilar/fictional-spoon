package aeb.gov.br.model.leave;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_saida")
public class LeaveType implements Serializable {

	private static final long serialVersionUID = -3227620552915885095L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_saida_id_seq")
	@SequenceGenerator(name = "tipo_saida_id_seq", sequenceName = "tipo_saida_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_TIPO_SAIDA")
	private Long id;

	@Column(name = "TXT_CODIGO")
	private String code;

	@Column(name = "TXT_NOME_TIPO")
	private String explanation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

}
