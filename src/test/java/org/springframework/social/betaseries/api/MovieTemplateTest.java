package org.springframework.social.betaseries.api;

import java.util.List;

import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.betaseries.api.Movie.SummarizedMovie;

public class MovieTemplateTest extends AbstractBetaSeriesApiTest {
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
	
	@Test
	public void getMovieListStart() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/list?start=2")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMovieList(2);
	}
	
	@Test
	public void getMovieListStartLimit() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/list?start=2&limit=101")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMovieList(2, 101);
	}
	
	@Test
	public void getMovieListStartLimitOrder() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/list?start=2&limit=101&order=popularity")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMovieList(2, 101, BSMovieOrder.POPULARITY);
	}
	
	@Test
	public void getMemberMovies() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies();
	}

	@Test
	public void getMemberMoviesState() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member?state=1")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies(BSMovieUserState.SEEN);
	}	
	
	@Test
	public void getMemberMoviesStateStart() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member?state=1&start=2")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies(BSMovieUserState.SEEN, 2);
	}
	
	@Test
	public void getMemberMoviesStateStartLimit() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member?state=1&start=2&limit=101")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies(BSMovieUserState.SEEN, 2, 101);
	}

	@Test
	public void getMemberMoviesStateStartLimitOrder() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/member?state=1&start=2&limit=101&order=alphabetical")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMemberMovies(BSMovieUserState.SEEN, 2, 101, BSMovieOrder.ALPHABETICAL);
	}
	
	@Test
	public void getMovie() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/movie?id=2774")
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));		
		Movie movie = betaSeries.movieOperations().getMovie(2774);
		assertNotNull(movie);
		assertThat(movie, is(instanceOf(Movie.class)));
		assertThat(2774, is(equalTo(movie.getId())));		
	}

	@Test
	public void addMovie() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774);		
	}
	
	@Test
	public void addMovieMail() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774&mail=0"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774, false);		
	}
	
	@Test
	public void addMovieMailTwitter() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774&mail=0&twitter=0"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774, false, false);		
	}
	
	@Test
	public void addMovieMailTwitterState() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774&mail=0&twitter=0&state=1"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774, false, false, BSMovieUserState.SEEN);		
	}

	@Test
	public void addMovieMailTwitterStateProfile() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/movies/movie")
		.andExpect(content().string("id=2774&mail=0&twitter=0&state=1&profile=0"))
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().addMovie(2774, false, false, BSMovieUserState.SEEN, false);		
	}
	
	@Test
	public void deleteMovie() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/movies/movie?id=2774")		
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.movieOperations().deleteMovie(2774);		
	}

	@Test
	public void getRandomMovie() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/random")
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getRandomMovies();
	}
	
	@Test
	public void getRandomMovieNb() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/random?nb=5")
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getRandomMovies(5);
	}
	
	@Test
	public void getMovieByScraper() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/scraper?file=Dexter.S01E01.avi")
		.andRespond(withSuccess().body(jsonResource("movies-movie")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getMovieByScraper("Dexter.S01E01.avi");
	}
	
	@Test
	public void getPopularMovies() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/search?order=popularity")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getPopularMovies();
	}
	
	@Test
	public void getPopularMoviesNbppPage() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/search?order=popularity&nbpp=10&page=2")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().getPopularMovies(10, 2);
	}
	
	@Test
	public void search() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/movies/search?title=Intouchable&order=popularity&nbpp=10&page=2")
		.andRespond(withSuccess().body(jsonResource("movies-list")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.movieOperations().search("Intouchable", BSSearchOrder.POPULARITY, 10, 2);
	}	
}
