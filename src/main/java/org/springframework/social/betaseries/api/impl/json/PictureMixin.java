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

import java.util.Date;

import org.springframework.social.betaseries.api.BSPictureType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// TODO: Auto-generated Javadoc
/**
 * The Class PictureMixin.
 *
 * @author Guillaume Maka
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class PictureMixin extends BetaSeriesObjectMixin {
	
	/**
	 * Instantiates a new picture mixin.
	 *
	 * @param id
	 *            the id
	 * @param showId
	 *            the show id
	 * @param loginId
	 *            the login id
	 * @param url
	 *            the url
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 * @param date
	 *            the date
	 * @param type
	 *            the type
	 */
	@JsonCreator
	public PictureMixin(
			@JsonProperty("id") int id, 
			@JsonProperty("show_id") int showId, 
			@JsonProperty("login_id") int loginId, 
			@JsonProperty("url") String url, 
			@JsonProperty("width") int width,
			@JsonProperty("height") int height, 
			@JsonProperty("date") @JsonDeserialize(using=BSDateAndTimeDeserializer.class) Date date, 
			@JsonProperty("picked") @JsonDeserialize(using=BSPictureTypeDeserializer.class) BSPictureType type) {}
}
