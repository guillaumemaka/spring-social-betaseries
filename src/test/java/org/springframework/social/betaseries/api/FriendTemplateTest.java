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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class FriendTemplateTest.
 *
 * @author Guillaume Maka
 */
public class FriendTemplateTest extends AbstractBetaSeriesApiTest {

	/**
	 * Block.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void block() throws Exception {
		constructPostMockRequest(mockServer,
				"https://api.betaseries.com/friends/block").andExpect(
				content().string("id=130446")).andRespond(
				withSuccess().body(jsonResource("friends-block-POST"))
						.contentType(MediaType.APPLICATION_JSON));

		Member blockedMember = betaSeries.friendOperations().block(130446);
		assertNotNull(blockedMember);
		assertEquals("26977", blockedMember.getMemberId());
		assertEquals("Dev039", blockedMember.getLogin());
		assertEquals(1100, blockedMember.getXp());
		assertEquals(1406931956, blockedMember.getCached());
		assertNull(blockedMember.getAvatarUrl());
		assertFalse(blockedMember.isInAccount());
		assertEquals(1, blockedMember.getStats().getNumberOfFriends());
		assertEquals(0, blockedMember.getStats().getNumberOfShows());
		assertEquals(0, blockedMember.getStats().getNumberOfSeasons());
		assertEquals(0, blockedMember.getStats().getNumberOfComments());
		assertEquals(100, blockedMember.getStats().getProgress(), 100);
		assertEquals(0, blockedMember.getStats().getEpisodesToWatch());
		assertEquals(0, blockedMember.getStats().getTimeToSpend());
		assertEquals(0, blockedMember.getStats().getTimeOnTv());
		assertEquals(0, blockedMember.getStats().getBadges());		
	}
	
	/**
	 * Unblock.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void unblock() throws Exception {
		constructDeleteMockRequest(mockServer,
				"https://api.betaseries.com/friends/block?id=130446")
				.andRespond(
				withSuccess().body(jsonResource("friends-block-DELETE"))
						.contentType(MediaType.APPLICATION_JSON));

		Member unblockedMember = betaSeries.friendOperations().unblock(130446);
		assertNotNull(unblockedMember);
		assertEquals("26977", unblockedMember.getMemberId());
		assertEquals("Dev039", unblockedMember.getLogin());
		assertEquals(1100, unblockedMember.getXp());
		assertEquals(1406931956, unblockedMember.getCached());
		assertNull(unblockedMember.getAvatarUrl());
		assertFalse(unblockedMember.isInAccount());
		assertEquals(1, unblockedMember.getStats().getNumberOfFriends());
		assertEquals(0, unblockedMember.getStats().getNumberOfShows());
		assertEquals(0, unblockedMember.getStats().getNumberOfSeasons());
		assertEquals(0, unblockedMember.getStats().getNumberOfComments());
		assertEquals(100, unblockedMember.getStats().getProgress(), 100);
		assertEquals(0, unblockedMember.getStats().getEpisodesToWatch());
		assertEquals(0, unblockedMember.getStats().getTimeToSpend());
		assertEquals(0, unblockedMember.getStats().getTimeOnTv());
		assertEquals(0, unblockedMember.getStats().getBadges());		
	}
	
	/**
	 * Gets the friends list.
	 *
	 * @return the friends list
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getFriendsList() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/friends/list")
		.andRespond(withSuccess().body(jsonResource("friends-list")).contentType(MediaType.APPLICATION_JSON));
		
		List<BSUser> friends = betaSeries.friendOperations().getFriendsList();
		assertNotNull(friends);
		assertEquals(3, friends.size());
		assertEquals("blackstones", friends.get(0).getLogin());
	}
	
	/**
	 * Gets the blocked friends list.
	 *
	 * @return the blocked friends list
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getBlockedFriendsList() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/friends/list?blocked=1")
		.andRespond(withSuccess().body(jsonResource("friends-list")).contentType(MediaType.APPLICATION_JSON));
		
		List<BSUser> friends = betaSeries.friendOperations().getBlockedFriendsList();
		assertNotNull(friends);
		assertEquals(3, friends.size());
		assertEquals("blackstones", friends.get(0).getLogin());
	}
}
