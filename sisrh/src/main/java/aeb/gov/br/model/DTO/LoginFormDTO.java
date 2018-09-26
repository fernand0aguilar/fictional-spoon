package aeb.gov.br.model.DTO;

import java.io.Serializable;

public class LoginFormDTO implements Serializable {

	private static final long serialVersionUID = -5218182321808420681L;
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
