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
 * TODO: Maybe Abstract Show ?
 * 
 * Represents an instance of {@code SimilarShow}.
 * <p>
 * This is a derived subset of {@code Show} properties returned by the Api {@code /show/similar}
 * endpoint. 
 * </p>
 *
 * @author Guillaume Maka
 */
public class SimilarShow extends BetaSeriesObject {
	
	/** The internal id. */
	private final int id;
	
	/** The show {@link Show#getTitle() title}. */
	private final String showTitle;
	
	/** The show {@link Show#getId() id}. */
	private final int showId;
	
	/** The show {@link Show#getTheTvDbId()) Tv Db id}. */
	private final int theTvDbId;
	
	/** The {@link Member#getLogin() login} member that mark the show as similar. */
	private final String login;
	
	/** The {@link Member#getMemberId() login id} member that mark the show as similar. */
	private final int loginId;
	
	/** The show notes. */
	private final String notes;
	
	/**
	 * Instantiates a new {@code SimilarShow}.
	 *
	 * @param id  the internal id
	 * @param showTitle  the show title
	 * @param showId  the show id
	 * @param theTvDbId  the show the tv db id
	 * @param login  the {@link Member#getLogin() login} member that mark the show as similar
	 * @param loginId  the {@link Member#getMemberId() login id} member that mark the show as similar
	 * @param notes  the show notes
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
	 * Gets the show id.
	 *
	 * @return the show id
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
	 * Gets the show tv db id.
	 *
	 * @return the show tv db id
	 */
	public int getTheTvDbId() {
		return theTvDbId;
	}
	
	/**
	 * Gets the member login who mark the show as similar.
	 *
	 * @return the member login
	 * @see Member#getMemberId()
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Gets the member login id who mark the show as similar.
	 *
	 * @return the member login id
	 * @see Member#getLogin()
	 */
	public int getLoginId() {
		return loginId;
	}
	
	/**
	 * Gets the show notes.
	 *
	 * @return the show notes
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
