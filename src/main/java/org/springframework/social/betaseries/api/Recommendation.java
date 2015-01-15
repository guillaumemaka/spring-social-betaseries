package org.springframework.social.betaseries.api;

public class Recommendation extends BetaSeriesObject {
	private final int id;
	private final int fromId;
	private final int toId;
	private final int showId;
	private final String status;
	private final String comments;
	/**
	 * @param id
	 * @param fromId
	 * @param toId
	 * @param showId
	 * @param status
	 * @param comments
	 */
	public Recommendation(int id, int fromId, int toId, int showId,
			String status, String comments) {
		super();
		this.id = id;
		this.fromId = fromId;
		this.toId = toId;
		this.showId = showId;
		this.status = status;
		this.comments = comments;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the fromId
	 */
	public int getFromId() {
		return fromId;
	}
	/**
	 * @return the toId
	 */
	public int getToId() {
		return toId;
	}
	/**
	 * @return the showId
	 */
	public int getShowId() {
		return showId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + fromId;
		result = prime * result + id;
		result = prime * result + showId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + toId;
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
		if (!(obj instanceof Recommendation))
			return false;
		Recommendation other = (Recommendation) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (fromId != other.fromId)
			return false;
		if (id != other.id)
			return false;
		if (showId != other.showId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (toId != other.toId)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recommendation [id=").append(id).append(", fromId=")
				.append(fromId).append(", toId=").append(toId)
				.append(", showId=").append(showId).append(", status=")
				.append(status).append(", comments=").append(comments)
				.append("]");
		return builder.toString();
	}	
}
