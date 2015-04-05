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

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 *
 * @author Guillaume Maka
 */
public class Message extends BetaSeriesObject {
	
	/** The id. */
	private final int id;
	
	/** The message id. */
	private final int messageId;
	
	/** The inner id. */
	private final int innerId;
	
	/** The sender. */
	private final BSUser sender;
	
	/** The recipient. */
	private final BSUser recipient;
	
	/** The date. */
	private final Date date;
	
	/** The title. */
	private final String title;
	
	/** The text. */
	private final String text;
	
	/** The unread. */
	private final boolean unread;
	
	/** The has unread. */
	private final boolean hasUnread;

	/**
	 * Instantiates a new message.
	 *
	 * @param id
	 *            the id
	 * @param messageId
	 *            the message id
	 * @param innerId
	 *            the inner id
	 * @param sender
	 *            the sender
	 * @param recipient
	 *            the recipient
	 * @param date
	 *            the date
	 * @param title
	 *            the title
	 * @param text
	 *            the text
	 * @param unread
	 *            the unread
	 * @param hasUnread
	 *            the has unread
	 */
	public Message(int id, int messageId, int innerId, BSUser sender,
			BSUser recipient, Date date, String title, String text,
			boolean unread, boolean hasUnread) {
		super();
		this.id = id;
		this.messageId = messageId;
		this.innerId = innerId;
		this.sender = sender;
		this.recipient = recipient;
		this.date = date;
		this.title = title;
		this.text = text;
		this.unread = unread;
		this.hasUnread = hasUnread;
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
	 * Gets the message id.
	 *
	 * @return the message id
	 */
	public int getMessageId() {
		return messageId;
	}

	/**
	 * Gets the inner id.
	 *
	 * @return the inner id
	 */
	public int getInnerId() {
		return innerId;
	}

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public BSUser getSender() {
		return sender;
	}

	/**
	 * Gets the recipient.
	 *
	 * @return the recipient
	 */
	public BSUser getRecipient() {
		return recipient;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Checks if is unread.
	 *
	 * @return true, if is unread
	 */
	public boolean isUnread() {
		return unread;
	}

	/**
	 * Checks for unread.
	 *
	 * @return true, if successful
	 */
	public boolean hasUnread() {
		return hasUnread;
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
		result = prime * result + (hasUnread ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + innerId;
		result = prime * result + messageId;
		result = prime * result
				+ ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (unread ? 1231 : 1237);
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
		if (!(obj instanceof Message))
			return false;
		Message other = (Message) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hasUnread != other.hasUnread)
			return false;
		if (id != other.id)
			return false;
		if (innerId != other.innerId)
			return false;
		if (messageId != other.messageId)
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (unread != other.unread)
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
		builder.append("Message [id=").append(id).append(", messageId=")
				.append(messageId).append(", innerId=").append(innerId)
				.append(", sender=").append(sender).append(", recipient=")
				.append(recipient).append(", date=").append(date)
				.append(", title=").append(title).append(", text=")
				.append(text).append(", unread=").append(unread)
				.append(", hasUnread=").append(hasUnread).append("]");
		return builder.toString();
	}

}
