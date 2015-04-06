package org.springframework.social.betaseries.api;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

public class PlanningTemplateTest extends AbstractBetaSeriesApiTest {
	@Test
	public void getGeneralPlanning() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));
		
		List<Episode> episodes = betaSeries.planningOperations().getGeneralPlanning();
		assertNotNull(episodes);
		assertEquals(71, episodes.size());
		assertThat(episodes.get(0), instanceOf(Episode.class));
	}
	
	@Test
	public void getGeneralPlanningForDate() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general?date=2015-01-01")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getGeneralPlanning(dateFromString("2015-01-01"));		
	}
	
	@Test
	public void getGeneralPlanningForDateBefore() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general?date=2015-01-01&before=20")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getGeneralPlanning(dateFromString("2015-01-01"), 20);		
	}
	
	@Test
	public void getGeneralPlanningForDateBeforeAndAfter() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general?date=2015-01-01&before=20&after=10")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getGeneralPlanning(dateFromString("2015-01-01"), 20, 10);		
	}
	
	@Test
	public void getGeneralPlanningForDateBeforeAndAfterWithType() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general?date=2015-01-01&before=20&after=10&type=premieres")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getGeneralPlanning(dateFromString("2015-01-01"), 20, 10, BSPlanningEpisodeType.PREMIERES);		
	}
	
	@Test
	public void getIncomingPlanning() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/incoming")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getIncomingPlanning();		
	}
	
	@Test
	public void getCurrentMemberPlanning() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning();		
	}
	
	@Test
	public void getCurrentMemberPlanningUnseenOnly() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?unseen=1")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(true);		
	}
	
	@Test
	public void getCurrentMemberPlanningUnseenOnlyForMonth() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?unseen=1&month=2015-01")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(true, dateFromString("2015-01", "yyyy-MM"));		
	}
	
	// -----------------------------------
	
	@Test
	public void gettMemberPlanning() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?id=2222")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(2222);		
	}
	
	@Test
	public void getMemberPlanningUnseenOnly() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?id=2222&unseen=1")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(2222, true);		
	}
	
	@Test
	public void getMemberPlanningUnseenOnlyForMonth() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?id=2222&unseen=1&month=2015-01")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(2222, true, dateFromString("2015-01", "yyyy-MM"));		
	}
}
