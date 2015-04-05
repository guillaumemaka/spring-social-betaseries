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

import org.springframework.social.betaseries.api.Note;
import org.springframework.social.betaseries.api.Show.SeasonDetail;
import org.springframework.social.betaseries.api.Show.UserDetail;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ShowMixin extends BetaSeriesObjectMixin {

	/**
	 * Instantiates a new show mixin.
	 *
	 * @param id
	 *            the id
	 * @param theTvDbId
	 *            the the tv db id
	 * @param imDbId
	 *            the im db id
	 * @param title
	 *            the title
	 * @param description
	 *            the description
	 * @param seasons
	 *            the seasons
	 */
	@JsonCreator
	ShowMixin(@JsonProperty("id") int id,
			@JsonProperty("thetvdb_id") int theTvDbId,
			@JsonProperty("imdb_id") String imDbId,
			@JsonProperty("title") String title,
			@JsonProperty("description") String description,
			@JsonProperty("seasons") String seasons) {
	}

	/** The seasons details. */
	@JsonProperty("seasons_details")
	List<SeasonDetail> seasonsDetails;

	/** The number of episodes. */
	@JsonProperty("episodes")
	String numberOfEpisodes;

	/** The number of followers. */
	@JsonProperty("followers")
	String numberOfFollowers;

	/** The number of comments. */
	@JsonProperty("comments")
	String numberOfComments;

	/** The similars. */
	@JsonProperty("similars")
	String similars;

	/** The characters. */
	@JsonProperty("characters")
	String characters;

	/** The years of production. */
	@JsonProperty("creation")
	String yearsOfProduction;

	/** The genres. */
	@JsonProperty("genres")
	String[] genres;

	/** The episode length. */
	@JsonProperty("length")
	String episodeLength;

	/** The network. */
	@JsonProperty("network")
	String network;

	/** The rating. */
	@JsonProperty("rating")
	String rating;

	/** The status. */
	@JsonProperty("status")
	String status;

	/** The language. */
	@JsonProperty("language")
	String language;

	/** The note. */
	@JsonProperty("notes")
	Note note;

	/** The in account. */
	@JsonProperty("in_account")
	Note inAccount;

	/** The user detail. */
	@JsonProperty("user")
	UserDetail userDetail;

	/** The resource url. */
	@JsonProperty("resource_url")
	String resourceUrl;
	
	/**
	 * The Class SeasonDetailMixin.
	 *
	 * @author Guillaume Maka
	 */
	@JsonIgnoreProperties(ignoreUnknown=true)
	static abstract class SeasonDetailMixin extends BetaSeriesObjectMixin {
		
		/**
		 * Instantiates a new season detail mixin.
		 *
		 * @param seasonNumber
		 *            the season number
		 * @param numberOfEpisode
		 *            the number of episode
		 */
		@JsonCreator
		public SeasonDetailMixin(
				@JsonProperty("number") int seasonNumber, 
				@JsonProperty("episodes") int numberOfEpisode) {}
	}
	
	/**
	 * The Class UserDetailMixin.
	 *
	 * @author Guillaume Maka
	 */
	@JsonIgnoreProperties(ignoreUnknown=true)
	static abstract class UserDetailMixin extends BetaSeriesObjectMixin {
		
		/**
		 * Instantiates a new user detail mixin.
		 *
		 * @param archived
		 *            the archived
		 * @param favorited
		 *            the favorited
		 * @param remaining
		 *            the remaining
		 * @param status
		 *            the status
		 * @param last
		 *            the last
		 * @param tags
		 *            the tags
		 */
		@JsonCreator
		public UserDetailMixin(
				@JsonProperty("archived") boolean archived, 
				@JsonProperty("favorited") boolean favorited, 
				@JsonProperty("remaining") String remaining,
				@JsonProperty("status") String status, 
				@JsonProperty("last") String last, 
				@JsonProperty("tags") String tags) {}
	}
}
