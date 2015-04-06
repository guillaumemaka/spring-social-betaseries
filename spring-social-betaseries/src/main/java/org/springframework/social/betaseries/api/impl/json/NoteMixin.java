package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class NoteMixin extends BetaSeriesObjectMixin {
	@JsonProperty("total")
	double total;
	
	@JsonProperty("mean")
	double average;
	
	@JsonProperty("user")
	double userNote;	
}
