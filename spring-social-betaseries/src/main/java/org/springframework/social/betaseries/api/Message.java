package org.springframework.social.betaseries.api;

import java.util.Date;

public class Message extends BetaSeriesObject {
	private final int id;
	private final int messageId;
	private final int innerId;
	private final BSUser sender;
	private final BSUser recipient;
	private final Date date;
	private final String title;
	private final String text;
	private final boolean unread;
	private final boolean hasUnread;

	/**
	 * @param id
	 * @param messageId
	 * @param innerId
	 * @param sender
	 * @param recipient
	 * @param date
	 * @param title
	 * @param text
	 * @param unread
	 * @param hasUnread
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the messageId
	 */
	public int getMessageId() {
		return messageId;
	}

	/**
	 * @return the innerId
	 */
	public int getInnerId() {
		return innerId;
	}

	/**
	 * @return the sender
	 */
	public BSUser getSender() {
		return sender;
	}

	/**
	 * @return the recipient
	 */
	public BSUser getRecipient() {
		return recipient;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the unread
	 */
	public boolean isUnread() {
		return unread;
	}

	/**
	 * @return the hasUnread
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
