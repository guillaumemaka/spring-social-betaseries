package org.springframework.social.betaseries.api;

import java.util.Date;

public class Event extends BetaSeriesObject {
	private final Integer id;
	private final BSTimelineEventType type;
	private final String ref;
	private final Integer refId;
	private final String user;
	private final Integer userId;
	private final String html;
	private final Date date;

	/**
	 * @param id
	 * @param type
	 * @param ref
	 * @param refId
	 * @param user
	 * @param userId
	 * @param html
	 * @param date
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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public BSTimelineEventType getType() {
		return type;
	}

	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * @return the refId
	 */
	public Integer getRefId() {
		return refId;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * @return the date
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
