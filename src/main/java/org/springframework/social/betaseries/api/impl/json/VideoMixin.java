package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class VideoMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	public VideoMixin(
			@JsonProperty("id") int id, 
			@JsonProperty("show_id") int showId, 
			@JsonProperty("youtube_id") String youtubeId, 
			@JsonProperty("youtube_url") String youtubeUrl,
			@JsonProperty("title") String title, 
			@JsonProperty("season") int season, 
			@JsonProperty("episode") int episode, 
			@JsonProperty("login") String login, 
			@JsonProperty("login_id") int loginId) {
	}
}
