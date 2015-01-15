package org.springframework.social.betaseries.api.impl.json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="badges")
abstract class BadgeMixin extends BetaSeriesObjectMixin {
	@JsonCreator
	public BadgeMixin(
			@JsonProperty("id") Long id, 
			@JsonProperty("code") String code, 
			@JsonProperty("name") String name, 
			@JsonProperty("description") String description,
			@JsonProperty("date") @JsonDeserialize(using=BSDateAndTimeDeserializer.class) Date date) {}
}
