package org.springframework.social.betaseries.api.impl.json;

import java.util.Map;

import org.springframework.social.betaseries.api.BSAuthObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesAuthObjectWrapper {

	private final Map<String, Object> user;

	private final String token;

	private final String hash;

	/**
	 * @param user
	 * @param token
	 * @param hash
	 */
	@JsonCreator
	public BetaSeriesAuthObjectWrapper(
			@JsonProperty("user") Map<String, Object> user,
			@JsonProperty("token") String token,
			@JsonProperty("hash") String hash) {
		super();
		this.user = user;
		this.token = token;
		this.hash = hash;
	}

	public BSAuthObject getAuthenticatedUser() {
		return new BSAuthObject(
				user.get("id").toString(), 
				user.get("login").toString(),
				Boolean.valueOf(user.get("in_account").toString()), 
				token, 
				hash);
	}
}
