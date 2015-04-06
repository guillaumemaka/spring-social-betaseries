package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;

import org.springframework.social.betaseries.api.BSPictureType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class PictureMixin extends BetaSeriesObjectMixin {
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
