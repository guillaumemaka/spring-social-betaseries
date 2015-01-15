package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Episode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesEpisodeSingleObject extends AbstractBetaSeriesSingleObject<Episode> {	
	@JsonCreator
	public BetaSeriesEpisodeSingleObject(@JsonProperty("episode") Episode object) {
		super(object);
	}
}
