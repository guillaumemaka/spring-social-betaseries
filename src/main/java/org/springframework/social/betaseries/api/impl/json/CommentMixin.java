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
package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentMixin.
 * 
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CommentMixin extends BetaSeriesObjectMixin {
	/**
	 * Instantiates a new comment mixin.
	 * 
	 * @param id
	 *            the id
	 * @param userId
	 *            the user id
	 * @param login
	 *            the login
	 * @param avatar
	 *            the avatar
	 * @param createdAt
	 *            the created at
	 * @param text
	 *            the text
	 * @param innerId
	 *            the inner id
	 * @param inReplyTo
	 *            the in reply to
	 */
	@JsonCreator
	public CommentMixin(
			@JsonProperty("id") int id,
			@JsonProperty("user_id") int userId,
			@JsonProperty("login") String login,
			@JsonProperty("avatar") String avatarUrl,
			@JsonProperty("date") @JsonDeserialize(using = BSDateAndTimeDeserializer.class) Date createdAt,
			@JsonProperty("text") String text,
			@JsonProperty("inner_id") int innerId,
			@JsonProperty("in_reply_to") int inReplyTo,
			@JsonProperty("replies") int numberOfReplies) {
	}
}
