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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.betaseries.api.MemberOptions;
import org.springframework.social.betaseries.api.MemberStats;
import org.springframework.social.betaseries.api.Movie;
import org.springframework.social.betaseries.api.Show;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberDeserializer.
 *
 * @author Guillaume Maka
 */
public class MemberDeserializer extends JsonDeserializer<Member> {
	
	/** The Constant TAG. */
	private static final String TAG = JsonDeserializer.class.getName();
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(MemberDeserializer.class);
	
	/** The om. */
	private ObjectMapper om; 
	
	/**
	 * Instantiates a new member deserializer.
	 */
	public MemberDeserializer() {
		
	}
	
	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	public Member deserialize(JsonParser jp, DeserializationContext ctx)
			throws IOException, JsonProcessingException {

		final JsonNode node = jp.readValueAs(JsonNode.class);
		if (null == node || node.isMissingNode() || node.isNull()) {
			debug(TAG, "node is null");
			return null;
		}
		
		initializeObjectMapper();
						
		Member member = deserialize(node);

		return member;
	}

	/**
	 * Deserialize.
	 *
	 * @param node
	 *            the node
	 * @return the member
	 */
	private Member deserialize(JsonNode node) {

		final JsonNode rootNode;

		if (node.has("member")) {
			rootNode = node.path("member");
		}else {
			rootNode = node;
		}

		final Member member = new Member();		

		member.setMemberId(rootNode.path("id").asText());
		member.setLogin(rootNode.path("login").asText());
		member.setXp(rootNode.path("xp").asInt());
		member.setAvatarUrl(rootNode.path("avatar").asText());
		member.setCached(rootNode.path("cached").asInt());
		member.setInAccount(rootNode.path("in_account").asBoolean());

		member.setStats(deserializeMemberStats(rootNode.path("stats")));

		JsonNode showsNode = rootNode.path("shows");
		List<Show> showList = new ArrayList<Show>();

		if (showsNode.isArray()) {
			Iterator<JsonNode> shows = showsNode.iterator();

			while (shows.hasNext()) {
				showList.add(deserializeShow(shows.next()));
			}
		}
		
		member.setShows(showList);

		JsonNode moviesNode = rootNode.path("movies");
		List<Movie> movieList = new ArrayList<Movie>();

		if (moviesNode.isArray()) {
			Iterator<JsonNode> movies = moviesNode.iterator();

			while (movies.hasNext()) {
				movieList.add(deserializeMovie(movies.next()));
			}
		}
		
		member.setMovies(movieList);
		
		member.setOptions(deserializeMemberOptions(rootNode.path("options")));
		
		return member;
	}

	/**
	 * Deserialize member stats.
	 *
	 * @param node
	 *            the node
	 * @return the member stats
	 */
	private MemberStats deserializeMemberStats(JsonNode node) {
//		MemberStats stats = new MemberStats(
//				node.path("friends").asInt(), 
//				node.path("shows").asInt(), 
//				node.path("seasons").asInt(), 
//				node.path("episodes").asInt(), 
//				node.path("comments").asInt(), 
//				node.path("progress").asDouble(), 
//				node.path("episodes_to_watch").asInt(), 
//				node.path("time_on_tv").asInt(), 
//				node.path("time_to_spend").asInt(), 
//				node.path("badges").asInt());
		MemberStats stats = null;
		
		try {
			stats = om.readValue(node.traverse(), MemberStats.class);
		} catch (JsonParseException e) {
			debug(TAG, e);
		} catch (JsonMappingException e) {
			debug(TAG, e);
		} catch (IOException e) {
			debug(TAG, e);
		}
		
		return stats;
	}

	/**
	 * Deserialize member options.
	 *
	 * @param node
	 *            the node
	 * @return the member options
	 */
	private MemberOptions deserializeMemberOptions(JsonNode node) {
		logger.debug(node.toString());
		MemberOptions options = null;
		try {
			options = om.readValue(node.traverse(), MemberOptions.class);
		} catch (JsonParseException e) {
			debug(TAG, e);
		} catch (JsonMappingException e) {
			debug(TAG, e);
		} catch (IOException e) {
			debug(TAG, e);
		}
		return options;
	}

	/**
	 * Deserialize show.
	 *
	 * @param node
	 *            the node
	 * @return the show
	 */
	private Show deserializeShow(JsonNode node) {
		Show show = null;
		
		try {
			show = om.readValue(node.traverse(), Show.class);
		} catch (JsonParseException e) {
			debug(TAG, e);
		} catch (JsonMappingException e) {
			debug(TAG, e);
		} catch (IOException e) {
			debug(TAG, e);
		}
		
		return show;
	}

	/**
	 * Deserialize movie.
	 *
	 * @param node
	 *            the node
	 * @return the movie
	 */
	private Movie deserializeMovie(JsonNode node) {
		Movie movie = null;
		
		try {
			movie = om.readValue(node.traverse(), Movie.class);
		} catch (JsonParseException e) {
			debug(TAG, e.getMessage());
		} catch (JsonMappingException e) {
			debug(TAG, e);
		} catch (IOException e) {
			debug(TAG, e);
		}
		
		return movie;
	}
	
	/**
	 * Initialize object mapper.
	 */
	private void initializeObjectMapper() {
		om = new ObjectMapper();
		om.registerModule(new BetaSeriesModule());
	}
	
	/**
	 * Debug.
	 *
	 * @param tag
	 *            the tag
	 * @param exception
	 *            the exception
	 */
	private void debug(String tag, Object exception) {		
		if(logger.isDebugEnabled()) logger.debug(TAG, exception);		
	}
}
