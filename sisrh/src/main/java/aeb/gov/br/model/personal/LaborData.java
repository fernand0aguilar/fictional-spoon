package aeb.gov.br.model.personal;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dados_trabalhistas")
public class LaborData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4580120038986237337L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dados_trabalhistas_id_seq")
	@SequenceGenerator(name = "dados_trabalhistas_id_seq", sequenceName = "dados_trabalhistas_id_seq", allocationSize = 1, initialValue = 1000)
	@Column(name = "ID_DAODS_TRABALHISTAS")
	private Long id;

	@Column(name = "DTA_PRIMEIRO_EMPREGO", nullable = true)
	private GregorianCalendar firstJob;
	@Column(name = "DSC_PIS_PASEP", nullable = true)
	private String pisPasep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GregorianCalendar getFirstJob() {
		return firstJob;
	}

	public void setFirstJob(GregorianCalendar firstJob) {
		this.firstJob = firstJob;
	}

	public String getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

}
