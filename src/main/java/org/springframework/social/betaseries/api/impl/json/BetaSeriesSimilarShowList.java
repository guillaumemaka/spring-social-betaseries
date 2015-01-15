package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.SimilarShow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesSimilarShowList extends AbstractBetaSeriesList<SimilarShow> {
	@JsonCreator
	public BetaSeriesSimilarShowList(@JsonProperty("similars") List<SimilarShow> list) {
		super(list);
	}
	
}
