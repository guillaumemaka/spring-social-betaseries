package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
abstract class RecommendationMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	public RecommendationMixin(
			@JsonProperty("id") int id, 
			@JsonProperty("from_id") int fromId, 
			@JsonProperty("to_id") int toId, 
			@JsonProperty("show_id") int showId,
			@JsonProperty("status") String status, 
			@JsonProperty("comments") String comments) {}
}
