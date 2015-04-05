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

// TODO: Auto-generated Javadoc
/**
 * The Class TimelineTemplateTest.
 *
 * @author Guillaume Maka
 */
public class TimelineTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Gets the friends timeline.
	 *
	 * @return the friends timeline
	 * @throws Exception the exception
	 */
	@Test
	public void getFriendsTimeline() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));
		
		List<Event> events = betaSeries.timelineOperations().getFriendsTimeline();
		assertNotNull(events);
		assertEquals(10, events.size());
		assertThat(events.get(0), is(instanceOf(Event.class)));
	}
	
	/**
	 * Gets the friends timeline nbpp.
	 *
	 * @return the friends timeline nbpp
	 * @throws Exception the exception
	 */
	@Test
	public void getFriendsTimelineNbpp() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends?nbpp=100")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getFriendsTimeline(100);		
	}
	
	/**
	 * Gets the friends timeline nbpp since id.
	 *
	 * @return the friends timeline nbpp since id
	 * @throws Exception the exception
	 */
	@Test
	public void getFriendsTimelineNbppSinceId() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends?nbpp=100&since_id=2222")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getFriendsTimeline(100, 2222);		
	}
	
	/**
	 * Gets the friends timeline nbpp since id only types.
	 *
	 * @return the friends timeline nbpp since id only types
	 * @throws Exception the exception
	 */
	@Test
	public void getFriendsTimelineNbppSinceIdOnlyTypes() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends?nbpp=100&since_id=2222&types=markas,comment,forum")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getFriendsTimeline(100, 2222, new BSTimelineEventType[] {BSTimelineEventType.MARKAS, BSTimelineEventType.COMMENT, BSTimelineEventType.FORUM});		
	}
	
	/**
	 * Gets the home timeline.
	 *
	 * @return the home timeline
	 * @throws Exception the exception
	 */
	@Test
	public void getHomeTimeline() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/friends")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));
	}
	
	/**
	 * Gets the home timeline nbpp.
	 *
	 * @return the home timeline nbpp
	 * @throws Exception the exception
	 */
	@Test
	public void getHomeTimelineNbpp() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/home?nbpp=100")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getHomeTimeline(100);		
	}
	
	/**
	 * Gets the home timeline nbpp since id.
	 *
	 * @return the home timeline nbpp since id
	 * @throws Exception the exception
	 */
	@Test
	public void getHomeTimelineNbppSinceId() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/home?nbpp=100&since_id=2222")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getHomeTimeline(100, 2222);		
	}
	
	/**
	 * Gets the home timeline nbpp since id only types.
	 *
	 * @return the home timeline nbpp since id only types
	 * @throws Exception the exception
	 */
	@Test
	public void getHomeTimelineNbppSinceIdOnlyTypes() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/home?nbpp=100&since_id=2222&types=markas,comment,forum")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getHomeTimeline(100, 2222, new BSTimelineEventType[] {BSTimelineEventType.MARKAS, BSTimelineEventType.COMMENT, BSTimelineEventType.FORUM});		
	}
	
	/**
	 * Gets the member timeline.
	 *
	 * @return the member timeline
	 * @throws Exception the exception
	 */
	@Test
	public void getMemberTimeline() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/member?id=2222")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.timelineOperations().getMemberTimeline(2222);
	}
	
	/**
	 * Gets the member timeline nbpp.
	 *
	 * @return the member timeline nbpp
	 * @throws Exception the exception
	 */
	@Test
	public void getMemberTimelineNbpp() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/member?id=2222&nbpp=100")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getMemberTimeline(2222, 100);		
	}
	
	/**
	 * Gets the member timeline nbpp since id.
	 *
	 * @return the member timeline nbpp since id
	 * @throws Exception the exception
	 */
	@Test
	public void getMemberTimelineNbppSinceId() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/member?id=2222&nbpp=100&since_id=2222")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getMemberTimeline(2222, 100, 2222);		
	}
	
	/**
	 * Gets the member timeline nbpp since id only types.
	 *
	 * @return the member timeline nbpp since id only types
	 * @throws Exception the exception
	 */
	@Test
	public void getMemberTimelineNbppSinceIdOnlyTypes() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/timeline/member?id=2222&nbpp=100&since_id=2222&types=markas,comment,forum")
		.andRespond(withSuccess().body(jsonResource("timeline-events")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.timelineOperations().getMemberTimeline(2222, 100, 2222, new BSTimelineEventType[] {BSTimelineEventType.MARKAS, BSTimelineEventType.COMMENT, BSTimelineEventType.FORUM});		
	}
}
