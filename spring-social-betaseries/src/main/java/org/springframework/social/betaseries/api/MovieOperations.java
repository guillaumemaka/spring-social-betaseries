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
package org.springframework.social.betaseries.api;

import java.util.List;

import org.springframework.social.betaseries.api.Movie.SummarizedMovie;

/**
 * The Interface MovieOperations.
 * 
 * @author Guillaume Maka
 */
public interface MovieOperations {
	List<SummarizedMovie> getMovieList();
	List<SummarizedMovie> getMovieList(Integer start);
	List<SummarizedMovie> getMovieList(Integer start, Integer limit);
	List<SummarizedMovie> getMovieList(Integer start, Integer limit, BSMovieOrder order);
	List<Movie> getMemberMovies();
	List<Movie> getMemberMovies(BSMovieUserState state);
	List<Movie> getMemberMovies(BSMovieUserState state, Integer start);
	List<Movie> getMemberMovies(BSMovieUserState state, Integer start, Integer limit);
	List<Movie> getMemberMovies(BSMovieUserState state, Integer start, Integer limit, BSMovieOrder order);
	Movie getMovie(Integer movieId);	
	Movie addMovie(Integer movieId);
	Movie addMovie(Integer movieId, boolean enableMailNotification);
	Movie addMovie(Integer movieId, boolean enableMailNotification, boolean enableTwitterNOtification);
	Movie addMovie(Integer movieId, boolean enableMailNotification, boolean enableTwitterNOtification, BSMovieUserState state);
	Movie addMovie(Integer movieId, boolean enableMailNotification, boolean enableTwitterNOtification, BSMovieUserState state, boolean displayOnProfile);
	Movie deleteMovie(Integer movieId);
	List<Movie> getRandomMovies();
	List<Movie> getRandomMovies(Integer nb);
	Movie getMovieByScraper(String file);
	List<Movie> getPopularMovies();
	List<Movie> getPopularMovies(Integer nbpp, Integer page);
	List<Movie> search(String title, BSSearchOrder order, Integer nbpp, Integer page);	
}
