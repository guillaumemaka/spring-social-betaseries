package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class BSUserMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	BSUserMixin(
			@JsonProperty("id") Integer id, 
			@JsonProperty("login") String login, 
			@JsonProperty("in_account") boolean inAccount) {}
}
