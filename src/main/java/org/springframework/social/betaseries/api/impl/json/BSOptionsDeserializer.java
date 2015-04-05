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

// TODO: Auto-generated Javadoc
/**
 * The Class BSOptionsDeserializer.
 *
 * @author Guillaume Maka
 */
class BSOptionsDeserializer extends JsonDeserializer<BSOptions> {

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
	 */
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
