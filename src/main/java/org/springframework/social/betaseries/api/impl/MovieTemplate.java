/**
 * Copyright 2015 [name of copyright owner]
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
package org.springframework.social.betaseries.api.impl;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.social.betaseries.api.BSMovieOrder;
import org.springframework.social.betaseries.api.BSMovieUserState;
import org.springframework.social.betaseries.api.BSSearchOrder;
import org.springframework.social.betaseries.api.Movie;
import org.springframework.social.betaseries.api.Movie.SummarizedMovie;
import org.springframework.social.betaseries.api.MovieOperations;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesMovieList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesMovieSingleObject;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesSummarizedMovieList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieTemplate.
 *
 * @author Guillaume Maka
 */
public class MovieTemplate extends AbstractBetaSeriesOperations implements
		MovieOperations {
	
	/** The rest template. */
	private final RestTemplate restTemplate;

	/**
	 * Instantiates a new movie template.
	 *
	 * @param restTemplate the rest template
	 * @param isUserAuthorized the is user authorized
	 * @param isAppAuthorized the is app authorized
	 */
	public MovieTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMovieList()
	 */
	public List<SummarizedMovie> getMovieList() {		
		return getMovieList(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMovieList(java.lang.Integer)
	 */
	public List<SummarizedMovie> getMovieList(Integer start) {		
		return getMovieList(start, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMovieList(java.lang.Integer, java.lang.Integer)
	 */
	public List<SummarizedMovie> getMovieList(Integer start, Integer limit) {
		return getMovieList(start, limit, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMovieList(java.lang.Integer, java.lang.Integer, org.springframework.social.betaseries.api.BSMovieOrder)
	 */
	public List<SummarizedMovie> getMovieList(Integer start, Integer limit,
			BSMovieOrder order) {
		requireAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		
		if (start != null) {
			if (start > 0) {
				params.set("start", start.toString());
			}
		}
		
		if(limit != null) {
			if (limit > 100) {
				params.set("limit", limit.toString());
			}
		}
		
		if (order != null) {
			params.set("order", order.toString().toLowerCase());
		}
		
		return restTemplate.getForObject(buildUri("movies/list", params), BetaSeriesSummarizedMovieList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMemberMovies()
	 */
	public List<Movie> getMemberMovies() {		
		return getMemberMovies(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMemberMovies(org.springframework.social.betaseries.api.BSMovieUserState)
	 */
	public List<Movie> getMemberMovies(BSMovieUserState state) {		
		return getMemberMovies(state, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMemberMovies(org.springframework.social.betaseries.api.BSMovieUserState, java.lang.Integer)
	 */
	public List<Movie> getMemberMovies(BSMovieUserState state, Integer start) {		
		return getMemberMovies(state, start, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMemberMovies(org.springframework.social.betaseries.api.BSMovieUserState, java.lang.Integer, java.lang.Integer)
	 */
	public List<Movie> getMemberMovies(BSMovieUserState state, Integer start,
			Integer limit) {		
		return getMemberMovies(state, start, limit, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMemberMovies(org.springframework.social.betaseries.api.BSMovieUserState, java.lang.Integer, java.lang.Integer, org.springframework.social.betaseries.api.BSMovieOrder)
	 */
	public List<Movie> getMemberMovies(BSMovieUserState state, Integer start,
			Integer limit, BSMovieOrder order) {
		requireEitherUserOrAppAuthorization();
				
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		if (state != null) {
			if(state != BSMovieUserState.TO_SEE) {
				params.set("state", BSMovieUserState.fromEnum(state));
			}
		}		
		
		if (start != null) {
			if (start > 0) {
				params.set("start", start.toString());
			}
		}
		
		if (limit != null) {
			params.set("limit", limit.toString());
		}
		
		if (order != null) {
			params.set("order", order.toString().toLowerCase());
		}
		
		return restTemplate.getForObject(buildUri("movies/member", params), BetaSeriesMovieList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMovie(java.lang.Integer)
	 */
	public Movie getMovie(Integer movieId) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", movieId.toString());
		return restTemplate.getForObject(buildUri("movies/movie", params), BetaSeriesMovieSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#addMovie(java.lang.Integer)
	 */
	public Movie addMovie(Integer movieId) {		
		return addMovie(movieId, true);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#addMovie(java.lang.Integer, boolean)
	 */
	public Movie addMovie(Integer movieId, boolean enableMailNotification) {		
		return addMovie(movieId, enableMailNotification, true);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#addMovie(java.lang.Integer, boolean, boolean)
	 */
	public Movie addMovie(Integer movieId, boolean enableMailNotification,
			boolean enableTwitterNOtification) {		
		return addMovie(movieId, enableMailNotification, enableTwitterNOtification, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#addMovie(java.lang.Integer, boolean, boolean, org.springframework.social.betaseries.api.BSMovieUserState)
	 */
	public Movie addMovie(Integer movieId, boolean enableMailNotification,
			boolean enableTwitterNOtification, BSMovieUserState state) {		
		return addMovie(movieId, enableMailNotification, enableTwitterNOtification, state, true);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#addMovie(java.lang.Integer, boolean, boolean, org.springframework.social.betaseries.api.BSMovieUserState, boolean)
	 */
	public Movie addMovie(Integer movieId, boolean enableMailNotification,
			boolean enableTwitterNOtification, BSMovieUserState state,
			boolean displayOnProfile) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("id", movieId.toString());
		
		if (!enableMailNotification) {
			params.set("mail", "0");
		}
		
		if (!enableTwitterNOtification) {
			params.set("twitter", "0");
		}
		
		if (state != null) {
			if (state != BSMovieUserState.TO_SEE) {
				params.set("state", BSMovieUserState.fromEnum(state));
			}
		}
		
		if (!displayOnProfile) {
			params.set("profile", "0");
		}
		
		return restTemplate.postForObject(buildUri("movies/movie"), params, BetaSeriesMovieSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#deleteMovie(java.lang.Integer)
	 */
	public Movie deleteMovie(Integer movieId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", movieId.toString());
		return restTemplate.exchange(buildUri("movies/movie", params), HttpMethod.DELETE, null, BetaSeriesMovieSingleObject.class).getBody().getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getRandomMovies()
	 */
	public List<Movie> getRandomMovies() {	
		return getRandomMovies(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getRandomMovies(java.lang.Integer)
	 */
	public List<Movie> getRandomMovies(Integer nb) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		if (nb != null) {
			if (nb > 1) {
				params.set("nb", nb.toString());
			}
		}
		return restTemplate.getForObject(buildUri("movies/random", params), BetaSeriesMovieList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getMovieScraper(java.lang.String)
	 */
	public Movie getMovieByScraper(String file) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("file", file);
		return restTemplate.getForObject(buildUri("movies/scraper", params), BetaSeriesMovieSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getPopularMovies()
	 */
	public List<Movie> getPopularMovies() {
		return getPopularMovies(null, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#getPopularMovies(java.lang.Integer, java.lang.Integer)
	 */
	public List<Movie> getPopularMovies(Integer nbpp, Integer page) {		
		return search(null, BSSearchOrder.POPULARITY, nbpp, page);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MovieOperations#search(java.lang.String, org.springframework.social.betaseries.api.BSSearchOrder, java.lang.Integer, java.lang.Integer)
	 */
	public List<Movie> search(String title, BSSearchOrder order, Integer nbpp,
			Integer page) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if (title != null) {
			params.set("title", title);						
		}
		
		if (order != null) {
			if (order != BSSearchOrder.TITLE) {
				params.set("order", order.toString().toLowerCase());
			}			
		}
		
		if (nbpp != null) {
			if (nbpp > 5) {
				params.set("nbpp", nbpp.toString());
			}
		}
		
		if (page != null) {
			if (page > 1) {
				params.set("page", page.toString());
			}
		}
		
		return restTemplate.getForObject(buildUri("movies/search", params), BetaSeriesMovieList.class).getList();
	}			
}
