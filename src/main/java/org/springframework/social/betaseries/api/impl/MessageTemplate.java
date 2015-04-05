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
package org.springframework.social.betaseries.api.impl;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.social.betaseries.api.Message;
import org.springframework.social.betaseries.api.MessageOperations;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesMessageList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesMessageSingleObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageTemplate.
 *
 * @author Guillaume Maka
 */
public class MessageTemplate extends AbstractBetaSeriesOperations implements
		MessageOperations {
	
	/** The rest template. */
	private final RestTemplate restTemplate;

	/**
	 * Instantiates a new message template.
	 *
	 * @param restTemolate
	 *            the rest temolate
	 * @param isUserAuthorized
	 *            the is user authorized
	 * @param isAppAuthorized
	 *            the is app authorized
	 */
	public MessageTemplate(RestTemplate restTemolate, boolean isUserAuthorized,
			boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemolate;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MessageOperations#getDiscussion(java.lang.Integer)
	 */
	public List<Message> getDiscussion(Integer firstMessageId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(firstMessageId));
		return restTemplate.getForObject(
				buildUri("messages/discussion", params),
				BetaSeriesMessageList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MessageOperations#getMemberInbox()
	 */
	public List<Message> getMemberInbox() {
		return getMemberInbox(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MessageOperations#getMemberInbox(java.lang.Integer)
	 */
	public List<Message> getMemberInbox(Integer page) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		if (page != null) {
			if (page > 1) {
				params.set("page", String.valueOf(page));
			}
		}

		return restTemplate.getForObject(buildUri("messages/inbox", params),
				BetaSeriesMessageList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MessageOperations#replyToMessage(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	public Message replyToMessage(Integer firstDiscussionMessageId,
			String text, String title) {
		return sendMessageTo(null, text, title, firstDiscussionMessageId);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MessageOperations#sendMessageTo(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer)
	 */
	public Message sendMessageTo(Integer toMemberId, String text, String title,
			Integer firstDiscussionMessageId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		if (toMemberId != null) {
			params.set("to", toMemberId.toString());
		}

		params.set("text", text);
		params.set("title", title);

		if (firstDiscussionMessageId != null) {
			params.set("id", firstDiscussionMessageId.toString());

			if (params.containsKey("to")) {
				params.remove("to");
			}
		}

		return restTemplate.postForObject(buildUri("messages/message"), params,
				BetaSeriesMessageSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MessageOperations#deleteMessage(java.lang.Integer)
	 */
	public Message deleteMessage(Integer messageId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", messageId.toString());
		return restTemplate
				.exchange(buildUri("messages/message", params),
						HttpMethod.DELETE, null,
						BetaSeriesMessageSingleObject.class).getBody()
				.getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MessageOperations#markMessageAsRead(java.lang.Integer)
	 */
	public Message markMessageAsRead(Integer messageId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", messageId.toString());
		return restTemplate.postForObject(buildUri("messages/read"), params,
				BetaSeriesMessageSingleObject.class).getObject();
	}
}
