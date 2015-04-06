package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Movie;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesMovieList extends AbstractBetaSeriesList<Movie> {
	@JsonCreator
	public BetaSeriesMovieList(@JsonProperty("movies") List<Movie> list) {
		super(list);		
	}
	
}
