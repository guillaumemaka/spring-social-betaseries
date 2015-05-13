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

import java.util.Date;

/**
 * Represents an instance of {@code Event}.
 * <p>
 * 
 * </p>
 *
 * @author Guillaume Maka
 */
public class Event extends BetaSeriesObject {
	
	/** The event id. */
	private final Integer id;
	
	/** The event type. */
	private final BSTimelineEventType type;
	
	/** The event ref. */
	private final String ref;
	
	/** The event ref id. */
	private final Integer refId;
	
	/** The event user. */
	private final String user;
	
	/** The event user id. */
	private final Integer userId;
	
	/** The event html representation. */
	private final String html;
	
	/** The event date. */
	private final Date date;

	/**
	 * Instantiates a new {@code Event}.
	 *
	 * @param id  the event id
	 * @param type  the event type
	 * @param ref  the event ref
	 * @param refId  the event ref id
	 * @param user  the event user
	 * @param userId  the event user id
	 * @param html  the event html representation
	 * @param date  the event date
	 */
	public Event(Integer id, BSTimelineEventType type, String ref,
			Integer refId, String user, Integer userId, String html, Date date) {
		super();
		this.id = id;
		this.type = type;
		this.ref = ref;
		this.refId = refId;
		this.user = user;
		this.userId = userId;
		this.html = html;
		this.date = date;
	}

	/**
	 * Gets event id.
	 *
	 * @return the event id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the event {@link BSTimelineEventType type}.
	 *
	 * @return the event type
	 */
	public BSTimelineEventType getType() {
		return type;
	}

	/**
	 * Gets the event ref.
	 *
	 * @return the event ref
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Gets the event ref id.
	 *
	 * @return the event ref id
	 */
	public Integer getRefId() {
		return refId;
	}

	/**
	 * Gets the event user.
	 *
	 * @return the event user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Gets the event user id.
	 *
	 * @return the event user id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Gets the event html representation.
	 *
	 * @return the event html representation
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * Gets the event date.
	 *
	 * @return the event date
	 */
	public Date getDate() {
		return date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((html == null) ? 0 : html.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result + ((refId == null) ? 0 : refId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Event))
			return false;
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (html == null) {
			if (other.html != null)
				return false;
		} else if (!html.equals(other.html))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		if (refId == null) {
			if (other.refId != null)
				return false;
		} else if (!refId.equals(other.refId))
			return false;
		if (type != other.type)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [id=").append(id).append(", type=").append(type)
				.append(", ref=").append(ref).append(", refId=").append(refId)
				.append(", user=").append(user).append(", userId=")
				.append(userId).append(", html=").append(html)
				.append(", date=").append(date).append("]");
		return builder.toString();
	}
}
