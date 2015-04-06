package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Notification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesNotificationList extends AbstractBetaSeriesList<Notification> {
	@JsonCreator
	public BetaSeriesNotificationList(@JsonProperty("notifications") List<Notification> list) {
		super(list);		
	}
}
