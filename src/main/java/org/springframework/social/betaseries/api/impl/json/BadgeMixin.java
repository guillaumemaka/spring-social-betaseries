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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// TODO: Auto-generated Javadoc
/**
 * The Class BadgeMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="badges")
abstract class BadgeMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new badge mixin.
	 *
	 * @param id the id
	 * @param code the code
	 * @param name the name
	 * @param description the description
	 * @param date the date
	 */
	@JsonCreator
	public BadgeMixin(
			@JsonProperty("id") Long id, 
			@JsonProperty("code") String code, 
			@JsonProperty("name") String name, 
			@JsonProperty("description") String description,
			@JsonProperty("date") @JsonDeserialize(using=BSDateAndTimeDeserializer.class) Date date) {}
}
