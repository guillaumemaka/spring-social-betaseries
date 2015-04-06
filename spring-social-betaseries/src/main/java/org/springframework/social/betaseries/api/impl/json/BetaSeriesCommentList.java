package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Comment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesCommentList extends AbstractBetaSeriesList<Comment> {
	@JsonCreator
	public BetaSeriesCommentList(@JsonProperty("comments") List<Comment> list) {
		super(list);		
	}

}
