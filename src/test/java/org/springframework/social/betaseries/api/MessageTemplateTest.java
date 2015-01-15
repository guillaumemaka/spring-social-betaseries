package org.springframework.social.betaseries.api;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

public class MessageTemplateTest extends AbstractBetaSeriesApiTest {
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
	
	@Test
	public void getMemberInbox() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/messages/inbox")
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().getMemberInbox();
	}
	
	@Test
	public void getMemberInboxPage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/messages/inbox?page=2")
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().getMemberInbox(2);
	}
	
	@Test
	public void postMessage() throws Exception {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/messages/message")
		.andExpect(content().string(bodyFormEncode("to=2222&text=Hello&title=Welcome")))
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().sendMessageTo(2222, "Hello", "Welcome", null);
	}
	
	@Test
	public void postMessageWirhDiscussionId() throws Exception {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/messages/message")
		.andExpect(content().string(bodyFormEncode("text=Hello&title=Welcome&id=3333")))
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().sendMessageTo(2222, "Hello", "Welcome", 3333);
	}
	
	@Test
	public void deleteMessage() throws Exception {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/messages/message?id=2222")
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().deleteMessage(2222);
	}
	
	@Test
	public void markMessageAsRead() throws Exception {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/messages/read")
		.andExpect(content().string("id=2222"))
		.andRespond(withSuccess().body(jsonResource("messages-messages")).contentType(MediaType.APPLICATION_JSON));
		betaSeries.messageOperations().markMessageAsRead(2222);
	}
}
