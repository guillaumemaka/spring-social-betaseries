package org.springframework.social.betaseries.api.impl.json;

import java.io.IOException;

import org.springframework.social.betaseries.api.BSMemberOptionValue;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MemberOptionsFriendhipDeserializer extends JsonDeserializer<BSMemberOptionValue> {

	@Override
	public BSMemberOptionValue deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return BSMemberOptionValue.valueOf(jp.getText().toUpperCase());
	}

}
