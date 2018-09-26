package aeb.gov.br.entities;

import java.io.Serializable;

public class UserName implements Serializable {

	private static final long serialVersionUID = -1935353198932113266L;

	private String username;
	private String email;

	public UserName() {
		super();
	}

	public UserName(String username) {
		super();
		this.username = username;
	}

	public UserName(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
