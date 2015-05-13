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
 * Represents an instance of {@code Recommendation}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public class Recommendation extends BetaSeriesObject {
	
	/** The recommendation id. */
	private final int id;
	
	/** The recommendation from id. */
	private final int fromId;
	
	/** The recommendation to id. */
	private final int toId;
	
	/** The recommendation show id. */
	private final int showId;
	
	/** The recommendation status. */
	private final String status;
	
	/** The recommendation comments. */
	private final String comments;
	
	/**
	 * Instantiates a new {@code Recommendation}.
	 *
	 * @param id  the recommendation id
	 * @param fromId  the recommendation sender {@link Member#getMemberId() id}
	 * @param toId  the recommendation recipient to {@link Member#getMemberId() id}
	 * @param showId  the recommended show {@link Show#getId() id} 
	 * @param status  the recommendation status
	 * @param comments  the recommendation comments
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
	 * Gets recommendation the id.
	 *
	 * @return the recommendation id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the recommendation sender {@link Member#getMemberId() id}.
	 *
	 * @return the recommendation sender id
	 */
	public int getFromId() {
		return fromId;
	}
	
	/**
	 * Gets the recommendation recipient {@link Member#getMemberId() id}.
	 *
	 * @return the recommendation recipient id
	 */
	public int getToId() {
		return toId;
	}
	
	/**
	 * Gets the recommended show {@link Show#getId() id}.
	 *
	 * @return the recommended show id
	 */
	public int getShowId() {
		return showId;
	}
	
	/**
	 * Gets recommendation the status.
	 *
	 * @return the recommendation status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Gets the recommendation comments.
	 *
	 * @return the recommendation comments
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
