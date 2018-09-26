package aeb.gov.br.exception;

public class AebException extends Exception {

	private static final long serialVersionUID = 5896062971380722072L;

	public AebException() {
		super();
	}

	public AebException(String message) {
		super(message);
	}

	public AebException(String message, Throwable cause) {
		super(message, cause);
	}

	public AebException(Throwable cause) {
		super(cause);
	}
}
