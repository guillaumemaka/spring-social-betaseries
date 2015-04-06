package org.springframework.social.betaseries.api;

public enum BSMovieUserState {
	TO_SEE("0"),
	SEEN("1"),
	DO_NOT_WANT_TO_SEE("2"),
	UNKMOW_STATUS("-1");
	
	private String value;
	
	BSMovieUserState(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		if(value.equalsIgnoreCase("0")) {
			return "TO_SEE";
		}else if(value.equalsIgnoreCase("1")) {
			return "SEEN";
		}else if(value.equalsIgnoreCase("2")) {
			return "DO_NOT_WANT_TO_SEE";
		}else {
			return "UNKMOW_STATUS";
		}				
	}	
	
	public static BSMovieUserState fromString(String value) {
		if(value.equalsIgnoreCase("0")) {
			return TO_SEE;
		}else if(value.equalsIgnoreCase("1")) {
			return SEEN;
		}else if(value.equalsIgnoreCase("2")) {
			return DO_NOT_WANT_TO_SEE;
		}else {
			return UNKMOW_STATUS;
		}
	}
	
	public static String fromEnum(BSMovieUserState value) {
		if(value == TO_SEE) {
			return "0";
		}else if(value == SEEN) {
			return "1";
		}else if(value == DO_NOT_WANT_TO_SEE) {
			return "2";
		}else {
			return "-1";
		}
	}
}
