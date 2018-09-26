package aeb.gov.br.entities;

import java.io.Serializable;

public class Phone implements Serializable {

	private static final long serialVersionUID = -5841128195422896804L;

	private String branchLine;
	private String cellPhone;
	private String homePhone;

	public String getBranchLine() {
		return branchLine;
	}

	public void setBranchLine(String branchLine) {
		this.branchLine = branchLine;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

}
