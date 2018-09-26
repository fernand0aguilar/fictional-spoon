package aeb.gov.br.model.personal;

import java.io.Serializable;
import java.util.GregorianCalendar;

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
import aeb.gov.br.model.outter.Company;

@Entity
@Table(name = "terceiro")
public class OutsideEmployee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -653061845433834731L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terceiro_id_seq")
	@SequenceGenerator(name = "terceiro_id_seq", sequenceName = "terceiro_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_TERCEIRO")
	private Long id;

	@Column(name = "DSC_CLT", nullable = false)
	private String clt;
	@Column(name = "DTA_EXPEDICAO_CLT", nullable = false)
	private GregorianCalendar cltExpedition;
	@Column(name = "DSC_ORGAO_CLT", nullable = false)
	private String cltCompany;
	@Column(name = "DTA_ENTRADA", nullable = false)
	private GregorianCalendar entryDate;
	@Column(name = "DTA_ATUALIZACAO", nullable = false)
	private GregorianCalendar updateDate = new GregorianCalendar();
	@Column(name = "BOL_ATIVO", nullable = false)
	private boolean active = true;
	@Column(name = "DTA_SAIDA", nullable = true)
	private GregorianCalendar exitDate;

	@ManyToOne
	@JoinColumn(name = "ID_UF", nullable = false)
	private UF uf;
	@ManyToOne
	@JoinColumn(name = "ID_EMPRESA", nullable = false)
	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClt() {
		return clt;
	}

	public void setClt(String clt) {
		this.clt = clt;
	}

	public GregorianCalendar getCltExpedition() {
		return cltExpedition;
	}

	public void setCltExpedition(GregorianCalendar cltExpedition) {
		this.cltExpedition = cltExpedition;
	}

	public String getCltCompany() {
		return cltCompany;
	}

	public void setCltCompany(String cltCompany) {
		this.cltCompany = cltCompany;
	}

	public GregorianCalendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(GregorianCalendar entryDate) {
		this.entryDate = entryDate;
	}

	public GregorianCalendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(GregorianCalendar updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public GregorianCalendar getExitDate() {
		return exitDate;
	}

	public void setExitDate(GregorianCalendar exitDate) {
		this.exitDate = exitDate;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
