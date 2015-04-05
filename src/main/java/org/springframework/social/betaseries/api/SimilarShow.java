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

// TODO: Auto-generated Javadoc
/**
 * The Class SimilarShow.
 *
 * @author Guillaume Maka
 */
public class SimilarShow extends BetaSeriesObject {
	
	/** The id. */
	private final int id;
	
	/** The show title. */
	private final String showTitle;
	
	/** The show id. */
	private final int showId;
	
	/** The tv db id. */
	private final int theTvDbId;
	
	/** The login. */
	private final String login;
	
	/** The login id. */
	private final int loginId;
	
	/** The notes. */
	private final String notes;
	
	/**
	 * Instantiates a new similar show.
	 *
	 * @param id
	 *            the id
	 * @param showTitle
	 *            the show title
	 * @param showId
	 *            the show id
	 * @param theTvDbId
	 *            the the tv db id
	 * @param login
	 *            the login
	 * @param loginId
	 *            the login id
	 * @param notes
	 *            the notes
	 */
	public SimilarShow(int id, String showTitle, int showId, int theTvDbId,
			String login, int loginId, String notes) {
		super();
		this.id = id;
		this.showTitle = showTitle;
		this.showId = showId;
		this.theTvDbId = theTvDbId;
		this.login = login;
		this.loginId = loginId;
		this.notes = notes;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the show title.
	 *
	 * @return the show title
	 */
	public String getShowTitle() {
		return showTitle;
	}
	
	/**
	 * Gets the show id.
	 *
	 * @return the show id
	 */
	public int getShowId() {
		return showId;
	}
	
	/**
	 * Gets the the tv db id.
	 *
	 * @return the the tv db id
	 */
	public int getTheTvDbId() {
		return theTvDbId;
	}
	
	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Gets the login id.
	 *
	 * @return the login id
	 */
	public int getLoginId() {
		return loginId;
	}
	
	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + loginId;
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + showId;
		result = prime * result
				+ ((showTitle == null) ? 0 : showTitle.hashCode());
		result = prime * result + theTvDbId;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SimilarShow))
			return false;
		SimilarShow other = (SimilarShow) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (loginId != other.loginId)
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (showId != other.showId)
			return false;
		if (showTitle == null) {
			if (other.showTitle != null)
				return false;
		} else if (!showTitle.equals(other.showTitle))
			return false;
		if (theTvDbId != other.theTvDbId)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SimilarShow [id=").append(id).append(", showTitle=")
				.append(showTitle).append(", showId=").append(showId)
				.append(", theTvDbId=").append(theTvDbId).append(", login=")
				.append(login).append(", login_id=").append(loginId)
				.append(", notes=").append(notes).append("]");
		return builder.toString();
	}		
}
