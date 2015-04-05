/**
 * Copyright 2015 [name of copyright owner]
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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

// TODO: Auto-generated Javadoc
/**
 * The Class FriendMixin.
 *
 * @author Guillaume Maka
 */
@JsonRootName(value="users")
@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class FriendMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new friend mixin.
	 *
	 * @param id the id
	 * @param login the login
	 * @param inAccount the in account
	 */
	@JsonCreator
	public FriendMixin(
			@JsonProperty("id") String id,
			@JsonProperty("login") String login,
			@JsonProperty("in_account") String inAccount
			) {}
}
