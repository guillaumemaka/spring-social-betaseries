package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;

import org.springframework.social.betaseries.api.BSMovieUserState;
import org.springframework.social.betaseries.api.Movie.UserDetail;
import org.springframework.social.betaseries.api.Note;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonIgnoreProperties(ignoreUnknown=true)
abstract class MovieMixin extends BetaSeriesObjectMixin {
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
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	static abstract class UserDetailMixin extends BetaSeriesObjectMixin {
		@JsonCreator
		public UserDetailMixin(
				@JsonProperty("in_account") boolean inAccount, 
				@JsonProperty("status") @JsonDeserialize(using=BSMovieUserStateDeserializer.class) BSMovieUserState status
				) {}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	static abstract class SummarizedMovieMixin extends BetaSeriesObjectMixin {
		@JsonCreator
		public SummarizedMovieMixin(
				@JsonProperty("id") Integer id, 
				@JsonProperty("title") String title, 
				@JsonProperty("tmdb_id") String tmdbId,
				@JsonProperty("imdb_id") String imdbId, 
				@JsonProperty("followers") Integer followers) {}
	}
}
