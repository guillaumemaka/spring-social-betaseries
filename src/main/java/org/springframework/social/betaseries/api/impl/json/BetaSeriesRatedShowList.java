package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Show;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesRatedShowList extends AbstractBetaSeriesList<Show> {
	@JsonCreator
	public BetaSeriesRatedShowList(@JsonProperty("show") List<Show> list) {
		super(list);		
	}
}
