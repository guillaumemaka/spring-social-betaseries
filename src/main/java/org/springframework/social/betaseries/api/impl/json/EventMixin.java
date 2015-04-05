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

import java.util.Date;

import org.springframework.social.betaseries.api.BSTimelineEventType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// TODO: Auto-generated Javadoc
/**
 * The Class EventMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class EventMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new event mixin.
	 *
	 * @param id the id
	 * @param type the type
	 * @param ref the ref
	 * @param refId the ref id
	 * @param user the user
	 * @param userId the user id
	 * @param html the html
	 * @param date the date
	 */
	@JsonCreator
	public EventMixin(
			@JsonProperty("id") Integer id, 
			@JsonProperty("type") @JsonDeserialize(using=BSTimelineEventTypeDeserializer.class) BSTimelineEventType type, 
			@JsonProperty("ref") String ref,
			@JsonProperty("ref_id") Integer refId, 
			@JsonProperty("user") String user, 
			@JsonProperty("user_id") Integer userId, 
			@JsonProperty("html") String html, 
			@JsonProperty("date") @JsonDeserialize(using=BSDateAndTimeDeserializer.class) Date date) {}
}
