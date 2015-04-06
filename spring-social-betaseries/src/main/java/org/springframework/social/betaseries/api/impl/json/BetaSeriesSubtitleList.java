package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Subtitle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesSubtitleList extends AbstractBetaSeriesList<Subtitle> {
	@JsonCreator
	public BetaSeriesSubtitleList(@JsonProperty("subtitles") List<Subtitle> list) {
		super(list);
	}
}
