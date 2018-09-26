package aeb.gov.br.jms.config;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Francisco Tarcizo Bomfim Júnior
 *
 */
@Component
@Scope("request")
public class EmailHostServerConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8399750109471709351L;

	private boolean https;
	private String domain;

	public EmailHostServerConfig() {
		super();
	}

	public boolean isHttps() {
		return https;
	}

	public void setHttps(boolean https) {
		this.https = https;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
