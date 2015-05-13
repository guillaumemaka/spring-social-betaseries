package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class FriendMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	public FriendMixin(
			@JsonProperty("id") String id,
			@JsonProperty("login") String login,
			@JsonProperty("in_account") String inAccount
			) {}
}
