package aeb.gov.br.security;

import java.io.Serializable;

public class UserSession implements Serializable {

	private static final long serialVersionUID = -6722612681222839327L;

	private Long sessionUserId = 0L;

	public UserSession(final Long sessionUserId) {
		super();
		if (sessionUserId == null || sessionUserId.longValue() <= 0) {
			throw new IllegalArgumentException("sessionUserId");
		}
		this.sessionUserId = sessionUserId;
	}

	public Long getSessionUserId() {
		return sessionUserId;
	}
}