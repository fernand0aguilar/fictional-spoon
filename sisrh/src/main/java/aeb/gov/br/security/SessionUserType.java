package aeb.gov.br.security;

public enum SessionUserType {

	NONE(0), ROOT(1), ADMIN(2), USER(3);

	private int typeCode;

	private SessionUserType(int typeCode) {
		this.typeCode = typeCode;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public static SessionUserType get(final int typeCode) {
		SessionUserType tipoUsuarioSessoa = NONE;
		for (final SessionUserType userType : values()) {
			if (userType.getTypeCode() == typeCode) {
				tipoUsuarioSessoa = userType;
				break;
			}
		}
		return tipoUsuarioSessoa;
	}

	public static boolean isRoot(final SessionUserType tipoUsuarioSessoa) {
		return ROOT.equals(tipoUsuarioSessoa);
	}

	public static boolean isAdmin(final SessionUserType tipoUsuarioSessoa) {
		return ADMIN.equals(tipoUsuarioSessoa);
	}

	public static boolean isUser(final SessionUserType tipoUsuarioSessoa) {
		return USER.equals(tipoUsuarioSessoa);
	}

	public static boolean isRoot(final int typeCode) {
		return ROOT.getTypeCode() == typeCode;
	}

	public static boolean isAdmin(final int typeCode) {
		return ADMIN.getTypeCode() == typeCode;
	}

	public static boolean isUser(final int typeCode) {
		return USER.getTypeCode() == typeCode;
	}
}