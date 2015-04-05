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

import org.springframework.social.betaseries.api.Subtitle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesSubtitleSingleObject.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesSubtitleSingleObject extends
		AbstractBetaSeriesSingleObject<Subtitle> {
	
	/**
	 * Instantiates a new beta series subtitle single object.
	 *
	 * @param object the object
	 */
	@JsonCreator
	public BetaSeriesSubtitleSingleObject(@JsonProperty("subtitle") Subtitle object) {
		super(object);
	}

}
