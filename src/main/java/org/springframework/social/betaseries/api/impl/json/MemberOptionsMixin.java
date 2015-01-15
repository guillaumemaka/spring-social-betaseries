package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.SubtitleSource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class MemberOptionsMixin extends BetaSeriesObjectMixin {
	@JsonProperty("downloaded") 
	boolean downloadedEnabled;
	
	@JsonProperty("notation") 
	boolean notationEnabled;
	
	@JsonProperty("global") 
	boolean globalEnabled;
	
	@JsonProperty("timelag") 
	boolean timelagEnabled;
	
	@JsonProperty("friendship")
	@JsonDeserialize(using=MemberOptionsFriendhipDeserializer.class)
	boolean friendshipStatus;
	
	@JsonProperty("sources")
	List<SubtitleSource> sources;
}
