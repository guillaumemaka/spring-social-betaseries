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

import org.springframework.social.betaseries.api.BSMovieUserState;
import org.springframework.social.betaseries.api.Movie.UserDetail;
import org.springframework.social.betaseries.api.Note;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// TODO: Auto-generated Javadoc
/**
 * The Class MovieMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class MovieMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new movie mixin.
	 *
	 * @param id
	 *            the id
	 * @param titlw
	 *            the titlw
	 * @param originalTitlw
	 *            the original titlw
	 * @param theMovieDbId
	 *            the the movie db id
	 * @param imDbId
	 *            the im db id
	 * @param url
	 *            the url
	 * @param posterUrl
	 *            the poster url
	 * @param productionYear
	 *            the production year
	 * @param releaseDate
	 *            the release date
	 * @param saleDate
	 *            the sale date
	 * @param director
	 *            the director
	 * @param length
	 *            the length
	 * @param genres
	 *            the genres
	 * @param synopsis
	 *            the synopsis
	 * @param language
	 *            the language
	 * @param note
	 *            the note
	 * @param followers
	 *            the followers
	 * @param userDetail
	 *            the user detail
	 */
	@JsonCreator
	public MovieMixin(
			@JsonProperty("id") Integer id, 
			@JsonProperty("title") String titlw, 
			@JsonProperty("original_title") String originalTitlw,
			@JsonProperty("tmdb_id") int theMovieDbId, 
			@JsonProperty("imdb_id") String imDbId, 
			@JsonProperty("url") String url, 
			@JsonProperty("poster") String posterUrl,
			@JsonProperty("production_year") String productionYear, 
			@JsonProperty("release_date") @JsonDeserialize(using=BSDateDeserializer.class) Date releaseDate, 
			@JsonProperty("sale_date") @JsonDeserialize(using=BSDateDeserializer.class) Date saleDate,
			@JsonProperty("director") String director, 
			@JsonProperty("lenght") String length, 
			@JsonProperty("genres") String[] genres, 
			@JsonProperty("synopsis") String synopsis,
			@JsonProperty("language") String language, 
			@JsonProperty("notes") Note note, 
			@JsonProperty("followers") int followers, 
			@JsonProperty("user") UserDetail userDetail
			) {}
	
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
		 * @param inAccount
		 *            the in account
		 * @param status
		 *            the status
		 */
		@JsonCreator
		public UserDetailMixin(
				@JsonProperty("in_account") boolean inAccount, 
				@JsonProperty("status") @JsonDeserialize(using=BSMovieUserStateDeserializer.class) BSMovieUserState status
				) {}
	}
	
	/**
	 * The Class SummarizedMovieMixin.
	 *
	 * @author Guillaume Maka
	 */
	@JsonIgnoreProperties(ignoreUnknown=true)
	static abstract class SummarizedMovieMixin extends BetaSeriesObjectMixin {
		
		/**
		 * Instantiates a new summarized movie mixin.
		 *
		 * @param id
		 *            the id
		 * @param title
		 *            the title
		 * @param tmdbId
		 *            the tmdb id
		 * @param imdbId
		 *            the imdb id
		 * @param followers
		 *            the followers
		 */
		@JsonCreator
		public SummarizedMovieMixin(
				@JsonProperty("id") Integer id, 
				@JsonProperty("title") String title, 
				@JsonProperty("tmdb_id") String tmdbId,
				@JsonProperty("imdb_id") String imdbId, 
				@JsonProperty("followers") Integer followers) {}
	}
}
