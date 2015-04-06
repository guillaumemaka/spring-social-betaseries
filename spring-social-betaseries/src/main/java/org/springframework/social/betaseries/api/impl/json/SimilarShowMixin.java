package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class SimilarShowMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	public SimilarShowMixin(
			@JsonProperty("id") int id, 
			@JsonProperty("show_title") String showTitle, 
			@JsonProperty("show_id") int showId, 
			@JsonProperty("thetvdb_id") int theTvDbId,
			@JsonProperty("login") String login, 
			@JsonProperty("login_id") int loginId, 
			@JsonProperty("notes") String notes) {}
}
