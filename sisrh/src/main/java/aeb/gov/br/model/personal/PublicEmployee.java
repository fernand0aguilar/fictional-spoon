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

import aeb.gov.br.model.organizational.Coordination;
import aeb.gov.br.model.organizational.Directory;
import aeb.gov.br.model.organizational.Division;
import aeb.gov.br.model.outter.PublicCompany;

@Entity
@Table(name = "servidor")
public class PublicEmployee implements Serializable {

	private static final long serialVersionUID = 7814610664329813279L;

	@Id
	@Column(name = "ID_SERVIDOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servidor_id_seq")
	@SequenceGenerator(name = "servidor_id_seq", sequenceName = "servidor_id_seq", allocationSize = 1, initialValue = 1000)
	private Long id;

	@Column(name = "BOL_APOSENTADO", nullable = false)
	private boolean retired;
	@Column(name = "DTA_INGRESSO", nullable = false)
	private GregorianCalendar incomeDate;
	@Column(name = "DTA_ATO_NOMEACAO", nullable = false)
	private GregorianCalendar nominationDate;
	@Column(name = "DTA_PUBLICACAO_DOU", nullable = false)
	private GregorianCalendar publicationDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_DIRETORIA_ORIGEM", nullable = true)
	private Directory directoryFrom;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_COORDENACAO_ORIGEM", nullable = true)
	private Coordination coordinationFrom;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_DIVISAO_ORIGIM", nullable = true)
	private Division divisionFrom;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ORGAO", nullable = false)
	private PublicCompany publicCompany;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public GregorianCalendar getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(GregorianCalendar incomeDate) {
		this.incomeDate = incomeDate;
	}

	public GregorianCalendar getNominationDate() {
		return nominationDate;
	}

	public void setNominationDate(GregorianCalendar nominationDate) {
		this.nominationDate = nominationDate;
	}

	public GregorianCalendar getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(GregorianCalendar publicationDate) {
		this.publicationDate = publicationDate;
	}

	public PublicCompany getPublicCompany() {
		return publicCompany;
	}

	public void setPublicCompany(PublicCompany publicCompany) {
		this.publicCompany = publicCompany;
	}

	public Directory getDirectoryFrom() {
		return directoryFrom;
	}

	public void setDirectoryFrom(Directory directoryFrom) {
		this.directoryFrom = directoryFrom;
	}

}
