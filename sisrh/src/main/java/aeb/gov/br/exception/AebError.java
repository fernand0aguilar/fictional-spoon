package aeb.gov.br.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "There was an error on the server")
public class AebError extends AebException {

	private static final long serialVersionUID = 1233614394819112883L;

	public AebError() {
		super();
	}

	public AebError(String message) {
		super(message);
	}

	public AebError(String message, Throwable cause) {
		super(message, cause);
	}

	public AebError(Throwable cause) {
		super(cause);
	}
}
