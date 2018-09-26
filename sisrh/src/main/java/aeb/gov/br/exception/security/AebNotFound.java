package aeb.gov.br.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import aeb.gov.br.exception.AebException;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This user is not registered on the system")
public class AebNotFound extends AebException {

	private static final long serialVersionUID = 6435218763820162796L;

	public AebNotFound() {
		super();
	}

	public AebNotFound(String message) {
		super(message);
	}

	public AebNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public AebNotFound(Throwable cause) {
		super(cause);
	}
}
