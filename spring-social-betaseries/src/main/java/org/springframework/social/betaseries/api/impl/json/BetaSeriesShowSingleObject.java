package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Show;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesShowSingleObject extends
		AbstractBetaSeriesSingleObject<Show> {
	@JsonCreator
	public BetaSeriesShowSingleObject(@JsonProperty("show") Show object) {
		super(object);		
	}
}
