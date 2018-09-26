package aeb.gov.br.model.telephony;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_telefone")
public class PhoneCategory implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -9156835765931601072L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_telefone_id_seq")
	@SequenceGenerator(name = "categoria_telefone_id_seq", sequenceName = "categoria_telefone_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_CATEGORIA_TELEFONE")
	private Long id;

	@Column(name = "DSC_CATEGORIA_TELEFONE", nullable = false)
	private String category;

	public PhoneCategory() {
		super();
	}

	public PhoneCategory(EnumPhoneCategory category) {
		this.id = category.getTypeCode();
	}

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

}
