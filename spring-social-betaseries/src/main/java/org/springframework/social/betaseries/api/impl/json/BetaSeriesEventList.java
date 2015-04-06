package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesEventList extends AbstractBetaSeriesList<Event> {
	@JsonCreator
	public BetaSeriesEventList(@JsonProperty("events") List<Event> list) {
		super(list);		
	}

}
