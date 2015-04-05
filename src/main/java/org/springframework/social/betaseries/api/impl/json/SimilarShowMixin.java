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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class SimilarShowMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class SimilarShowMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new similar show mixin.
	 *
	 * @param id
	 *            the id
	 * @param showTitle
	 *            the show title
	 * @param showId
	 *            the show id
	 * @param theTvDbId
	 *            the the tv db id
	 * @param login
	 *            the login
	 * @param loginId
	 *            the login id
	 * @param notes
	 *            the notes
	 */
	@JsonCreator
	public SimilarShowMixin(
			@JsonProperty("id") int id, 
			@JsonProperty("show_title") String showTitle, 
			@JsonProperty("show_id") int showId, 
			@JsonProperty("thetvdb_id") int theTvDbId,
			@JsonProperty("login") String login, 
			@JsonProperty("login_id") int loginId, 
			@JsonProperty("notes") String notes) {}
}
