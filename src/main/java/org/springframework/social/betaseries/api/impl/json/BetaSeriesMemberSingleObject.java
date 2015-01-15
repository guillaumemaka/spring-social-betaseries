package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.Member;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesMemberSingleObject extends
		AbstractBetaSeriesSingleObject<Member> {
	@JsonCreator
	public BetaSeriesMemberSingleObject(@JsonProperty("member") Member object) {
		super(object);		
	}
}
