package aeb.gov.br.entities;

import java.io.Serializable;

public class InsideCompanyLocation implements Serializable {
	private static final long serialVersionUID = 364159036330562389L;
	
	private String building;
	private String floor;
	private String room;
	
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	
}