package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using=BSOptionsDeserializer.class)
abstract class BSOptionsMixin extends BetaSeriesObjectMixin {
//	/** The notation enabled. */
//	@JsonProperty("notation")
//	boolean notationEnabled;
//
//	/** The downloaded enabled. */
//	@JsonProperty("dpwnloaded")
//	boolean downloadedEnabled;
//
//	/** The global enabled. */
//	@JsonProperty("global")
//	boolean globalEnabled;
//
//	/** The timelag enabled. */
//	@JsonProperty("timelag")
//	boolean timelagEnabled;
//
//	/** The friendship enabled. */
//	@JsonProperty("friendship")
//	boolean friendshipEnabled;
//
//	@JsonProperty("options.sources")
//	List<SubtitleSource> sources;
}
