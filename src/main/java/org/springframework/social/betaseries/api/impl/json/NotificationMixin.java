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

import org.springframework.social.betaseries.api.BSNotificationType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class NotificationMixin extends BetaSeriesObjectMixin {

	/** The id. */
	@JsonProperty("id")
	Long id;

	/** The type. */
	@JsonProperty("type")
	@JsonDeserialize(using=BSNotificationTypeDeserializer.class)
	BSNotificationType type;

	/** The ref id. */
	@JsonProperty("ref_id")
	String refId;

	/** The text. */
	@JsonProperty("text")
	String text;

	/** The html. */
	@JsonProperty("html")
	String html;

	/** The date. */
	@JsonProperty("date")
	@JsonDeserialize(using = BSNotificationDateDeserializer.class)
	Date date;

	/** The seen. */
	@JsonProperty("seen")
	boolean seen;
}
