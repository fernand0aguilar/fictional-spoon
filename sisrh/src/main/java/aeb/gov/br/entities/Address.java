package aeb.gov.br.entities;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = -8806507065176159374L;
	private String postalCode;
	private String streetAddress;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}
