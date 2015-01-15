package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Friend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesFriendList extends AbstractBetaSeriesList<Friend> {
	@JsonCreator
	public BetaSeriesFriendList(@JsonProperty("friends") List<Friend> list) {
		super(list);		
	}

}
