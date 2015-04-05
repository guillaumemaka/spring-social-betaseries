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
package org.springframework.social.betaseries.api;

import java.util.List;

import org.springframework.social.betaseries.api.Movie.SummarizedMovie;

// TODO: Auto-generated Javadoc
/**
 * The Interface MovieOperations.
 *
 * @author Guillaume Maka
 */
public interface MovieOperations {
	
	/**
	 * Gets the movie list.
	 *
	 * @return the movie list
	 */
	List<SummarizedMovie> getMovieList();
	
	/**
	 * Gets the movie list.
	 *
	 * @param start
	 *            the start
	 * @return the movie list
	 */
	List<SummarizedMovie> getMovieList(Integer start);
	
	/**
	 * Gets the movie list.
	 *
	 * @param start
	 *            the start
	 * @param limit
	 *            the limit
	 * @return the movie list
	 */
	List<SummarizedMovie> getMovieList(Integer start, Integer limit);
	
	/**
	 * Gets the movie list.
	 *
	 * @param start
	 *            the start
	 * @param limit
	 *            the limit
	 * @param order
	 *            the order
	 * @return the movie list
	 */
	List<SummarizedMovie> getMovieList(Integer start, Integer limit, BSMovieOrder order);
	
	/**
	 * Gets the member movies.
	 *
	 * @return the member movies
	 */
	List<Movie> getMemberMovies();
	
	/**
	 * Gets the member movies.
	 *
	 * @param state
	 *            the state
	 * @return the member movies
	 */
	List<Movie> getMemberMovies(BSMovieUserState state);
	
	/**
	 * Gets the member movies.
	 *
	 * @param state
	 *            the state
	 * @param start
	 *            the start
	 * @return the member movies
	 */
	List<Movie> getMemberMovies(BSMovieUserState state, Integer start);
	
	/**
	 * Gets the member movies.
	 *
	 * @param state
	 *            the state
	 * @param start
	 *            the start
	 * @param limit
	 *            the limit
	 * @return the member movies
	 */
	List<Movie> getMemberMovies(BSMovieUserState state, Integer start, Integer limit);
	
	/**
	 * Gets the member movies.
	 *
	 * @param state
	 *            the state
	 * @param start
	 *            the start
	 * @param limit
	 *            the limit
	 * @param order
	 *            the order
	 * @return the member movies
	 */
	List<Movie> getMemberMovies(BSMovieUserState state, Integer start, Integer limit, BSMovieOrder order);
	
	/**
	 * Gets the movie.
	 *
	 * @param movieId
	 *            the movie id
	 * @return the movie
	 */
	Movie getMovie(Integer movieId);	
	
	/**
	 * Adds the movie.
	 *
	 * @param movieId
	 *            the movie id
	 * @return the movie
	 */
	Movie addMovie(Integer movieId);
	
	/**
	 * Adds the movie.
	 *
	 * @param movieId
	 *            the movie id
	 * @param enableMailNotification
	 *            the enable mail notification
	 * @return the movie
	 */
	Movie addMovie(Integer movieId, boolean enableMailNotification);
	
	/**
	 * Adds the movie.
	 *
	 * @param movieId
	 *            the movie id
	 * @param enableMailNotification
	 *            the enable mail notification
	 * @param enableTwitterNOtification
	 *            the enable twitter n otification
	 * @return the movie
	 */
	Movie addMovie(Integer movieId, boolean enableMailNotification, boolean enableTwitterNOtification);
	
	/**
	 * Adds the movie.
	 *
	 * @param movieId
	 *            the movie id
	 * @param enableMailNotification
	 *            the enable mail notification
	 * @param enableTwitterNOtification
	 *            the enable twitter n otification
	 * @param state
	 *            the state
	 * @return the movie
	 */
	Movie addMovie(Integer movieId, boolean enableMailNotification, boolean enableTwitterNOtification, BSMovieUserState state);
	
	/**
	 * Adds the movie.
	 *
	 * @param movieId
	 *            the movie id
	 * @param enableMailNotification
	 *            the enable mail notification
	 * @param enableTwitterNOtification
	 *            the enable twitter n otification
	 * @param state
	 *            the state
	 * @param displayOnProfile
	 *            the display on profile
	 * @return the movie
	 */
	Movie addMovie(Integer movieId, boolean enableMailNotification, boolean enableTwitterNOtification, BSMovieUserState state, boolean displayOnProfile);
	
	/**
	 * Delete movie.
	 *
	 * @param movieId
	 *            the movie id
	 * @return the movie
	 */
	Movie deleteMovie(Integer movieId);
	
	/**
	 * Gets the random movies.
	 *
	 * @return the random movies
	 */
	List<Movie> getRandomMovies();
	
	/**
	 * Gets the random movies.
	 *
	 * @param nb
	 *            the nb
	 * @return the random movies
	 */
	List<Movie> getRandomMovies(Integer nb);
	
	/**
	 * Gets the movie by scraper.
	 *
	 * @param file
	 *            the file
	 * @return the movie by scraper
	 */
	Movie getMovieByScraper(String file);
	
	/**
	 * Gets the popular movies.
	 *
	 * @return the popular movies
	 */
	List<Movie> getPopularMovies();
	
	/**
	 * Gets the popular movies.
	 *
	 * @param nbpp
	 *            the nbpp
	 * @param page
	 *            the page
	 * @return the popular movies
	 */
	List<Movie> getPopularMovies(Integer nbpp, Integer page);
	
	/**
	 * Search.
	 *
	 * @param title
	 *            the title
	 * @param order
	 *            the order
	 * @param nbpp
	 *            the nbpp
	 * @param page
	 *            the page
	 * @return the list
	 */
	List<Movie> search(String title, BSSearchOrder order, Integer nbpp, Integer page);	
}
