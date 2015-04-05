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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class EpisodeTemplateTest.
 *
 * @author Guillaume Maka
 */
public class EpisodeTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Gets the by ids.
	 *
	 * @return the by ids
	 */
	@Test
	public void getByIds() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/display?id=264473,264474")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-display-multi-ids-without-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		List<Episode> episodes = betaSeries.episodeOperations().getByIds(
				new String[] { "264473", "264474" });
		Episode episode1 = episodes.get(0);
		assertEquals(2, episodes.size());
		assertEpisode1(episode1);

		Episode episode2 = episodes.get(1);
		assertEpisode2(episode2);
	}

	/**
	 * Gets the by tv db ids.
	 *
	 * @return the by tv db ids
	 */
	@Test
	public void getByTvDbIds() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/display?thetvdb_id=55452,55453")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-display-multi-ids-without-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		List<Episode> episodes = betaSeries.episodeOperations().getByTvDbIds(
				new String[] { "55452", "55453" });
		Episode episode1 = episodes.get(0);
		assertEquals(2, episodes.size());
		assertEpisode1(episode1);

		Episode episode2 = episodes.get(1);
		assertEpisode2(episode2);
	}

	/**
	 * Gets the by ids subtitles.
	 *
	 * @return the by ids subtitles
	 */
	public void getByIdsSubtitles() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/display?id=264473,264474&subtitles=true")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-display-with-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		List<Episode> episodes = betaSeries.episodeOperations().getByIds(
				new String[] { "264473", "264474" }, true);
		Episode episode1 = episodes.get(0);
		assertEquals(2, episodes.size());
		assertEpisode1(episode1);

		assertEquals(4, episode1.getSubtitles().size());
		Subtitle subtitle1 = episode1.getSubtitles().get(0);
		assertEpisode1Subtitles1(subtitle1);

		Episode episode2 = episodes.get(1);
		assertEpisode2(episode2);
		assertEquals(2, episode2.getSubtitles().size());

		Subtitle subtitleE2s1 = episode2.getSubtitles().get(0);
		assertEpisode2Subtitles1(subtitleE2s1);

		Subtitle subtitleE2s2 = episode2.getSubtitles().get(1);
		assertEpisode2Subtitles2(subtitleE2s2);
	}

	/**
	 * Gets the by tv db ids subtitles.
	 *
	 * @return the by tv db ids subtitles
	 */
	@Test
	public void getByTvDbIdsSubtitles() {
		constructGetMockRequest(
				mockServer,
				"https://api.betaseries.com/episodes/display?thetvdb_id=55452,55453&subtitles=true")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-display-multi-ids-with-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		List<Episode> episodes = betaSeries.episodeOperations().getByTvDbIds(
				new String[] { "55452", "55453" }, true);
		Episode episode1 = episodes.get(0);
		assertEquals(2, episodes.size());
		assertEpisode1(episode1);
		assertEquals(4, episode1.getSubtitles().size());

		Subtitle subtitle1 = episode1.getSubtitles().get(0);
		assertEpisode1Subtitles1(subtitle1);

		Subtitle subtitle2 = episode1.getSubtitles().get(1);
		assertEpisode1Subtitles2(subtitle2);

		Episode episode2 = episodes.get(1);
		assertEpisode2(episode2);
		assertEquals(2, episode2.getSubtitles().size());

		Subtitle subtitleE2s1 = episode2.getSubtitles().get(0);
		assertEpisode2Subtitles1(subtitleE2s1);

		Subtitle subtitleE2s2 = episode2.getSubtitles().get(1);
		assertEpisode2Subtitles2(subtitleE2s2);
	}

	/**
	 * Gets the episodes to be watch.
	 *
	 * @return the episodes to be watch
	 */
	@Test
	public void getEpisodesToBeWatch() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/list").andRespond(
				withSuccess().body(
						jsonResource("episodes-list-without-subtitles"))
						.contentType(MediaType.APPLICATION_JSON));

		List<UnseenEpisode> unseens = betaSeries.episodeOperations()
				.getEpisodesToBeWatch();
		UnseenEpisode unseen = unseens.get(0);

		assertEquals(1, unseens.size());
		assertEquals(12, unseen.getShowId());
		assertEquals(71663, unseen.getTheTvDbId());
		assertEquals("The Simpsons", unseen.getTitle());
		assertEquals(560, unseen.getRemaining());
		assertEquals(560, unseen.getEpisodes().size());

		Episode episode = unseen.getEpisodes().get(0);
		assertEpisode2(episode);
	}

	/**
	 * Gets the episodes to be watch with subtitles.
	 *
	 * @return the episodes to be watch with subtitles
	 */
	@Test
	public void getEpisodesToBeWatchWithSubtitles() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/list?subtitles=all")
				.andRespond(
						withSuccess().body(
								jsonResource("episodes-list-with-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		List<UnseenEpisode> unseens = betaSeries.episodeOperations()
				.getEpisodesToBeWatch(null, 0, null, BSSubtitles.ALL);
		UnseenEpisode unseen = unseens.get(0);

		assertEquals(1, unseens.size());
		assertEquals(12, unseen.getShowId());
		assertEquals(71663, unseen.getTheTvDbId());
		assertEquals("The Simpsons", unseen.getTitle());
		assertEquals(560, unseen.getRemaining());
		assertEquals(560, unseen.getEpisodes().size());

		Episode episode = unseen.getEpisodes().get(0);
		assertEpisode2(episode);
		assertEquals(2, episode.getSubtitles().size());
	}

	/**
	 * Search.
	 */
	@Test
	public void search() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/search?show_id=12&number=1")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-search-showiId12-numberS01E01"))
								.contentType(MediaType.APPLICATION_JSON));
		Episode result = betaSeries.episodeOperations()
				.search("12", "1", false);
		assertEpisode1(result);
	}

	/**
	 * Search subtitles include.
	 */
	@Test
	public void searchSubtitlesInclude() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/search?show_id=12&number=1&subtitles=true")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-search-showiId12-numberS01E01-with-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));
		Episode result = betaSeries.episodeOperations().search("12", "1", true);
		assertEpisode1(result);
		assertEquals(4, result.getSubtitles().size());
		assertEpisode1Subtitles1(result.getSubtitles().get(0));
	}

	/**
	 * Gets the by id.
	 *
	 * @return the by id
	 */
	@Test
	public void getById() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/display?id=264473")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-display-without-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		Episode episode = betaSeries.episodeOperations().getById("264473");
		assertEpisode1(episode);
	}

	/**
	 * Gets the by the tv db id.
	 *
	 * @return the by the tv db id
	 */
	@Test
	public void getByTheTvDbId() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/display?thetvdb_id=55452")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-display-without-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		Episode episode = betaSeries.episodeOperations()
				.getByTheTvDbId("55452");
		assertEpisode1(episode);
	}

	/**
	 * Gets the by id subtitles.
	 *
	 * @return the by id subtitles
	 */
	@Test
	public void getByIdSubtitles() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/display?id=264473&subtitles=true")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-display-with-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		Episode episode = betaSeries.episodeOperations()
				.getById("264473", true);
		assertEpisode1(episode);
		assertEpisode1Subtitles1(episode.getSubtitles().get(0));
	}

	/**
	 * Gets the by the tv db id subtitles.
	 *
	 * @return the by the tv db id subtitles
	 */
	@Test
	public void getByTheTvDbIdSubtitles() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/episodes/display?thetvdb_id=55452&subtitles=true")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-display-with-subtitles"))
								.contentType(MediaType.APPLICATION_JSON));

		Episode episode = betaSeries.episodeOperations().getByTheTvDbId(
				"55452", true);
		assertEpisode1(episode);
		assertEpisode1Subtitles1(episode.getSubtitles().get(0));
	}

	/**
	 * Mark as downloaded.
	 */
	@Test
	public void markAsDownloaded() {
		constructPostMockRequest(mockServer,
				"https://api.betaseries.com/episodes/downloaded")
				.andRespond(
						withSuccess().body(
								jsonResource("episodes-downloaded-POST"))
								.contentType(MediaType.APPLICATION_JSON));
		Episode episode = betaSeries.episodeOperations().markAsDownloaded(
				"264473");
		assertTrue(episode.isDownloaded());
	}

	/**
	 * Unmark as downloaded.
	 */
	@Test
	public void unmarkAsDownloaded() {
		constructDeleteMockRequest(mockServer,
				"https://api.betaseries.com/episodes/downloaded?id=264473")
				.andRespond(
						withSuccess().body(
								jsonResource("episodes-downloaded-DELETE"))
								.contentType(MediaType.APPLICATION_JSON));
		Episode episode = betaSeries.episodeOperations().unmarkAsDownloaded(
				"264473");
		assertFalse(episode.isDownloaded());
	}

	/**
	 * Mark as watched.
	 */
	@Test
	public void markAsWatched() {
		constructPostMockRequest(mockServer,
				"https://api.betaseries.com/episodes/watched")
				.andRespond(
						withSuccess().body(
								jsonResource("episodes-watched-POST"))
								.contentType(MediaType.APPLICATION_JSON));
		Episode episode = betaSeries.episodeOperations()
				.markAsWatched("264473");
		assertTrue(episode.isSeen());
	}

	/**
	 * Un mark as watched.
	 */
	@Test
	public void unMarkAsWatched() {
		constructDeleteMockRequest(mockServer,
				"https://api.betaseries.com/episodes/watched?id=264473")
				.andRespond(
						withSuccess().body(
								jsonResource("episodes-watched-DELETE"))
								.contentType(MediaType.APPLICATION_JSON));
		Episode episode = betaSeries.episodeOperations().unMarkAsWatched(
				"264473");
		assertFalse(episode.isSeen());
	}

	/**
	 * Rate episode.
	 */
	@Test
	public void rateEpisode() {
		constructPostMockRequest(mockServer,
				"https://api.betaseries.com/episodes/note")
				.andRespond(
						withSuccess().body(jsonResource("episodes-note-5"))
								.contentType(MediaType.APPLICATION_JSON));
		Episode episode = betaSeries.episodeOperations().rateEpisode("264473",
				5);
		assertEquals(5, episode.getNote().getUserNote(), 5);
	}

	/**
	 * Un rate episode.
	 */
	@Test
	public void unRateEpisode() {
		constructDeleteMockRequest(mockServer,
				"https://api.betaseries.com/episodes/note?id=264473")
				.andRespond(
						withSuccess()
								.body(jsonResource("episodes-note-delete"))
								.contentType(MediaType.APPLICATION_JSON));
		Episode episode = betaSeries.episodeOperations().unRateEpisode(
				"264473");
		assertEquals(0, episode.getNote().getUserNote(), 0);
	}

	/**
	 * Assert episode2.
	 *
	 * @param episode
	 *            the episode
	 */
	private void assertEpisode2(Episode episode) {
		assertEquals(264474, episode.getId());
		assertEquals(55453, episode.getTheTvDbId());
		assertEquals("Bart the Genius", episode.getTitle());
		assertEquals(1, episode.getSeasonNumber());
		assertEquals(2, episode.getEpisodeNumber());
		assertEquals(12, episode.getShowId());
		assertEquals(71663, episode.getShowTvDbId());
		assertEquals("The Simpsons", episode.getShowTitle());
		assertEquals("S01E02", episode.getCode());
		assertEquals(2, episode.getGlobal());
		assertEquals(
				"Toute la famille est réunie autour d'une table pour jouer au scrable. Bart est d'humeur joyeuse et Lisa lui rappelle qu'il a plutôt intérêt à réviser pour les tests qu'il va devoir passer.",
				episode.getDescription());
		assertEquals(dateFromString("1990-01-15"), episode.getAirDate());
		assertEquals(110, episode.getNote().getTotal(), 110);
		assertEquals(4.25, episode.getNote().getAverage(), 4.25);
		assertEquals(0, episode.getNote().getUserNote(), 0);
		assertFalse(episode.isSeen());
		assertFalse(episode.isDownloaded());
		assertEquals(0, episode.getNumberOfComment());
	}

	/**
	 * Assert episode1.
	 *
	 * @param episode
	 *            the episode
	 */
	private void assertEpisode1(Episode episode) {
		assertEquals(264473, episode.getId());
		assertEquals(55452, episode.getTheTvDbId());
		assertEquals("Simpsons Roasting on an Open Fire", episode.getTitle());
		assertEquals(1, episode.getSeasonNumber());
		assertEquals(1, episode.getEpisodeNumber());
		assertEquals(12, episode.getShowId());
		assertEquals(71663, episode.getShowTvDbId());
		assertEquals("The Simpsons", episode.getShowTitle());
		assertEquals("S01E01", episode.getCode());
		assertEquals(1, episode.getGlobal());
		assertEquals(
				"Ce soir, les Simpson assistent à la fête de Noël de l'école dans laquelle Bart et Lisa participent. De retour à la maison, les enfants rédigent leur lettre pour le Père Noël : Lisa réclame pour la énième année un poney et Bart veut un tatouage.",
				episode.getDescription());
		assertEquals(dateFromString("1989-12-18"), episode.getAirDate());
		assertEquals(164, episode.getNote().getTotal(), 164);
		assertEquals(4.16, episode.getNote().getAverage(), 4.16);
		assertEquals(5, episode.getNote().getUserNote(), 5);
		assertTrue(episode.isSeen());
		assertTrue(episode.isDownloaded());
		assertEquals(4, episode.getNumberOfComment());
	}

	/**
	 * Assert episode1 subtitles1.
	 *
	 * @param subtitle
	 *            the subtitle
	 */
	private void assertEpisode1Subtitles1(Subtitle subtitle) {
		assertEquals(129901, subtitle.getId());
		assertEquals("VO", subtitle.getLanguage());
		assertEquals("tvsubtitles", subtitle.getSource());
		assertEquals(1, subtitle.getQuality());
		assertEquals("The Simpsons_1x01_en.zip", subtitle.getFile());
		assertEquals("https://www.betaseries.com/srt/129901", subtitle.getUrl());
		assertEquals(
				dateFromString("2007-07-01 16:13:32", BS_DATE_AND_TIME_FORMAT),
				subtitle.getDate());
	}

	/**
	 * Assert episode1 subtitles2.
	 *
	 * @param subtitle
	 *            the subtitle
	 */
	private void assertEpisode1Subtitles2(Subtitle subtitle) {
		assertEquals(129907, subtitle.getId());
		assertEquals("VF", subtitle.getLanguage());
		assertEquals("tvsubtitles", subtitle.getSource());
		assertEquals(1, subtitle.getQuality());
		assertEquals("The Simpsons_1x01_fr.zip", subtitle.getFile());
		assertEquals("https://www.betaseries.com/srt/129907", subtitle.getUrl());
		assertEquals(
				dateFromString("2008-05-10 16:36:44", BS_DATE_AND_TIME_FORMAT),
				subtitle.getDate());
	}

	/**
	 * Assert episode2 subtitles1.
	 *
	 * @param subtitle
	 *            the subtitle
	 */
	private void assertEpisode2Subtitles1(Subtitle subtitle) {
		assertEquals(129889, subtitle.getId());
		assertEquals("VO", subtitle.getLanguage());
		assertEquals("tvsubtitles", subtitle.getSource());
		assertEquals(1, subtitle.getQuality());
		assertEquals("The Simpsons_1x02_en.zip", subtitle.getFile());
		assertEquals("https://www.betaseries.com/srt/129889", subtitle.getUrl());
		assertEquals(
				dateFromString("2007-07-01 16:13:38", BS_DATE_AND_TIME_FORMAT),
				subtitle.getDate());
	}

	/**
	 * Assert episode2 subtitles2.
	 *
	 * @param subtitle
	 *            the subtitle
	 */
	private void assertEpisode2Subtitles2(Subtitle subtitle) {
		assertEquals(129895, subtitle.getId());
		assertEquals("VF", subtitle.getLanguage());
		assertEquals("tvsubtitles", subtitle.getSource());
		assertEquals(1, subtitle.getQuality());
		assertEquals("The Simpsons_1x02_fr.zip", subtitle.getFile());
		assertEquals("https://www.betaseries.com/srt/129895", subtitle.getUrl());
		assertEquals(
				dateFromString("2008-05-10 16:36:53", BS_DATE_AND_TIME_FORMAT),
				subtitle.getDate());
	}
}
