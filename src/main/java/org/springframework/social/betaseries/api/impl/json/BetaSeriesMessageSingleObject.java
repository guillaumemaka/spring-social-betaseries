package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesMessageSingleObject extends
		AbstractBetaSeriesSingleObject<Message> {
	@JsonCreator
	public BetaSeriesMessageSingleObject(@JsonProperty("message") Message object) {
		super(object);		
	}

}
