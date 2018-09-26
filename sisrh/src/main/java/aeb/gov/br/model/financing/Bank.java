package aeb.gov.br.model.financing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "banco")
public class Bank implements Serializable {

	private static final long serialVersionUID = -6981270286593815080L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="banco_id_seq")
    @SequenceGenerator(name="banco_id_seq", sequenceName="banco_id_seq", allocationSize=1, initialValue = 1000)
	@Column(name = "ID_BANCO")
	private Long id;

	@Column(name = "DSC_BANCO", nullable = false)
	private String name;
	@Column(name = "INT_CODIGO_BANCO", nullable = false)
	private int code;

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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
