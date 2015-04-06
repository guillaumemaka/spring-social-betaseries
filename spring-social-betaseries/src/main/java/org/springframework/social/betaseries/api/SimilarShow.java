package org.springframework.social.betaseries.api;

public class SimilarShow extends BetaSeriesObject {
	private final int id;
	private final String showTitle;
	private final int showId;
	private final int theTvDbId;
	private final String login;
	private final int loginId;
	private final String notes;
	/**
	 * @param id
	 * @param showTitle
	 * @param showId
	 * @param theTvDbId
	 * @param login
	 * @param loginId
	 * @param notes
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the showTitle
	 */
	public String getShowTitle() {
		return showTitle;
	}
	/**
	 * @return the showId
	 */
	public int getShowId() {
		return showId;
	}
	/**
	 * @return the theTvDbId
	 */
	public int getTheTvDbId() {
		return theTvDbId;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @return the login_id
	 */
	public int getLoginId() {
		return loginId;
	}
	/**
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
