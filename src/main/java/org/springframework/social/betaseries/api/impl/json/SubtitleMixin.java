/**
 * Copyright 2015 Guillaume Maka
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;
import java.util.List;

import org.springframework.social.betaseries.api.Subtitle.EmbededEpisode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// TODO: Auto-generated Javadoc
/**
 * The Class SubtitleMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SubtitleMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new subtitle mixin.
	 *
	 * @param id
	 *            the id
	 * @param language
	 *            the language
	 * @param source
	 *            the source
	 * @param quality
	 *            the quality
	 * @param file
	 *            the file
	 * @param content
	 *            the content
	 * @param url
	 *            the url
	 * @param embededEpisode
	 *            the embeded episode
	 * @param date
	 *            the date
	 */
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
	
	/**
	 * The Class EmbededEpisodeMixin.
	 *
	 * @author Guillaume Maka
	 */
	@JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class EmbededEpisodeMixin extends BetaSeriesObjectMixin {
		
		/**
		 * Instantiates a new embeded episode mixin.
		 *
		 * @param showId
		 *            the show id
		 * @param episodeId
		 *            the episode id
		 * @param season
		 *            the season
		 * @param episode
		 *            the episode
		 */
		@JsonCreator
		public EmbededEpisodeMixin(
				@JsonProperty("show_id") int showId, 
				@JsonProperty("episode_id") int episodeId, 
				@JsonProperty("season") int season, 
				@JsonProperty("episode") int episode) {}
	}
}
