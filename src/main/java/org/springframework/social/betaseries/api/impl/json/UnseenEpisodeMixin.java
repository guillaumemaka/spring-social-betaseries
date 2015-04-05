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

import java.util.List;

import org.springframework.social.betaseries.api.Episode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class UnseenEpisodeMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class UnseenEpisodeMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new unseen episode mixin.
	 *
	 * @param showId
	 *            the show id
	 * @param theTvDbId
	 *            the the tv db id
	 * @param title
	 *            the title
	 * @param remaining
	 *            the remaining
	 * @param episodes
	 *            the episodes
	 */
	@JsonCreator
	public UnseenEpisodeMixin(
			@JsonProperty("id") int showId, 
			@JsonProperty("thetvdb_id") int theTvDbId, 
			@JsonProperty("title") String title,
			@JsonProperty("remaining") int remaining, 
			@JsonProperty("unseen") List<Episode> episodes) {}
}
