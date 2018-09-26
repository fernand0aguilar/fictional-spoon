package aeb.gov.br.model.personal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import aeb.gov.br.model.localization.UF;

@Entity
@Table(name = "documento_militar")
public class MilitaryDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2430530365924400431L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_militar_id_seq")
	@SequenceGenerator(name = "documento_militar_id_seq", sequenceName = "documento_militar_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_DOCUMENTO_MILITAR")
	private Long id;

	@Column(name = "DSC_NUMERO_RESERVISTA", nullable = false)
	private String number;
	@Column(name = "DSC_SERIE_RESERVISTA", nullable = false)
	private String series;
	@Column(name = "DSC_CATEGORIA_RESERVISTA", nullable = false)
	private String category;

	@ManyToOne
	@JoinColumn(name = "ID_UF", nullable = false)
	private UF uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
