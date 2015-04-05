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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * The Class BSOptionsMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using=BSOptionsDeserializer.class)
abstract class BSOptionsMixin extends BetaSeriesObjectMixin {
//	/** The notation enabled. */
//	@JsonProperty("notation")
//	boolean notationEnabled;
//
//	/** The downloaded enabled. */
//	@JsonProperty("dpwnloaded")
//	boolean downloadedEnabled;
//
//	/** The global enabled. */
//	@JsonProperty("global")
//	boolean globalEnabled;
//
//	/** The timelag enabled. */
//	@JsonProperty("timelag")
//	boolean timelagEnabled;
//
//	/** The friendship enabled. */
//	@JsonProperty("friendship")
//	boolean friendshipEnabled;
//
//	@JsonProperty("options.sources")
//	List<SubtitleSource> sources;
}
