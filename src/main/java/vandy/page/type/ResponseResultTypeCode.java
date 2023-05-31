package vandy.page.type;

public enum ResponseResultTypeCode {

	SUCCESS_MESSAGE("0000", "Success"), 
	UNSUCCESS_MESSAGE("9999", "Unsuccess");

	private String value;
	private String description;

	private ResponseResultTypeCode(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	public static ResponseResultTypeCode getReponseMessage(String errorCode) {

		ResponseResultTypeCode result = null;
		ResponseResultTypeCode[] values = ResponseResultTypeCode.values();
		for (ResponseResultTypeCode resultTypeCode : values) {
			if (resultTypeCode.getValue().equals(errorCode)) {
				result = resultTypeCode;
				break;
			}
		}
		return result;
	}
}
