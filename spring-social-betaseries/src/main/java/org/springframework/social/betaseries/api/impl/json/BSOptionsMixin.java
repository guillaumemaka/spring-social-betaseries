package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.SubtitleSource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class BSOptionsMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	BSOptionsMixin(
			@JsonProperty("notation") boolean notationEnabled, 
			@JsonProperty("downloaded") boolean downloadedEnabled,
			@JsonProperty("global") boolean globalEnabled, 
			@JsonProperty("timelag") boolean timelagEnabled,
			@JsonProperty("friendship") boolean friendshipEnabled, 
			@JsonProperty("sources") List<SubtitleSource> sources
			) {}
}
