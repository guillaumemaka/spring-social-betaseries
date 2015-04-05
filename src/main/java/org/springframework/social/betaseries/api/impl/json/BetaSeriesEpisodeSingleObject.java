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

import org.springframework.social.betaseries.api.Episode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesEpisodeSingleObject.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesEpisodeSingleObject extends AbstractBetaSeriesSingleObject<Episode> {	
	
	/**
	 * Instantiates a new beta series episode single object.
	 *
	 * @param object
	 *            the object
	 */
	@JsonCreator
	public BetaSeriesEpisodeSingleObject(@JsonProperty("episode") Episode object) {
		super(object);
	}
}
