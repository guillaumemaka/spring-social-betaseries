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

public class MemberDeserializer extends JsonDeserializer<Member> {
	private static final String TAG = JsonDeserializer.class.getName();
	private final Logger logger = LoggerFactory.getLogger(MemberDeserializer.class);
	private ObjectMapper om; 
	
	public MemberDeserializer() {
		
	}
	
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
	
	private void initializeObjectMapper() {
		om = new ObjectMapper();
		om.registerModule(new BetaSeriesModule());
	}
	
	private void debug(String tag, Object exception) {		
		if(logger.isDebugEnabled()) logger.debug(TAG, exception);		
	}
}
