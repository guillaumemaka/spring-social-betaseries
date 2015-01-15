package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Subtitle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesSubtitleSingleObject extends
		AbstractBetaSeriesSingleObject<Subtitle> {
	@JsonCreator
	public BetaSeriesSubtitleSingleObject(@JsonProperty("subtitle") Subtitle object) {
		super(object);
	}

}
