/**
 * Copyright 2015 Guillaume Maka
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.betaseries.api;

/**
 * The Enum BSMovieUserState.
 * <p>
 * Represents a movie state. 
 * </p>
 * @author Guillaume Maka
 */
public enum BSMovieUserState {
	
	/** The to see state. */
	TO_SEE("0"),
	
	/** The seen state. */
	SEEN("1"),
	
	/** The do not want to see state. */
	DO_NOT_WANT_TO_SEE("2"),
	
	/** The unkmow status state. */
	UNKMOW_STATUS("-1");
	
	/** The value. */
	private String value;
	
	/**
	 * Instantiates a new BS movie user state.
	 *
	 * @param value
	 *            the value
	 */
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
	
	/**
	 * From string.
	 *
	 * @param value
	 *            the value
	 * @return the BS movie user state
	 */
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
	
	/**
	 * Convert a {@code BSMovieUserState} state to its {@code String} representation.
	 *
	 * @param value  the value to set
	 * @return the string representation
	 */
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
