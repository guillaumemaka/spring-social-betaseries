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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.betaseries.api.Movie.SummarizedMovie;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieTemplateTest.
 *
 * @author Guillaume Maka
 */
public class MovieTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Gets the movie list.
	 *
	 * @return the movie list
	 */
	@Test
	public void getMovieList(){
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/list")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));
		
		List<SummarizedMovie> movies = betaSeries.movieOperations().getMovieList();
		assertNotNull(movies);
		assertEquals(100, movies.size());
		assertEquals(Integer.valueOf(17089), movies.get(0).getId());
		assertEquals("#1 Cheerleader Camp", movies.get(0).getTitle());
		assertEquals("41371", movies.get(0).getTmdbId());
		assertEquals("tt1637976", movies.get(0).getImdbId());
		assertEquals(Integer.valueOf(6), movies.get(0).getFollowers());
	}
	
	/**
	 * Gets the movie list start.
	 *
	 * @return the movie list start
	 */
	@Test
	public void getMovieListStart() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/list?start=2")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMovieList(2);
	}
	
	/**
	 * Gets the movie list start limit.
	 *
	 * @return the movie list start limit
	 */
	@Test
	public void getMovieListStartLimit() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/list?start=2&limit=101")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMovieList(2, 101);
	}
	
	/**
	 * Gets the movie list start limit order.
	 *
	 * @return the movie list start limit order
	 */
	@Test
	public void getMovieListStartLimitOrder() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/list?start=2&limit=101&order=popularity")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMovieList(2, 101, BSMovieOrder.POPULARITY);
	}
	
	/**
	 * Gets the member movies.
	 *
	 * @return the member movies
	 */
	@Test
	public void getMemberMovies() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies();
	}

	/**
	 * Gets the member movies state.
	 *
	 * @return the member movies state
	 */
	@Test
	public void getMemberMoviesState() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member?state=1")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies(BSMovieUserState.SEEN);
	}	
	
	/**
	 * Gets the member movies state start.
	 *
	 * @return the member movies state start
	 */
	@Test
	public void getMemberMoviesStateStart() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member?state=1&start=2")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies(BSMovieUserState.SEEN, 2);
	}
	
	/**
	 * Gets the member movies state start limit.
	 *
	 * @return the member movies state start limit
	 */
	@Test
	public void getMemberMoviesStateStartLimit() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member?state=1&start=2&limit=101")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies(BSMovieUserState.SEEN, 2, 101);
	}

	/**
	 * Gets the member movies state start limit order.
	 *
	 * @return the member movies state start limit order
	 */
	@Test
	public void getMemberMoviesStateStartLimitOrder() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member?state=1&start=2&limit=101&order=alphabetical")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies(BSMovieUserState.SEEN, 2, 101, BSMovieOrder.ALPHABETICAL);
	}
	
	/**
	 * Gets the movie.
	 *
	 * @return the movie
	 */
	@Test
	public void getMovie() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/movie?id=2774")
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));		
		Movie movie = betaSeries.movieOperations().getMovie(2774);
		assertNotNull(movie);
		assertThat(movie, is(instanceOf(Movie.class)));
		assertThat(2774, is(equalTo(movie.getId())));		
	}

	/**
	 * Adds the movie.
	 */
	@Test
	public void addMovie() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774);		
	}
	
	/**
	 * Adds the movie mail.
	 */
	@Test
	public void addMovieMail() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774&mail=0"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774, false);		
	}
	
	/**
	 * Adds the movie mail twitter.
	 */
	@Test
	public void addMovieMailTwitter() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774&mail=0&twitter=0"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774, false, false);		
	}
	
	/**
	 * Adds the movie mail twitter state.
	 */
	@Test
	public void addMovieMailTwitterState() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774&mail=0&twitter=0&state=1"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774, false, false, BSMovieUserState.SEEN);		
	}

	/**
	 * Adds the movie mail twitter state profile.
	 */
	@Test
	public void addMovieMailTwitterStateProfile() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774&mail=0&twitter=0&state=1&profile=0"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774, false, false, BSMovieUserState.SEEN, false);		
	}
	
	/**
	 * Delete movie.
	 */
	@Test
	public void deleteMovie() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/movies/movie?id=2774")		
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().deleteMovie(2774);		
	}

	/**
	 * Gets the random movie.
	 *
	 * @return the random movie
	 */
	@Test
	public void getRandomMovie() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/random")
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getRandomMovies();
	}
	
	/**
	 * Gets the random movie nb.
	 *
	 * @return the random movie nb
	 */
	@Test
	public void getRandomMovieNb() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/random?nb=5")
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getRandomMovies(5);
	}
	
	/**
	 * Gets the movie by scraper.
	 *
	 * @return the movie by scraper
	 */
	@Test
	public void getMovieByScraper() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/scraper?file=Dexter.S01E01.avi")
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMovieByScraper("Dexter.S01E01.avi");
	}
	
	/**
	 * Gets the popular movies.
	 *
	 * @return the popular movies
	 */
	@Test
	public void getPopularMovies() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/search?order=popularity")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getPopularMovies();
	}
	
	/**
	 * Gets the popular movies nbpp page.
	 *
	 * @return the popular movies nbpp page
	 */
	@Test
	public void getPopularMoviesNbppPage() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/search?order=popularity&nbpp=10&page=2")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getPopularMovies(10, 2);
	}
	
	/**
	 * Search.
	 */
	@Test
	public void search() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/search?title=Intouchable&order=popularity&nbpp=10&page=2")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().search("Intouchable", BSSearchOrder.POPULARITY, 10, 2);
	}	
}
