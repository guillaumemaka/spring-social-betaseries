package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesAvailableUsernamesObject extends
		AbstractBetaSeriesSingleObject<String[]> {
	@JsonCreator
	public BetaSeriesAvailableUsernamesObject(@JsonProperty("usernames") String[] object) {
		super(object);
		// TODO Auto-generated constructor stub
	}
}
