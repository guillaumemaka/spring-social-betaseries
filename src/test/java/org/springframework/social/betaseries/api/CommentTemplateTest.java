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
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentTemplateTest.
 *
 * @author Guillaume Maka
 */
public class CommentTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getComments() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/comments/comments?id=2410&type=show")
		.andRespond(withSuccess().body(jsonResource("comments-comments")).contentType(MediaType.APPLICATION_JSON));
		
		List<Comment> comments = betaSeries.commentOperations().getCommentsFor(BSObjectType.SHOW, "2410");
		assertNotNull(comments);
		assertEquals(10, comments.size());		
		assertEquals(982, comments.get(0).getId());
		assertEquals(3820, comments.get(0).getUserId());
		assertEquals("zeppelinlg", comments.get(0).getLogin());
		assertEquals("http://cdn.betaseries.com/betaseries/data/avatars/eb/ebb4dfc605c9be0056583989680c2b3c.jpg", comments.get(0).getAvatarUrl());
		assertEquals(dateFromString("2010-04-07 00:46:18", BS_DATE_AND_TIME_FORMAT), comments.get(0).getCreatedAt());
		assertEquals("Complétement accro aussi", comments.get(0).getText());
		assertEquals(1, comments.get(0).getInnerId());
		assertEquals(0, comments.get(0).getInReplyTo());
		assertEquals(0, comments.get(0).getNumberOfReplies());		                
	}
	
	/**
	 * Gets the comments nbpp20.
	 *
	 * @return the comments nbpp20
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getCommentsNbpp20() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/comments/comments?id=2410&type=show&nbpp=20")
		.andRespond(withSuccess().body(jsonResource("comments-comments-nbpp_20")).contentType(MediaType.APPLICATION_JSON));
		
		List<Comment> comments = betaSeries.commentOperations().getCommentsFor(BSObjectType.SHOW, "2410", 20);
		assertNotNull(comments);
		assertEquals(20, comments.size());		
		assertEquals(982, comments.get(0).getId());
		assertEquals(3820, comments.get(0).getUserId());
		assertEquals("zeppelinlg", comments.get(0).getLogin());
		assertEquals("http://cdn.betaseries.com/betaseries/data/avatars/eb/ebb4dfc605c9be0056583989680c2b3c.jpg", comments.get(0).getAvatarUrl());
		assertEquals(dateFromString("2010-04-07 00:46:18", BS_DATE_AND_TIME_FORMAT), comments.get(0).getCreatedAt());
		assertEquals("Complétement accro aussi", comments.get(0).getText());
		assertEquals(1, comments.get(0).getInnerId());
		assertEquals(0, comments.get(0).getInReplyTo());
		assertEquals(0, comments.get(0).getNumberOfReplies());
	}
}
