package aeb.gov.br.entities;

public class UserInfo implements Comparable<UserInfo> {

	private int id;
	private int workload;
	private int hourEntry;
	private int minuteEntry;
	private int hourExit;
	private int minuteExit;
	private String employeeName;
	private int lunchTime;
	private String matricula;

	private boolean active;

	public int getLunchTime() {
		return lunchTime;
	}

	public UserInfo() {
		super();
	}

	public void setLunchTime(int lunchTime) {
		this.lunchTime = lunchTime;
	}

	public UserInfo(int id) {
		this.id = id;
	}

	public UserInfo(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}

	public int getHourEntry() {
		return hourEntry;
	}

	public void setHourEntry(int hourEntry) {
		this.hourEntry = hourEntry;
	}

	public int getMinuteEntry() {
		return minuteEntry;
	}

	public void setMinuteEntry(int minuteEntry) {
		this.minuteEntry = minuteEntry;
	}

	public int getHourExit() {
		return hourExit;
	}

	public void setHourExit(int hourExit) {
		this.hourExit = hourExit;
	}

	public int getMinuteExit() {
		return minuteExit;
	}

	public void setMinuteExit(int minuteExit) {
		this.minuteExit = minuteExit;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int compareTo(UserInfo o) {
		return 0;
	}

	@Override
	@SuppressWarnings({ "squid:S1206", "squid:S2097" })
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else {
			UserInfo other = (UserInfo) object;
			if (this.employeeName.equals(other.getEmployeeName())) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	@SuppressWarnings({ "squid:S1206", "squid:S2097" })
	public int hashCode() {
		final int prime = 21;
		int result = 1;
		result = prime * result + id;
		return result;
	}

}
