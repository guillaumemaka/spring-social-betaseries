package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Movie.SummarizedMovie;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesSummarizedMovieList extends
		AbstractBetaSeriesList<SummarizedMovie> {	
	@JsonCreator
	public BetaSeriesSummarizedMovieList(@JsonProperty("movies") List<SummarizedMovie> list) {
		super(list);		
	}

}
