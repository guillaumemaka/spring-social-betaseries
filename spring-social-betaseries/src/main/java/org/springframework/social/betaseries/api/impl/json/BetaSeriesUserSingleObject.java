package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.BSUser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesUserSingleObject extends
		AbstractBetaSeriesSingleObject<BSUser> {
	@JsonCreator
	public BetaSeriesUserSingleObject(@JsonProperty("user") BSUser object) {
		super(object);		
	}
}
