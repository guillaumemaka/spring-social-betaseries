/**
 * Copyright 2015 [name of copyright owner]
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
package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;

import org.springframework.social.betaseries.api.BSUser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class MessageMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new message mixin.
	 *
	 * @param id the id
	 * @param messageId the message id
	 * @param innerId the inner id
	 * @param sender the sender
	 * @param recipient the recipient
	 * @param date the date
	 * @param title the title
	 * @param text the text
	 * @param unread the unread
	 * @param hasUnread the has unread
	 */
	@JsonCreator
	public MessageMixin(
			@JsonProperty("id") int id, 
			@JsonProperty("message_id") int messageId, 
			@JsonProperty("inner_id") int innerId, 
			@JsonProperty("sender") BSUser sender,
			@JsonProperty("recipient") BSUser recipient, 
			@JsonProperty("date") @JsonDeserialize(using=BSDateAndTimeDeserializer.class) Date date, 
			@JsonProperty("title") String title, 
			@JsonProperty("text") String text,
			@JsonProperty("unread") boolean unread, 
			@JsonProperty("has_unread") boolean hasUnread) {}
}
