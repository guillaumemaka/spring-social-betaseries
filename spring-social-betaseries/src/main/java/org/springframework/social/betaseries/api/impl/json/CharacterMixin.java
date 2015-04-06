package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CharacterMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	public CharacterMixin(
			@JsonProperty("id") int id, 
			@JsonProperty("show_id") int showId, 
			@JsonProperty("name") String name, 
			@JsonProperty("role") String role,
			@JsonProperty("actor") String actor, 
			@JsonProperty("picture") String pictureUrl, 
			@JsonProperty("description") String description) {}
}
