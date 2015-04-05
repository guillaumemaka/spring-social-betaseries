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
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageTemplateTest.
 *
 * @author Guillaume Maka
 */
public class MessageTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Gets the discussion.
	 *
	 * @return the discussion
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getDiscussion() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/messages/discussion?id=62541")
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		
		List<Message> messages = betaSeries.messageOperations().getDiscussion(62541);
		assertNotNull(messages);
		assertEquals(3, messages.size());
		assertEquals(62541, messages.get(0).getId());
		assertEquals(62541, messages.get(0).getMessageId());
		assertEquals(1, messages.get(0).getInnerId());
		assertEquals(new Integer(130446), messages.get(0).getSender().getId());
		assertEquals("blackstones", messages.get(0).getSender().getLogin());
		assertEquals(new Integer(26978), messages.get(0).getRecipient().getId());
		assertEquals("Dev040", messages.get(0).getRecipient().getLogin());
		assertEquals(dateFromString("2014-12-15 11:02:27", BS_DATE_AND_TIME_FORMAT), messages.get(0).getDate());
		assertEquals("Welcome", messages.get(0).getTitle());
		assertEquals("Hello", messages.get(0).getText());
		assertFalse(messages.get(0).isUnread());
		assertFalse(messages.get(0).hasUnread());
	}
	
	/**
	 * Gets the member inbox.
	 *
	 * @return the member inbox
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getMemberInbox() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/messages/inbox")
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().getMemberInbox();
	}
	
	/**
	 * Gets the member inbox page.
	 *
	 * @return the member inbox page
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getMemberInboxPage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/messages/inbox?page=2")
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().getMemberInbox(2);
	}
	
	/**
	 * Post message.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void postMessage() throws Exception {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/messages/message")
		.andExpect(content().string(bodyFormEncode("to=2222&text=Hello&title=Welcome")))
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().sendMessageTo(2222, "Hello", "Welcome", null);
	}
	
	/**
	 * Post message wirh discussion id.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void postMessageWirhDiscussionId() throws Exception {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/messages/message")
		.andExpect(content().string(bodyFormEncode("text=Hello&title=Welcome&id=3333")))
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().sendMessageTo(2222, "Hello", "Welcome", 3333);
	}
	
	/**
	 * Delete message.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void deleteMessage() throws Exception {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/messages/message?id=2222")
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().deleteMessage(2222);
	}
	
	/**
	 * Mark message as read.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void markMessageAsRead() throws Exception {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/messages/read")
		.andExpect(content().string("id=2222"))
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().markMessageAsRead(2222);
	}
}
