package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;

import org.springframework.social.betaseries.api.BSUser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class MessageMixin extends BetaSeriesObjectMixin {
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
