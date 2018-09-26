package aeb.gov.br.entities;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 6687908015212734796L;

	private String name;
	private String title;
	private String accountName;
	private String bossName;
	private Phone phone;
	private InsideCompanyLocation insideCompanyLocation;
	private String comumName;
	private String path;
	private Department department;
	private Address address;
	private long userStatus;
	private List<String> groups;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public InsideCompanyLocation getInsideCompanyLocation() {
		return insideCompanyLocation;
	}

	public void setInsideCompanyLocation(InsideCompanyLocation insideCompanyLocation) {
		this.insideCompanyLocation = insideCompanyLocation;
	}

	public String getComumName() {
		return comumName;
	}

	public void setComumName(String comumName) {
		this.comumName = comumName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(long userStatus) {
		this.userStatus = userStatus;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

}
