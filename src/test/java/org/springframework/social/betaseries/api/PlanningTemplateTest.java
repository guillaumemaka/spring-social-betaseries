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

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanningTemplateTest.
 *
 * @author Guillaume Maka
 */
public class PlanningTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Gets the general planning.
	 *
	 * @return the general planning
	 * @throws Exception the exception
	 */
	@Test
	public void getGeneralPlanning() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));
		
		List<Episode> episodes = betaSeries.planningOperations().getGeneralPlanning();
		assertNotNull(episodes);
		assertEquals(71, episodes.size());
		assertThat(episodes.get(0), instanceOf(Episode.class));
	}
	
	/**
	 * Gets the general planning for date.
	 *
	 * @return the general planning for date
	 * @throws Exception the exception
	 */
	@Test
	public void getGeneralPlanningForDate() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general?date=2015-01-01")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getGeneralPlanning(dateFromString("2015-01-01"));		
	}
	
	/**
	 * Gets the general planning for date before.
	 *
	 * @return the general planning for date before
	 * @throws Exception the exception
	 */
	@Test
	public void getGeneralPlanningForDateBefore() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general?date=2015-01-01&before=20")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getGeneralPlanning(dateFromString("2015-01-01"), 20);		
	}
	
	/**
	 * Gets the general planning for date before and after.
	 *
	 * @return the general planning for date before and after
	 * @throws Exception the exception
	 */
	@Test
	public void getGeneralPlanningForDateBeforeAndAfter() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general?date=2015-01-01&before=20&after=10")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getGeneralPlanning(dateFromString("2015-01-01"), 20, 10);		
	}
	
	/**
	 * Gets the general planning for date before and after with type.
	 *
	 * @return the general planning for date before and after with type
	 * @throws Exception the exception
	 */
	@Test
	public void getGeneralPlanningForDateBeforeAndAfterWithType() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/general?date=2015-01-01&before=20&after=10&type=premieres")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getGeneralPlanning(dateFromString("2015-01-01"), 20, 10, BSPlanningEpisodeType.PREMIERES);		
	}
	
	/**
	 * Gets the incoming planning.
	 *
	 * @return the incoming planning
	 * @throws Exception the exception
	 */
	@Test
	public void getIncomingPlanning() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/incoming")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getIncomingPlanning();		
	}
	
	/**
	 * Gets the current member planning.
	 *
	 * @return the current member planning
	 * @throws Exception the exception
	 */
	@Test
	public void getCurrentMemberPlanning() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning();		
	}
	
	/**
	 * Gets the current member planning unseen only.
	 *
	 * @return the current member planning unseen only
	 * @throws Exception the exception
	 */
	@Test
	public void getCurrentMemberPlanningUnseenOnly() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?unseen=1")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(true);		
	}
	
	/**
	 * Gets the current member planning unseen only for month.
	 *
	 * @return the current member planning unseen only for month
	 * @throws Exception the exception
	 */
	@Test
	public void getCurrentMemberPlanningUnseenOnlyForMonth() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?unseen=1&month=2015-01")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(true, dateFromString("2015-01", "yyyy-MM"));		
	}
	
	// -----------------------------------
	
	/**
	 * Gets the t member planning.
	 *
	 * @return the t member planning
	 * @throws Exception the exception
	 */
	@Test
	public void gettMemberPlanning() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?id=2222")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(2222);		
	}
	
	/**
	 * Gets the member planning unseen only.
	 *
	 * @return the member planning unseen only
	 * @throws Exception the exception
	 */
	@Test
	public void getMemberPlanningUnseenOnly() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?id=2222&unseen=1")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(2222, true);		
	}
	
	/**
	 * Gets the member planning unseen only for month.
	 *
	 * @return the member planning unseen only for month
	 * @throws Exception the exception
	 */
	@Test
	public void getMemberPlanningUnseenOnlyForMonth() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/planning/member?id=2222&unseen=1&month=2015-01")
		.andRespond(withSuccess().body(jsonResource("planning-general")).contentType(MediaType.APPLICATION_JSON));		
		betaSeries.planningOperations().getMemberPlanning(2222, true, dateFromString("2015-01", "yyyy-MM"));		
	}
}
