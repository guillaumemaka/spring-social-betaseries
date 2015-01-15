package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

import org.springframework.social.betaseries.api.Picture;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BetaSeriesPictureList extends AbstractBetaSeriesList<Picture> {
	@JsonCreator	
	public BetaSeriesPictureList(@JsonProperty("pictures") List<Picture> list) {
		super(list);		
	}

}
