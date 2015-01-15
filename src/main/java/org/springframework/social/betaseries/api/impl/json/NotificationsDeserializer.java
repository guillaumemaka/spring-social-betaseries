package org.springframework.social.betaseries.api.impl.json;

import java.io.IOException;
import java.util.List;

import org.springframework.social.betaseries.api.Notification;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotificationsDeserializer extends
		JsonDeserializer<List<Notification>> {

	@Override
	public List<Notification> deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		JsonNode rootNotificationsNode = jp.readValueAs(JsonNode.class).path(
				"notifications");

		ObjectMapper om = new ObjectMapper()
				.registerModule(new BetaSeriesModule());
		List<Notification> notifications = om.readValue(
				rootNotificationsNode.traverse(),
				om.getTypeFactory().constructCollectionType(List.class, Notification.class));

		return notifications;
	}

}
