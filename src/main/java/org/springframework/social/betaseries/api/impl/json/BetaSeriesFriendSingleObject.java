package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Friend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesFriendSingleObject extends
		AbstractBetaSeriesSingleObject<Friend> {
	@JsonCreator
	public BetaSeriesFriendSingleObject(@JsonProperty("friend") Friend object) {
		super(object);		
	}

}
