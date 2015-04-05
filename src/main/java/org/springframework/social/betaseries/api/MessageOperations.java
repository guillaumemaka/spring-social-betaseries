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

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageOperations.
 *
 * @author Guillaume Maka
 */
public interface MessageOperations {
	
	/**
	 * Gets the discussion.
	 *
	 * @param firstMessageId
	 *            the first message id
	 * @return the discussion
	 */
	List<Message> getDiscussion(Integer firstMessageId);
	
	/**
	 * Gets the member inbox.
	 *
	 * @return the member inbox
	 */
	List<Message> getMemberInbox();
	
	/**
	 * Gets the member inbox.
	 *
	 * @param page
	 *            the page
	 * @return the member inbox
	 */
	List<Message> getMemberInbox(Integer page);
	
	/**
	 * Reply to message.
	 *
	 * @param firstDiscussionMessageId
	 *            the first discussion message id
	 * @param text
	 *            the text
	 * @param title
	 *            the title
	 * @return the message
	 */
	Message replyToMessage(Integer firstDiscussionMessageId, String text, String title);
	
	/**
	 * Send message to.
	 *
	 * @param toMemberId
	 *            the to member id
	 * @param text
	 *            the text
	 * @param title
	 *            the title
	 * @param firstDiscussionMessageId
	 *            the first discussion message id
	 * @return the message
	 */
	Message sendMessageTo(Integer toMemberId, String text, String title, Integer firstDiscussionMessageId);
	
	/**
	 * Delete message.
	 *
	 * @param messageId
	 *            the message id
	 * @return the message
	 */
	Message deleteMessage(Integer messageId);
	
	/**
	 * Mark message as read.
	 *
	 * @param messageId
	 *            the message id
	 * @return the message
	 */
	Message markMessageAsRead(Integer messageId);
}
