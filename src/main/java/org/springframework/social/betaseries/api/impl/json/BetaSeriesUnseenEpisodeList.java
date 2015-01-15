package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.UnseenEpisode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesUnseenEpisodeList extends
		AbstractBetaSeriesList<UnseenEpisode> {

	@JsonCreator
	public BetaSeriesUnseenEpisodeList(@JsonProperty("shows") List<UnseenEpisode> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}
}
