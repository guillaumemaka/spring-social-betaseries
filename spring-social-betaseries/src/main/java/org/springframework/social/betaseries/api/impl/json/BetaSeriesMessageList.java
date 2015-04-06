package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesMessageList extends AbstractBetaSeriesList<Message> {
	@JsonCreator
	public BetaSeriesMessageList(@JsonProperty("messages") List<Message> list) {
		super(list);		
	}
}
