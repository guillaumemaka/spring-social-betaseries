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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.social.betaseries.api.Episode;
import org.springframework.social.betaseries.api.Note;
import org.springframework.social.betaseries.api.Subtitle;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class EpisodeDeserializer.
 *
 * @author Guillaume Maka
 */
class EpisodeDeserializer extends JsonDeserializer<Episode> {

	/** The mapper. */
	private ObjectMapper mapper;

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	public Episode deserialize(JsonParser jp, DeserializationContext ctx)
			throws IOException, JsonProcessingException {
		final JsonNode node = jp.readValueAs(JsonNode.class);
		if (null == node || node.isMissingNode() || node.isNull()) {
			return null;
		}
		mapper = new ObjectMapper().registerModule(new BetaSeriesModule());
				
		final Episode episode = this.deserialize(node);
		return episode;
	}

	/**
	 * Deserialize.
	 *
	 * @param node
	 *            the node
	 * @return the episode
	 */
	private Episode deserialize(JsonNode node) {
		final JsonNode rootNode = node;
		
		int id = rootNode.path("id").asInt();
		int theTvDbId = rootNode.path("thetvdb_id").asInt();
		String title = rootNode.path("title").asText();
		int seasonNumber = rootNode.path("season").asInt();
		int episodeNumber = rootNode.path("episode").asInt();
		
		JsonNode showNode = rootNode.path("show");
		int showId = showNode.path("id").asInt();
		int show_theTvDbId = showNode.path("thetvdb_id").asInt();
		String showTitle = showNode.path("title").asText();
		
		String code = rootNode.path("code").asText();
		int global = rootNode.path("global").asInt();
		String description = rootNode.path("description").asText();
		Date airDate;
		
		try {
			airDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(rootNode.path("date").asText());
		} catch (ParseException e) {
			airDate = null;
		}
		
		JsonNode noteNode = rootNode.path("notes");
		double noteTotal = noteNode.path("total").asDouble();
		double noteMean = noteNode.path("mean").asDouble();
		double noteUser = noteNode.path("user").asDouble();
		
		JsonNode userNode = rootNode.path("user");
		boolean isSeen = userNode.path("seen").asBoolean();
		boolean isDownloaded = userNode.path("downloaded").asBoolean();
		
		Episode episode = new Episode(id, theTvDbId, title);
		episode.setSeasonNumber(seasonNumber);
		episode.setEpisodeNumber(episodeNumber);
		episode.setShowId(showId);
		episode.setShowTvDbId(show_theTvDbId);
		episode.setShowTitle(showTitle);
		episode.setCode(code);
		episode.setGlobal(global);
		episode.setDescription(description);
		episode.setAirDate(airDate);
		
		Note note = new Note(noteTotal, noteMean, noteUser);
		episode.setNote(note);
		
		episode.setSeen(isSeen);
		episode.setDownloaded(isDownloaded);		
		episode.setNumberOfComment(rootNode.path("comments").asInt());
		
		List<Subtitle> subtitles = new ArrayList<Subtitle>();		
		JavaType subtitleListType = getObjectMapper().getTypeFactory().constructCollectionType(List.class, Subtitle.class);
		try {
			subtitles = getObjectMapper().readValue(rootNode.path("subtitles").traverse(), subtitleListType);			
		} catch (JsonParseException e) {
			
		} catch (JsonMappingException e) {
			
		} catch (IOException e) {
			
		}
		
		episode.setSubtitles(subtitles);
		
		return episode;
	}
	
	/**
	 * Gets the object mapper.
	 *
	 * @return the object mapper
	 */
	private ObjectMapper getObjectMapper() {
		return mapper;
	}
}
