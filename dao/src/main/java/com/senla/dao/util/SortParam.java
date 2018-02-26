package com.senla.dao.util;

public enum SortParam {
	NAME, ID, DATE, LECTURER_ID;

	/*private String value;

	private SortParam(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public SortParam getValueOf(String value) {
		SortParam[] sortParams = SortParam.values();
		for (int i = 0; i < sortParams.length; i++) {
			if (sortParams[i].getValue().equals(value)) {
				return sortParams[i];
			}
		}
		return null;
	}*/
}
