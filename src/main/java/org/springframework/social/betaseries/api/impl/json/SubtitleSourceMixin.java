package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
abstract class SubtitleSourceMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	SubtitleSourceMixin(
			@JsonProperty("name") String name, 
			@JsonProperty("enabled") boolean enabled) {}
}
