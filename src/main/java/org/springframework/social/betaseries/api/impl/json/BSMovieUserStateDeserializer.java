package org.springframework.social.betaseries.api.impl.json;

import java.io.IOException;

import org.springframework.social.betaseries.api.BSMovieUserState;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BSMovieUserStateDeserializer extends JsonDeserializer<BSMovieUserState> {

	@Override
	public BSMovieUserState deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {		
		return BSMovieUserState.fromString(jp.getText());
	}

}
