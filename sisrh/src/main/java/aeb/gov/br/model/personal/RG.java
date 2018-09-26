package aeb.gov.br.model.personal;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import aeb.gov.br.model.localization.UF;

@Entity
@Table(name = "rg")
public class RG implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3205634380725908689L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rg_id_seq")
	@SequenceGenerator(name = "rg_id_seq", sequenceName = "rg_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_RG")
	private Long id;

	@Column(name = "DSC_RG", nullable = false)
	private String rg;
	@Column(name = "DSC_ORGAO_EMISSOR", nullable = false)
	private String issuingCompany;
	@Column(name = "DTA_EXPEDICAO", nullable = false)
	private GregorianCalendar expeditionDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UF", nullable = true)
	private UF uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getIssuingCompany() {
		return issuingCompany;
	}

	public void setIssuingCompany(String issuingCompany) {
		this.issuingCompany = issuingCompany;
	}

	public GregorianCalendar getExpeditionDate() {
		return expeditionDate;
	}

	public void setExpeditionDate(GregorianCalendar expeditionDate) {
		this.expeditionDate = expeditionDate;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

}
