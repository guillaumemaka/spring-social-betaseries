package org.springframework.social.betaseries.api.impl.json;

import java.io.IOException;

import org.springframework.social.betaseries.api.BSNotificationType;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BSNotificationTypeDeserializer extends JsonDeserializer<BSNotificationType> {

	@Override
	public BSNotificationType deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {		
		return BSNotificationType.valueOf(jp.getText().toUpperCase());
	}

}
