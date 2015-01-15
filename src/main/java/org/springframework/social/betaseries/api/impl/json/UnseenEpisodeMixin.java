package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Episode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class UnseenEpisodeMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	public UnseenEpisodeMixin(
			@JsonProperty("id") int showId, 
			@JsonProperty("thetvdb_id") int theTvDbId, 
			@JsonProperty("title") String title,
			@JsonProperty("remaining") int remaining, 
			@JsonProperty("unseen") List<Episode> episodes) {}
}
