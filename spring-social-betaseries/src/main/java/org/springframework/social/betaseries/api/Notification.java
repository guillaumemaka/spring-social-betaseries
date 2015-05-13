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
 * Represents an instance of {@code Notification}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public class Notification extends BetaSeriesObject {

	/** The notification id. */
	private final Long id;
	
	/** The notification type. */
	private final BSNotificationType type;
	
	/** The notification reference id. */
	private final String refId;
	
	/** The notification text. */
	private final String text;
	
	/** The notification in html format. */
	private final String html;
	
	/** The notification date. */
	private final Date date;
	
	/** The notification seen flag. */
	private final boolean seen;

	/**
	 * Instantiates a new {@code Notification}
	 *
	 * @param id  the notification id
	 * @param type  the type notificaction
	 * @param refId  the notification reference id
	 * @param text  the notification in text format
	 * @param html  the notifiaction in html format
	 * @param date  the notification date
	 * @param seen  the notification seen flag
	 */
	public Notification(Long id, BSNotificationType type, String refId,
			String text, String html, Date date, boolean seen) {
		super();
		this.id = id;
		this.type = type;
		this.refId = refId;
		this.text = text;
		this.html = html;
		this.date = date;
		this.seen = seen;
	}

	/**
	 * Gets the notification id.
	 *
	 * @return the notification id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Gets the notification type.
	 *
	 * @return the notification type
	 */
	public BSNotificationType getType() {
		return type;
	}

	/**
	 * Gets the notification reference id.
	 *
	 * @return the notification reference id
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * Gets the notification text.
	 *
	 * @return the notification text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the notification in html format.
	 *
	 * @return the notification in html
	 */
	public String getHtml() {
		return html;
	}


	/**
	 * Gets the notification date.
	 *
	 * @return the notification date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * Checks if the notification is seen.
	 *
	 * @return true, if is seen
	 */
	public boolean isSeen() {
		return seen;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((html == null) ? 0 : html.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((refId == null) ? 0 : refId.hashCode());
		result = prime * result + (seen ? 1231 : 1237);
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof Notification))
			return false;
		Notification other = (Notification) obj;
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
		if (refId == null) {
			if (other.refId != null)
				return false;
		} else if (!refId.equals(other.refId))
			return false;
		if (seen != other.seen)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notification [id=").append(id).append(", type=")
				.append(type).append(", refId=").append(refId)
				.append(", text=").append(text).append(", html=").append(html)
				.append(", date=").append(date).append(", seen=").append(seen)
				.append("]");
		return builder.toString();
	}		
}
