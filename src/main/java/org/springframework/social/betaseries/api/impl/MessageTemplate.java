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

public class MessageTemplate extends AbstractBetaSeriesOperations implements
		MessageOperations {
	private final RestTemplate restTemplate;

	public MessageTemplate(RestTemplate restTemolate, boolean isUserAuthorized,
			boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemolate;
	}

	public List<Message> getDiscussion(Integer firstMessageId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(firstMessageId));
		return restTemplate.getForObject(
				buildUri("messages/discussion", params),
				BetaSeriesMessageList.class).getList();
	}

	public List<Message> getMemberInbox() {
		return getMemberInbox(null);
	}

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

	public Message replyToMessage(Integer firstDiscussionMessageId,
			String text, String title) {
		return sendMessageTo(null, text, title, firstDiscussionMessageId);
	}

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

	public Message markMessageAsRead(Integer messageId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", messageId.toString());
		return restTemplate.postForObject(buildUri("messages/read"), params,
				BetaSeriesMessageSingleObject.class).getObject();
	}
}
