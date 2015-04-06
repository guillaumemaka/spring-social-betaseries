package org.springframework.social.betaseries.api.impl.json;

import java.io.IOException;

import org.springframework.social.betaseries.api.BSTimelineEventType;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BSTimelineEventTypeDeserializer extends
		JsonDeserializer<BSTimelineEventType> {

	@Override
	public BSTimelineEventType deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		
		return BSTimelineEventType.valueOf(jp.getText().toUpperCase());
	}

}
