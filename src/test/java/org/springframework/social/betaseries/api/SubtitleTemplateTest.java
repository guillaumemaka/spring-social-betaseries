package org.springframework.social.betaseries.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

public class SubtitleTemplateTest extends AbstractBetaSeriesApiTest {
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
	
	@Test
	public void getEpisodeSubtitlesForLanguage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/episode?id=420595&language=vo")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getSubtitlesForEpisode(420595, BSSubtitles.VO);
	}
	
	@Test
	public void getShowSubtitles() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/show?id=420595")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getSubtitlesForShow(420595);		
	}
	
	@Test
	public void getShowSubtitlesForLanguage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/show?id=420595&language=vo")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getSubtitlesForShow(420595, BSSubtitles.VO);
	}
	
	@Test
	public void getLastAddedSubtitles() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/last")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getLastAddedSubtitles();
	}
	
	@Test
	public void getLastAddedSubtitlesForNumber() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/last?number=50")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getLastAddedSubtitles(50);
	}
	
	@Test
	public void getLastAddedSubtitlesForNumberAmdLanguage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/subtitles/last?number=50&language=vo")
		.andRespond(withSuccess().body(jsonResource("subtitles-response")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().getLastAddedSubtitles(50, BSSubtitles.VO);
	}
	
	@Test
	public void postReport() throws Exception {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/subtitles/report")
		.andExpect(content().string("id=2222&reason=not+found"))
		.andRespond(withSuccess().body(jsonResource("subtitles-report")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.subtitleOperations().reportIncorrectSubtitle(2222, "not found");
	}
}
