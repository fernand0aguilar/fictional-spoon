package aeb.gov.br.model.telephony;

public enum EnumPhoneCategory {

	CELL(1L), HOME(2L), FAX(3L), INTERNAL(4L), COMERCIAL(5L);

	private Long typeCode;

	private EnumPhoneCategory(Long typeCode) {
		this.typeCode = typeCode;
	}

	public Long getTypeCode() {
		return typeCode;
	}

}
