/**
 * Copyright 2014 the original author or authors
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

import java.util.List;

import org.springframework.social.betaseries.api.MemberOptions;
import org.springframework.social.betaseries.api.MemberStats;
import org.springframework.social.betaseries.api.Movie;
import org.springframework.social.betaseries.api.Show;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberMixin.
 * 
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown = true)
// @JsonDeserialize(using = MemberDeserializer.class)
abstract class MemberMixin extends BetaSeriesObjectMixin {
	/** The id. */
	@JsonProperty("id")
	String memberId;

	/** The login. */
	@JsonProperty("login")
	String login;

	/** The xp. */
	@JsonProperty("xp")
	int xp;

	/** The avatar url. */
	@JsonProperty("avatar")
	String avatarUrl;

	@JsonProperty("cached")
	int cached;

	/** The in account. */
	@JsonProperty("in_account")
	boolean inAccount;

	/** The stats. */
	@JsonProperty("stats")
	MemberStats stats;

	/** The shows. */
	@JsonProperty("shows")
	List<Show> shows;

	@JsonProperty("movies")
	List<Movie> movies;

	@JsonProperty("options")
	MemberOptions options;
}
