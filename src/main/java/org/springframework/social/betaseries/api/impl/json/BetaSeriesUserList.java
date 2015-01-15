package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.BSUser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesUserList extends AbstractBetaSeriesList<BSUser>{
	@JsonCreator
	public BetaSeriesUserList(@JsonProperty("users") List<BSUser> list) {
		super(list);		
	}

}
