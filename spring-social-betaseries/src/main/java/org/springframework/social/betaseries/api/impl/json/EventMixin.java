package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;

import org.springframework.social.betaseries.api.BSTimelineEventType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class EventMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	public EventMixin(
			@JsonProperty("id") Integer id, 
			@JsonProperty("type") @JsonDeserialize(using=BSTimelineEventTypeDeserializer.class) BSTimelineEventType type, 
			@JsonProperty("ref") String ref,
			@JsonProperty("ref_id") Integer refId, 
			@JsonProperty("user") String user, 
			@JsonProperty("user_id") Integer userId, 
			@JsonProperty("html") String html, 
			@JsonProperty("date") @JsonDeserialize(using=BSDateAndTimeDeserializer.class) Date date) {}
}
