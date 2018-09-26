package aeb.gov.br.model.personal;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import aeb.gov.br.model.telephony.Phone;

@Entity
@Table(name = "contato_emergencia")
public class EmergencyContact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6904969108732756043L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contato_emergencia_id_seq")
	@SequenceGenerator(name = "contato_emergencia_id_seq", sequenceName = "contato_emergencia_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_CONTATO_EMERGENCIA")
	private Long id;

	@Column(name = "DSC_NOME", nullable = false)
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TELEFONE", nullable = false)
	private Phone phone;

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

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
