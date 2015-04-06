package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Movie;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesMovieSingleObject extends
		AbstractBetaSeriesSingleObject<Movie> {
	@JsonCreator
	public BetaSeriesMovieSingleObject(@JsonProperty("movie") Movie object) {
		super(object);		
	}
}
