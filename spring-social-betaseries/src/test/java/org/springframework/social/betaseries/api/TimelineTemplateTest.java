package org.springframework.social.betaseries.api;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

public class TimelineTemplateTest extends AbstractBetaSeriesApiTest {
	@Test
	public void getFriendsTimeline() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));
		
		List<Event> events = betaSeries.timelineOperations().getFriendsTimeline();
		assertNotNull(events);
		assertEquals(10, events.size());
		assertThat(events.get(0), is(instanceOf(Event.class)));
	}
	
	@Test
	public void getFriendsTimelineNbpp() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends?nbpp=100")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getFriendsTimeline(100);		
	}
	
	@Test
	public void getFriendsTimelineNbppSinceId() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends?nbpp=100&since_id=2222")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getFriendsTimeline(100, 2222);		
	}
	
	@Test
	public void getFriendsTimelineNbppSinceIdOnlyTypes() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends?nbpp=100&since_id=2222&types=markas,comment,forum")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getFriendsTimeline(100, 2222, new BSTimelineEventType[] {BSTimelineEventType.MARKAS, BSTimelineEventType.COMMENT, BSTimelineEventType.FORUM});		
	}
	
	@Test
	public void getHomeTimeline() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getHomeTimelineNbpp() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/home?nbpp=100")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getHomeTimeline(100);		
	}
	
	@Test
	public void getHomeTimelineNbppSinceId() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/home?nbpp=100&since_id=2222")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getHomeTimeline(100, 2222);		
	}
	
	@Test
	public void getHomeTimelineNbppSinceIdOnlyTypes() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/home?nbpp=100&since_id=2222&types=markas,comment,forum")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getHomeTimeline(100, 2222, new BSTimelineEventType[] {BSTimelineEventType.MARKAS, BSTimelineEventType.COMMENT, BSTimelineEventType.FORUM});		
	}
	
	@Test
	public void getMemberTimeline() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/member?id=2222")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.timelineOperations().getMemberTimeline(2222);
	}
	
	@Test
	public void getMemberTimelineNbpp() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/member?id=2222&nbpp=100")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getMemberTimeline(2222, 100);		
	}
	
	@Test
	public void getMemberTimelineNbppSinceId() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/member?id=2222&nbpp=100&since_id=2222")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getMemberTimeline(2222, 100, 2222);		
	}
	
	@Test
	public void getMemberTimelineNbppSinceIdOnlyTypes() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/member?id=2222&nbpp=100&since_id=2222&types=markas,comment,forum")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getMemberTimeline(2222, 100, 2222, new BSTimelineEventType[] {BSTimelineEventType.MARKAS, BSTimelineEventType.COMMENT, BSTimelineEventType.FORUM});		
	}
}
