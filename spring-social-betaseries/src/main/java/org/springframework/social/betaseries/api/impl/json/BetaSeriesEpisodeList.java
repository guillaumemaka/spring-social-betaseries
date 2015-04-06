package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Episode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesEpisodeList extends AbstractBetaSeriesList<Episode> {	
	@JsonCreator
	public BetaSeriesEpisodeList(@JsonProperty("episodes") List<Episode> list) {
		super(list);
	}
}
