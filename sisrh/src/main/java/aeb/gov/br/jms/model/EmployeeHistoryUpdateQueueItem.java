package aeb.gov.br.jms.model;

import java.io.Serializable;

public class EmployeeHistoryUpdateQueueItem implements Serializable {

	private static final long serialVersionUID = -6241960219734803070L;

	private Long idEmployee;

	public EmployeeHistoryUpdateQueueItem() {
		super();
	}

	public EmployeeHistoryUpdateQueueItem(Long idEmployee) {
		super();
		this.idEmployee = idEmployee;
	}

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

}
