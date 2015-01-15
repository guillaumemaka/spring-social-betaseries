package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Video;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BetaSeriesVideoList extends AbstractBetaSeriesList<Video> {
	@JsonCreator
	public BetaSeriesVideoList(@JsonProperty("videos") List<Video> list) {
		super(list);
	}
}
