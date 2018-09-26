package aeb.gov.br.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_MODIFIED, reason = "The registry was not saved on the database")
public class AebErrorToInsertException extends AebException {

	private static final long serialVersionUID = -4928075427762848808L;

	public AebErrorToInsertException() {
		super();
	}

	public AebErrorToInsertException(String message) {
		super(message);
	}

	public AebErrorToInsertException(String message, Throwable cause) {
		super(message, cause);
	}

	public AebErrorToInsertException(Throwable cause) {
		super(cause);
	}
}
