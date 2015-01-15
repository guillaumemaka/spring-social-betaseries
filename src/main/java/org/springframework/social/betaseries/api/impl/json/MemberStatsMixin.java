/**
 * Copyright 2014 the original author or authors
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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberStatsMixin.
 * 
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class MemberStatsMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new member stats mixin.
	 * 
	 * @param numberOfFriends
	 *            the number of friends
	 * @param numberOfShows
	 *            the number of shows
	 * @param numberOfSeasons
	 *            the number of seasons
	 * @param numberOfEpisodes
	 *            the number of episodes
	 * @param numberOfComments
	 *            the number of comments
	 * @param progress
	 *            the progress
	 * @param episodesToWatch
	 *            the episodes to watch
	 * @param timeOnTv
	 *            the time on tv
	 * @param timeToSpend
	 *            the time to spend
	 * @param badges
	 *            the badges
	 */
	@JsonCreator
	public MemberStatsMixin(
			@JsonProperty("friends") int numberOfFriends, 
			@JsonProperty("shows") int numberOfShows,
			@JsonProperty("seasons") int numberOfSeasons, 
			@JsonProperty("episodes") int numberOfEpisodes, 
			@JsonProperty("comments") int numberOfComments,
			@JsonProperty("progress") double progress, 
			@JsonProperty("episodes_to_watch") int episodesToWatch, 
			@JsonProperty("time_on_tv") int timeOnTv, 
			@JsonProperty("time_to_spend") int timeToSpend,
			@JsonProperty("badges") int badges){}
}
