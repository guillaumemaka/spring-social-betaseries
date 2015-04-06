package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Character;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesCharacterList extends AbstractBetaSeriesList<Character> {
	@JsonCreator
	public BetaSeriesCharacterList(@JsonProperty("characters") List<Character> list) {
		super(list);		
	}
}
