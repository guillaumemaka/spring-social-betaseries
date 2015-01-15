package org.springframework.social.betaseries.api.impl.json;

import java.io.IOException;
import java.util.List;

import org.springframework.social.betaseries.api.BSOptions;
import org.springframework.social.betaseries.api.SubtitleSource;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class BSOptionsDeserializer extends JsonDeserializer<BSOptions> {

	@Override
	public BSOptions deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode rootNode = jp.readValueAs(JsonNode.class);

		if (null == rootNode || rootNode.isMissingNode() || rootNode.isNull()) {
			return null;
		}
		
		JsonNode optionsNode = rootNode.path("options");
		
		BSOptions options = new BSOptions();
		options.setNotationEnabled(optionsNode.path("notation").asBoolean());
		options.setDownloadedEnabled(optionsNode.path("downloaded").asBoolean());
		options.setGlobalEnabled(optionsNode.path("global").asBoolean());
		options.setTimelagEnabled(optionsNode.path("timelag").asBoolean());

		ObjectMapper mapper = new ObjectMapper();
		List<SubtitleSource> sources = mapper.readValue(
				optionsNode.path("sources").traverse(),
				mapper.getTypeFactory().constructCollectionType(List.class,
						SubtitleSource.class));
		options.setSources(sources);
		
		return options;
	}

}
