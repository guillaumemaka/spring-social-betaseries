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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.betaseries.api.Show.SeasonDetail;
import org.springframework.social.betaseries.api.Show.UserDetail;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowTemplateTest.
 *
 * @author Guillaume Maka
 */
public class ShowTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Archive.
	 */
	@Test
	public void archive() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/shows/archive")
		.andExpect(content().string("id=13"))
		.andRespond(withSuccess().body(jsonResource("shows-archive-POST")).contentType(MediaType.APPLICATION_JSON));
		
		Show archivedShow = betaSeries.showOperations().archive(13);
		assertTrue(archivedShow.getUserDetail().isArchived());
	}

	/**
	 * Unarchive.
	 */
	@Test
	public void unarchive() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/shows/archive?id=13")
		.andRespond(withSuccess().body(jsonResource("shows-archive-DELETE")).contentType(MediaType.APPLICATION_JSON));
		
		Show unarchivedShow = betaSeries.showOperations().unarchive(13);
		assertFalse(unarchivedShow.getUserDetail().isArchived());
	}

	/**
	 * Gets the characters.
	 *
	 * @return the characters
	 */
	@Test
	public void getCharacters() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/characters?id=13")
		.andRespond(withSuccess().body(jsonResource("shows-13-characters")).contentType(MediaType.APPLICATION_JSON));
		
		List<Character> characters = betaSeries.showOperations().getCharacters(13);
		assertNotNull(characters);
		assertEquals(16, characters.size());
		
		Character character = characters.get(0);
		assertEquals(Character.class, character.getClass());
		assertEquals(1, character.getId());
		assertEquals(13, character.getShowId());
		assertEquals("Charles \"Chuck\" Bartowski"	, character.getName());
		assertEquals("Zachary Levi", character.getActor());
		assertEquals("http://cdn.betaseries.com/betaseries/images/personnages/22017.jpg", character.getPictureUrl());
		assertEquals("Chuck Bartowski est un informaticien qui travaille au Nerd Herd (parodie de l'entreprise Geek Squad) d'un grand magasin d'électronique et d'électroménager, le Buy More. Il apparaît à première vue comme étant un loser : en effet, après avoir été renvoyé de Stanford pour avoir prétendument triché, il a également perdu sa petite amie. Après s'être fait renvoyer de Stanford, Chuck a emménagé avec sa soeur, Ellie, et a commencé à travailler au Buy More de Burbank.\n\nSource : Wikipedia", character.getDescription());		
	}

	/**
	 * Gets the show.
	 *
	 * @return the show
	 */
	@Test
	public void getShow() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/display?id=13")
		.andRespond(withSuccess().body(jsonResource("shows-13-display")).contentType(MediaType.APPLICATION_JSON));
		
		Show show = betaSeries.showOperations().getShow(13);
		assertShow13(show);		
	}

	/**
	 * Gets the shows.
	 *
	 * @return the shows
	 */
	@Test
	public void getShows() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/display?id=13,14")
		.andRespond(withSuccess().body(jsonResource("shows-multipleIds-display")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().getShows("13","14");
		assertNotNull(shows);
		assertEquals(2, shows.size());
		assertShow13(shows.get(0));
	}

	/**
	 * Gets the show13 episodes.
	 *
	 * @return the show13 episodes
	 */
	@Test
	public void getShow13Episodes() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/episodes?id=13")
		.andRespond(withSuccess().body(jsonResource("shows-13-episodes")).contentType(MediaType.APPLICATION_JSON));
		
		List<Episode> episodes = betaSeries.showOperations().getShowEpisodes(13);
		assertNotNull(episodes);
		assertEquals(91, episodes.size());
		assertEquals(0, episodes.get(0).getSubtitles().size());
	}
	
	/**
	 * Gets the show13 season1 episodes.
	 *
	 * @return the show13 season1 episodes
	 */
	@Test
	public void getShow13Season1Episodes() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/episodes?id=13&season=1")
		.andRespond(withSuccess().body(jsonResource("shows-13-episodes-season-1")).contentType(MediaType.APPLICATION_JSON));
		
		List<Episode> episodes = betaSeries.showOperations().getShowEpisodes(13,1);
		assertNotNull(episodes);
		assertEquals(13, episodes.size());
		assertEquals(0, episodes.get(0).getSubtitles().size());
	}
	
	/**
	 * Gets the show13 season1 episode1.
	 *
	 * @return the show13 season1 episode1
	 */
	@Test
	public void getShow13Season1Episode1() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/episodes?id=13&season=1&episode=1")
		.andRespond(withSuccess().body(jsonResource("shows-13-episodes-season-1-episode-1")).contentType(MediaType.APPLICATION_JSON));
		
		List<Episode> episodes = betaSeries.showOperations().getShowEpisodes(13,1,1);
		assertNotNull(episodes);
		assertEquals(1, episodes.size());
		assertEquals(0, episodes.get(0).getSubtitles().size());
	}

	/**
	 * Gets the show13 season1 episode1 with subtitles.
	 *
	 * @return the show13 season1 episode1 with subtitles
	 */
	@Test
	public void getShow13Season1Episode1WithSubtitles() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/episodes?id=13&season=1&episode=1&subtitles=1")
		.andRespond(withSuccess().body(jsonResource("shows-13-episodes-season-1-episode-1-with-subtitles")).contentType(MediaType.APPLICATION_JSON));
		
		List<Episode> episodes = betaSeries.showOperations().getShowEpisodes(13,1,1,true);
		assertNotNull(episodes);
		assertEquals(1, episodes.size());
		assertEquals(4, episodes.get(0).getSubtitles().size());
	}
	
	/**
	 * Adds the to favorite.
	 */
	@Test
	public void addToFavorite() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/shows/favorite")
		.andExpect(content().string("id=13"))
		.andRespond(withSuccess().body(jsonResource("shows-13-favorite-POST")).contentType(MediaType.APPLICATION_JSON));
		
		Show show = betaSeries.showOperations().addToFavorite(13);
		assertNotNull(show);
		assertTrue(show.getUserDetail().isFavorited());
	}

	/**
	 * Removes the from favorite.
	 */
	@Test
	public void removeFromFavorite() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/shows/favorite?id=13")		
		.andRespond(withSuccess().body(jsonResource("shows-13-favorite-DELETE")).contentType(MediaType.APPLICATION_JSON));
		
		Show show = betaSeries.showOperations().removeFromFavorite(13);
		assertNotNull(show);
		assertFalse(show.getUserDetail().isFavorited());
	}

	/**
	 * Gets the favorites show.
	 *
	 * @return the favorites show
	 */
	@Test
	public void getFavoritesShow() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/favorites")		
		.andRespond(withSuccess().body(jsonResource("shows-favorites")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().getFavoritesShow();
		assertNotNull(shows);
		assertEquals(1, shows.size());
		assertShow13(shows.get(0));
	}

	/**
	 * List.
	 */
	@Test
	public void list() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/list")
		.andRespond(withSuccess().body(jsonResource("shows-list")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().list();
		assertNotNull(shows);
		assertEquals(9801, shows.size());
	}

	/**
	 * List bs show order.
	 */
	@Test
	public void listBSShowOrder() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/list?order=popularity")
		.andRespond(withSuccess().body(jsonResource("shows-list-order-by_popularity")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().list(BSShowOrder.POPULARITY);
		assertEquals(9801, shows.size());
		assertEquals(7597, shows.get(0).getId());
	}

	/**
	 * List bs show order date.
	 */
	@Test
	public void listBSShowOrderDate() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/list?order=popularity&since=1323157023000")
		.andRespond(withSuccess().body(jsonResource("shows-list-order-by_popularity-since_1323157023000")).contentType(MediaType.APPLICATION_JSON));
		Date date = new Date();
		date.setTime(Long.valueOf("1323157023000"));		
		List<Show> shows = betaSeries.showOperations().list(BSShowOrder.POPULARITY, date);
		assertEquals(0, shows.size());		
	}

	/**
	 * Rate show.
	 */
	@Test
	public void rateShow() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/shows/note")
		.andExpect(content().string("id=13&note=5"))
		.andRespond(withSuccess().body(jsonResource("shows-note-POST")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> show = betaSeries.showOperations().rateShow(13, 5);
		assertEquals(5, show.get(0).getNote().getUserNote(), 5);
	}

	/**
	 * Un rate show.
	 */
	@Test
	public void unRateShow() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/shows/note?id=13")
		.andRespond(withSuccess().body(jsonResource("shows-note-DELETE")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> show = betaSeries.showOperations().unRateShow(13);
		assertEquals(0, show.get(0).getNote().getUserNote(),0);
	}

	/**
	 * Gets the show pictures.
	 *
	 * @return the show pictures
	 */
	@Test
	public void getShowPictures() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/pictures?id=13")
		.andRespond(withSuccess().body(jsonResource("shows-pictures")).contentType(MediaType.APPLICATION_JSON));
		
		List<Picture> pictures = betaSeries.showOperations().getShowPictures(13);
		assertNotNull(pictures);
		assertEquals(48, pictures.size());
		assertEquals(443, pictures.get(0).getId());
		assertEquals(13, pictures.get(0).getShowId());
		assertEquals(16376, pictures.get(0).getLoginId());		
		assertEquals("http://cdn.betaseries.com/betaseries/images/fonds/original/13_1362236164.jpg", pictures.get(0).getUrl());
		assertEquals(768, pictures.get(0).getWidth());
		assertEquals(188, pictures.get(0).getHeight());
		assertEquals(dateFromString("2013-03-02 15:56:04", BS_DATE_AND_TIME_FORMAT), pictures.get(0).getDate());
		assertEquals(BSPictureType.NONE, pictures.get(0).getType());
	}

	/**
	 * Gets the random show.
	 *
	 * @return the random show
	 */
	@Test
	public void getRandomShow() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/random?nb=5")
		.andRespond(withSuccess().body(jsonResource("shows-random")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().getRandomShow(5);
		assertEquals(5, shows.size());		
	}

	/**
	 * Send recommendation.
	 */
	@Test
	public void sendRecommendation() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/shows/recommendation")
		.andExpect(content().string("id=13&to=26978"))
		.andRespond(withSuccess().body(jsonResource("shows-recommend-POST")).contentType(MediaType.APPLICATION_JSON));
		
		Recommendation recommendation = betaSeries.showOperations().sendRecommendation(13, 26978);		
		
		assertEquals(77535, recommendation.getId());
		assertEquals(130446, recommendation.getFromId());
		assertEquals(26978, recommendation.getToId());
		assertEquals(13, recommendation.getShowId());
		assertEquals("wait", recommendation.getStatus());
		assertEquals("An awesome serie", recommendation.getComments());
	}

	/**
	 * Delete recomendation.
	 */
	@Test
	public void deleteRecomendation() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/shows/recommendation?id=77535")		
		.andRespond(withSuccess().body(jsonResource("shows-recommend-DELETE")).contentType(MediaType.APPLICATION_JSON));
		
		Recommendation recommendation = betaSeries.showOperations().deleteRecomendation(77535);		
		
		assertEquals(77535, recommendation.getId());
		assertEquals(130446, recommendation.getFromId());
		assertEquals(26978, recommendation.getToId());
		assertEquals(13, recommendation.getShowId());
		assertEquals("wait", recommendation.getStatus());
		assertEquals("An awesome serie", recommendation.getComments());
	}
	
	/**
	 * Gets the recommendations.
	 *
	 * @return the recommendations
	 */
	@Test
	public void getRecommendations() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/recommendations")		
		.andRespond(withSuccess().body(jsonResource("shows-recommend-GET")).contentType(MediaType.APPLICATION_JSON));
		
		List<Recommendation> recommendations = betaSeries.showOperations().getRecommendations();		
		assertEquals(1, recommendations.size());
		assertEquals(77535, recommendations.get(0).getId());
		assertEquals(130446, recommendations.get(0).getFromId());
		assertEquals(26978, recommendations.get(0).getToId());
		assertEquals(13, recommendations.get(0).getShowId());
		assertEquals("wait", recommendations.get(0).getStatus());
		assertEquals("An awesome serie", recommendations.get(0).getComments());
	}
	
	/**
	 * Search.
	 */
	@Test
	public void search() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/search?title=shin")
		.andRespond(withSuccess().body(jsonResource("shows-search")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().search("shin");
		assertNotNull(shows);
		assertEquals(5, shows.size());
		assertEquals("Shin Chan", shows.get(0).getTitle());
	}
	
	/**
	 * Search with order.
	 */
	@Test
	public void searchWithOrder() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/search?title=shin&order=popularity")
		.andRespond(withSuccess().body(jsonResource("shows-search-order_popularity")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().search("shin", BSSearchOrder.POPULARITY);
		assertNotNull(shows);
		assertEquals(5, shows.size());
		assertEquals("Rage of Bahamut: Genesis", shows.get(0).getTitle());
	}
	
	/**
	 * Search with order nbpp.
	 */
	@Test
	public void searchWithOrderNbpp() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/search?title=shin&order=popularity&nbpp=10")
		.andRespond(withSuccess().body(jsonResource("shows-search-order_popularity-nbpp_10")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().search("shin", BSSearchOrder.POPULARITY, 10);
		assertNotNull(shows);
		assertEquals(10, shows.size());
		assertEquals("Rage of Bahamut: Genesis", shows.get(0).getTitle());
	}
	
	/**
	 * Search with order nbpp page.
	 */
	@Test
	public void searchWithOrderNbppPage() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/search?title=shin&order=popularity&nbpp=10&page=2")
		.andRespond(withSuccess().body(jsonResource("shows-search-order_popularity-nbpp_10-page_2")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().search("shin", BSSearchOrder.POPULARITY, 10, 2);
		assertNotNull(shows);
		assertEquals(10, shows.size());
		assertEquals("Shin Chan", shows.get(0).getTitle());
	}
	
	/**
	 * Search with order nbpp page summary.
	 */
	@Test
	public void searchWithOrderNbppPageSummary() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/search?title=shin&order=popularity&nbpp=10&page=2&summary=1")
		.andRespond(withSuccess().body(jsonResource("shows-search-order_popularity-nbpp_10-page_2-summary_true")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().search("shin", BSSearchOrder.POPULARITY, 10, 2, true);
		assertNotNull(shows);
		assertEquals(10, shows.size());
		assertEquals("Shin Chan", shows.get(0).getTitle());
		assertNull(shows.get(0).getNote());
	}
	
	/**
	 * Gets the similars show.
	 *
	 * @return the similars show
	 */
	@Test
	public void getSimilarsShow() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/similars?id=13")
		.andRespond(withSuccess().body(jsonResource("shows-similars")).contentType(MediaType.APPLICATION_JSON));
		
		List<SimilarShow> shows = betaSeries.showOperations().getSimilarsShow(13);
		assertNotNull(shows);
		assertEquals(20, shows.size());
		assertEquals("Family Guy", shows.get(0).getShowTitle());
	}
	
	/**
	 * Adds the show tags show.
	 */
	@Test
	public void addShowTagsShow() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/shows/tags")
		.andExpect(content().string("id=13&tags=humour"))
		.andRespond(withSuccess().body(jsonResource("shows-tags")).contentType(MediaType.APPLICATION_JSON));
		
		Show show = betaSeries.showOperations().addShowTagsShow(13, "humour");
		assertEquals("humour", show.getUserDetail().getTags());		
	}
	
	/**
	 * Gets the show videos.
	 *
	 * @return the show videos
	 */
	@Test
	public void getShowVideos() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/shows/videos?id=13")
		.andRespond(withSuccess().body(jsonResource("shows-videos")).contentType(MediaType.APPLICATION_JSON));
		
		List<Video> videos = betaSeries.showOperations().getShowVideos(13);
		assertNotNull(videos);
		assertEquals(4, videos.size());
		assertEquals(6372, videos.get(0).getId());
		assertEquals(12, videos.get(0).getShowId());
		assertEquals("kYNPtDbykp0", videos.get(0).getYoutubeId());
		assertEquals("http://www.youtube.com/watch?v=kYNPtDbykp0", videos.get(0).getYoutubeUrl());
		assertEquals("Simpsons ALS Ice Bucket Challenge | THE SIMPSONS | ANIMATION on FOX ", videos.get(0).getTitle());
		assertEquals(0, videos.get(0).getSeason());
		assertEquals(0, videos.get(0).getEpisode());
		assertEquals("TheFlameBoy", videos.get(0).getLogin());
		assertEquals(401337, videos.get(0).getLoginId()); 
	}
	
	/**
	 * Adds the show.
	 */
	@Test
	public void addShow() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/shows/show")
		.andExpect(content().string("id=13"))
		.andRespond(withSuccess().body(jsonResource("shows-show-POST")).contentType(MediaType.APPLICATION_JSON));
		
		Show show = betaSeries.showOperations().addShow(13);
		assertNotNull(show);
		assertEquals(13, show.getId());
		assertTrue(show.isInAccount());
	}
	
	/**
	 * Adds the shows.
	 */
	@Test
	public void addShows() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/shows/show")
		.andExpect(content().string(buildUrlEncodedQueryString("id=4267,3903")))
		.andRespond(withSuccess().body(jsonResource("shows-show-multipleIds")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().addShows(new String[] {"4267","3903"});
		assertNotNull(shows);
		assertEquals(2, shows.size());
		assertEquals(4267, shows.get(0).getId());
		assertEquals(3903, shows.get(1).getId());
		assertTrue(shows.get(0).isInAccount());
		assertTrue(shows.get(1).isInAccount());
	}
	
	/**
	 * Removes the show.
	 */
	@Test
	public void removeShow() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/shows/show?id=13")		
		.andRespond(withSuccess().body(jsonResource("shows-show-DELETE")).contentType(MediaType.APPLICATION_JSON));
		
		Show show = betaSeries.showOperations().removeShow(13);
		assertNotNull(show);
		assertEquals(13, show.getId());
		assertFalse(show.isInAccount());
	}
	
	/**
	 * Removes the shows.
	 */
	@Test
	public void removeShows() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/shows/show?id=4267,3903")
		.andRespond(withSuccess().body(jsonResource("shows-show-multipleIds-DELETE")).contentType(MediaType.APPLICATION_JSON));
		
		List<Show> shows = betaSeries.showOperations().removeShows(new String[] {"4267","3903"});
		assertNotNull(shows);
		assertEquals(2, shows.size());
		assertEquals(4267, shows.get(0).getId());
		assertEquals(3903, shows.get(1).getId());
		assertFalse(shows.get(0).isInAccount());
		assertFalse(shows.get(1).isInAccount());
	}
	
	/**
	 * Assert show13.
	 *
	 * @param show
	 *            the show
	 */
	private void assertShow13(Show show) {
		assertNotNull(show);
		assertEquals(13, show.getId());
		assertEquals(80348, show.getTheTvDbId());
		assertEquals("tt0934814", show.getImDbId());
		assertEquals("Chuck", show.getTitle());
		assertEquals("Chuck, un informaticien d'une vingtaine d'années, renferme, dans son cerveau, une base de données contenant des secrets gouvernementaux. Il est bientôt recruté par John Casey, un ancien agent de la NSA (Agence de Sécurité Nationale), pour travailler dans le monde de l'espionnage avec sa nouvelle partenaire, Sarah. Sa vie se partage dès lors entre sa passion pour les ordinateurs et ses missions secrètes de la NSA.", show.getDescription());
		assertEquals("5", show.getNumberOfSeasons());
		assertNotNull(show.getSeasonsDetails());
		assertEquals(5, show.getSeasonsDetails().size());
		
		SeasonDetail sDetail = show.getSeasonsDetails().get(0);
		assertEquals(1, sDetail.getSeasonNumber());
		assertEquals(13, sDetail.getNumberOfEpisode());
		
		assertEquals("91", show.getNumberOfEpisodes());
		assertEquals("25492", show.getNumberOfFollowers());
		assertEquals("170", show.getNumberOfComments());
		assertEquals("23", show.getSimilars());
		assertEquals("16", show.getCharacters());
		assertEquals("2007", show.getYearsOfProduction());
		assertArrayEquals(new String[] {
				"Action",
				"Adventure",
				"Comedy",
				"Drama"}, show.getGenres());
		
		assertEquals("60", show.getEpisodeLength());
		assertEquals("NBC", show.getNetwork());
		assertEquals("TV-PG", show.getRating());
		assertEquals("Ended", show.getStatus());
		
		Note note = show.getNote();
		assertNotNull(note);
		assertEquals(1105, note.getTotal(), 1105);
		assertEquals(4.5593, note.getAverage(), 4.5593);
		assertEquals(5, note.getUserNote(), 5);
		
		assertTrue(show.isInAccount());
		
		UserDetail uDetails = show.getUserDetail();
		assertNotNull(uDetails);
		
		assertFalse(uDetails.isArchived());
		assertTrue(uDetails.isFavorited());
		assertEquals("91", uDetails.getRemaining());
		assertEquals("0", uDetails.getStatus());
		assertEquals("S00E00", uDetails.getLast());
		assertEquals("", uDetails.getTags());
		assertEquals("http://www.betaseries.com/serie/chuck", show.getResourceUrl());
	}
}
