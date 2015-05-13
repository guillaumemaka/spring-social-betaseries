/**
 * Copyright 2014 the original author or authors
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

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Represents an instance of {@code Comment} for an element (e.g: episode|show|member|movie)
 *  
 * @author Guillaume Maka
 */
public class Comment extends BetaSeriesObject implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The comment id. */
	private final int id;	
	
	/** The comment user id. */
	private final int userId;
	
	/** The comment user login. */
	private final String login;
	
	private final String avatarUrl;
	
	/** The comment created at date. */
	private final Date createdAt;
	
	/** The comment text. */
	private final String text;
	
	/** The comment inner id. */
	private final int innerId;
	
	/** The in reply to comment id. */
	private final int inReplyTo;
	
	/** The number of replies */
	private final int numberOfReplies;
	
	/**
	 * Instantiates a new @{code Comment}.
	 * 
	 * @param id  the comment id
	 * @param userId  the comment user id
	 * @param login  the comment user login
	 * @param createdAt  the comment created at date
	 * @param text  the comment text
	 * @param innerId  the comment inner id
	 * @param inReplyTo  the comment in reply to
	 */
	public Comment(int id, int userId, String login,String avatarUrl, Date createdAt,
			String text, int innerId, int inReplyTo, int numberOfReplies) {
		super();
		this.id = id;
		this.userId = userId;
		this.login = login;
		this.avatarUrl = avatarUrl;
		this.createdAt = createdAt;
		this.text = text;
		this.innerId = innerId;
		this.inReplyTo = inReplyTo;
		this.numberOfReplies = numberOfReplies;
	}

	/**
	 * Gets the comment {@code id}.
	 * 
	 * @return the comment {@code id}.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Gets the user login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Gets the avatar url.
	 * 
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * Gets the comment created at date.
	 * 
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Gets the comment text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the comment inner id.
	 * 
	 * @return the innerId
	 */
	public int getInnerId() {
		return innerId;
	}

	/**
	 * Gets the comment in reply to id.
	 * 
	 * @return the inReplyTo
	 */
	public int getInReplyTo() {
		return inReplyTo;
	}

	/**
	 * Gets number of replies for this comment.
	 * 
	 * @return the numberOfReplies
	 */
	public int getNumberOfReplies() {
		return numberOfReplies;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((avatarUrl == null) ? 0 : avatarUrl.hashCode());
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + inReplyTo;
		result = prime * result + innerId;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + numberOfReplies;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + userId;
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
		if (!(obj instanceof Comment))
			return false;
		Comment other = (Comment) obj;
		if (avatarUrl == null) {
			if (other.avatarUrl != null)
				return false;
		} else if (!avatarUrl.equals(other.avatarUrl))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (inReplyTo != other.inReplyTo)
			return false;
		if (innerId != other.innerId)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (numberOfReplies != other.numberOfReplies)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [id=").append(id).append(", userId=")
				.append(userId).append(", login=").append(login)
				.append(", avatarUrl=").append(avatarUrl)
				.append(", createdAt=").append(createdAt).append(", text=")
				.append(text).append(", innerId=").append(innerId)
				.append(", inReplyTo=").append(inReplyTo)
				.append(", numberOfReplies=").append(numberOfReplies)
				.append("]");
		return builder.toString();
	}	
}
