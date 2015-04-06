package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;
import java.util.List;

import org.springframework.social.betaseries.api.Subtitle.EmbededEpisode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SubtitleMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	SubtitleMixin(
			@JsonProperty("id") int id,
			@JsonProperty("language") String language,
			@JsonProperty("source") String source,
			@JsonProperty("quality") int quality,
			@JsonProperty("file") String file,
			@JsonProperty("content") List<String> content,
			@JsonProperty("url") String url,
			@JsonProperty("episode") EmbededEpisode embededEpisode,
			@JsonProperty("date") @JsonDeserialize(using = BSDateAndTimeDeserializer.class) Date date) {
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class EmbededEpisodeMixin extends BetaSeriesObjectMixin {
		@JsonCreator
		public EmbededEpisodeMixin(
				@JsonProperty("show_id") int showId, 
				@JsonProperty("episode_id") int episodeId, 
				@JsonProperty("season") int season, 
				@JsonProperty("episode") int episode) {}
	}
}
