package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;

import org.springframework.social.betaseries.api.BSNotificationType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class NotificationMixin extends BetaSeriesObjectMixin {

	@JsonProperty("id")
	Long id;

	@JsonProperty("type")
	@JsonDeserialize(using=BSNotificationTypeDeserializer.class)
	BSNotificationType type;

	@JsonProperty("ref_id")
	String refId;

	@JsonProperty("text")
	String text;

	@JsonProperty("html")
	String html;

	@JsonProperty("date")
	@JsonDeserialize(using = BSNotificationDateDeserializer.class)
	Date date;

	@JsonProperty("seen")
	boolean seen;
}
