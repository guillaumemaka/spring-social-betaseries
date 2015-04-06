package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Member;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesMemberList extends AbstractBetaSeriesList<Member>{
	@JsonCreator
	public BetaSeriesMemberList(@JsonProperty("members") List<Member> list) {
		super(list);		
	}
}
