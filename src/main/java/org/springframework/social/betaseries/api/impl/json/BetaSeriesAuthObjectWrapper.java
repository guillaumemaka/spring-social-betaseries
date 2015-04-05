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

import java.util.Map;

import org.springframework.social.betaseries.api.BSAuthObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesAuthObjectWrapper.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesAuthObjectWrapper {

	/** The user. */
	private final Map<String, Object> user;

	/** The token. */
	private final String token;

	/** The hash. */
	private final String hash;

	/**
	 * Instantiates a new beta series auth object wrapper.
	 *
	 * @param user
	 *            the user
	 * @param token
	 *            the token
	 * @param hash
	 *            the hash
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

	/**
	 * Gets the authenticated user.
	 *
	 * @return the authenticated user
	 */
	public BSAuthObject getAuthenticatedUser() {
		return new BSAuthObject(
				user.get("id").toString(), 
				user.get("login").toString(),
				Boolean.valueOf(user.get("in_account").toString()), 
				token, 
				hash);
	}
}
