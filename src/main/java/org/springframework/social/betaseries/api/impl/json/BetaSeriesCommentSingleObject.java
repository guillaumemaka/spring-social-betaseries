package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Comment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesCommentSingleObject extends
		AbstractBetaSeriesSingleObject<Comment> {
	@JsonCreator
	public BetaSeriesCommentSingleObject(@JsonProperty("comment") Comment object) {
		super(object);		
	}

}
