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
@Table(name = "documento_eleitoral")
public class ElectionDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9058956252673642485L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_eleitoral_id_seq")
	@SequenceGenerator(name = "documento_eleitoral_id_seq", sequenceName = "document_eleitoral_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_DOCUMENTO_ELEITORAL")
	private Long id;

	@Column(name = "DSC_TITULO_ELEITOR", nullable = true)
	private String title;
	@Column(name = "DSC_SECAO_TITULO_ELEITOR", nullable = true)
	private String section;
	@Column(name = "DSC_ZONA_TITULO_ELEITOR", nullable = true)
	private String zone;

	@ManyToOne
	@JoinColumn(name = "ID_UF", nullable = true)
	private UF uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

}
