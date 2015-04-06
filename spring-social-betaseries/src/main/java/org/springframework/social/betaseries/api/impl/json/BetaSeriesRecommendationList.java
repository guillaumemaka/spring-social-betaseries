package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Recommendation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesRecommendationList extends AbstractBetaSeriesList<Recommendation> {
	
	@JsonCreator
	public BetaSeriesRecommendationList(@JsonProperty("recommendations") List<Recommendation> list) {
		super(list);		
	}

}
