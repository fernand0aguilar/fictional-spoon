package aeb.gov.br.model.localization;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import aeb.gov.br.model.telephony.Phone;

@Entity
@Table(name = "local_interno")
public class InternalPlace implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1229689903677791527L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local_interno_id_seq")
	@SequenceGenerator(name = "local_interno_id_seq", sequenceName = "local_interno_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_LOCAL_INTERNO")
	private Long id;

	@Column(name = "DSC_NUMERO_SALA", nullable = true)
	private String roomNumber;
	@Column(name = "DTA_CADASTRO", nullable = false)
	private GregorianCalendar registryDate;

	@ManyToOne
	@JoinColumn(name = "ID_PREDIO", nullable = false)
	private Building building;

	@OneToOne
	@JoinColumn(name = "ID_TELEFONE_RAMAL", nullable = true)
	private Phone phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public GregorianCalendar getRegistryDate() {
		return registryDate;
	}

	public void setRegistryDate(GregorianCalendar registryDate) {
		this.registryDate = registryDate;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
