package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Recommendation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesRecommendationSingleObject extends
		AbstractBetaSeriesSingleObject<Recommendation> {
	
	@JsonCreator
	public BetaSeriesRecommendationSingleObject(@JsonProperty("recommendation") Recommendation object) {
		super(object);		
	}

}
