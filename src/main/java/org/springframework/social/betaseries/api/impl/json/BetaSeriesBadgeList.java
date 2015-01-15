package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Badge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesBadgeList extends AbstractBetaSeriesList<Badge> {
	@JsonCreator
	public BetaSeriesBadgeList(@JsonProperty("badges") List<Badge> list) {
		super(list);
	}

}
