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
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class SubtitleTemplateTest.
 *
 * @author Guillaume Maka
 */
public class SubtitleTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Gets the episode subtitles.
	 *
	 * @return the episode subtitles
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getEpisodeSubtitles() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/episode?id=420595")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		List<Subtitle> subtitles = betaSeries.subtitleOperations().getSubtitlesForEpisode(420595);
		assertNotNull(subtitles);
		assertEquals(10, subtitles.size());
		assertEquals(420595, subtitles.get(0).getEpisode().getEpisodeId());
		assertEquals(0, subtitles.get(0).getContent().size());
	}
	
	/**
	 * Gets the episode subtitles for language.
	 *
	 * @return the episode subtitles for language
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getEpisodeSubtitlesForLanguage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/episode?id=420595&language=vo")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getSubtitlesForEpisode(420595, BSSubtitles.VO);
	}
	
	/**
	 * Gets the show subtitles.
	 *
	 * @return the show subtitles
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getShowSubtitles() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/show?id=420595")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getSubtitlesForShow(420595);		
	}
	
	/**
	 * Gets the show subtitles for language.
	 *
	 * @return the show subtitles for language
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getShowSubtitlesForLanguage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/show?id=420595&language=vo")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getSubtitlesForShow(420595, BSSubtitles.VO);
	}
	
	/**
	 * Gets the last added subtitles.
	 *
	 * @return the last added subtitles
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getLastAddedSubtitles() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/last")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getLastAddedSubtitles();
	}
	
	/**
	 * Gets the last added subtitles for number.
	 *
	 * @return the last added subtitles for number
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getLastAddedSubtitlesForNumber() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/last?number=50")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getLastAddedSubtitles(50);
	}
	
	/**
	 * Gets the last added subtitles for number amd language.
	 *
	 * @return the last added subtitles for number amd language
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getLastAddedSubtitlesForNumberAmdLanguage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/last?number=50&language=vo")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getLastAddedSubtitles(50, BSSubtitles.VO);
	}
	
	/**
	 * Post report.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void postReport() throws Exception {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/subtitles/report")
		.andExpect(content().string("id=2222&reason=not+found"))
		.andRespond(withSuccess().body(jsonResource("subtitles-report")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().reportIncorrectSubtitle(2222, "not found");
	}
}
