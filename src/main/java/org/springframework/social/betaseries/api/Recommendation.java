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
 * The Class Recommendation.
 *
 * @author Guillaume Maka
 */
public class Recommendation extends BetaSeriesObject {
	
	/** The id. */
	private final int id;
	
	/** The from id. */
	private final int fromId;
	
	/** The to id. */
	private final int toId;
	
	/** The show id. */
	private final int showId;
	
	/** The status. */
	private final String status;
	
	/** The comments. */
	private final String comments;
	
	/**
	 * Instantiates a new recommendation.
	 *
	 * @param id
	 *            the id
	 * @param fromId
	 *            the from id
	 * @param toId
	 *            the to id
	 * @param showId
	 *            the show id
	 * @param status
	 *            the status
	 * @param comments
	 *            the comments
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the from id.
	 *
	 * @return the from id
	 */
	public int getFromId() {
		return fromId;
	}
	
	/**
	 * Gets the to id.
	 *
	 * @return the to id
	 */
	public int getToId() {
		return toId;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Gets the comments.
	 *
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
