package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.BSOptions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesOptionsSingleObject extends
		AbstractBetaSeriesSingleObject<BSOptions> {
	
	@JsonCreator
	public BetaSeriesOptionsSingleObject(@JsonProperty("options") BSOptions object) {
		super(object);
	}

}
