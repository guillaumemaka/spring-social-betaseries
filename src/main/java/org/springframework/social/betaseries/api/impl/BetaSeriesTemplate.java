/**
 * Copyright 2014 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.betaseries.api.impl;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.betaseries.api.BetaSeries;
import org.springframework.social.betaseries.api.CommentOperations;
import org.springframework.social.betaseries.api.EpisodeOperations;
import org.springframework.social.betaseries.api.FriendOperations;
import org.springframework.social.betaseries.api.MemberOperations;
import org.springframework.social.betaseries.api.MessageOperations;
import org.springframework.social.betaseries.api.MovieOperations;
import org.springframework.social.betaseries.api.PictureOperations;
import org.springframework.social.betaseries.api.PlanningOperations;
import org.springframework.social.betaseries.api.ShowOperations;
import org.springframework.social.betaseries.api.SubtitleOperations;
import org.springframework.social.betaseries.api.TimelineOperations;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesModule;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesTemplate.
 * 
 * @author Guillaume Maka
 */
public class BetaSeriesTemplate extends AbstractOAuth2ApiBinding implements
		BetaSeries {
	
	/** The comment operations. */
	private CommentOperations commentOperations;
	
	/** The episode operations. */
	private EpisodeOperations episodeOperations;
	
	/** The friend operations. */
	private FriendOperations friendOperations;
	
	/** The member operations. */
	private MemberOperations memberOperations;
	
	/** The message operations. */
	private MessageOperations messageOperations;
	
	/** The movie operations. */
	private MovieOperations movieOperations;
	
	/** The picture operations. */
	private PictureOperations pictureOperations;
	
	/** The planning operations. */
	private PlanningOperations planningOperations;
	
	/** The show operations. */
	private ShowOperations showOperations;
	
	/** The subtitle operations. */
	private SubtitleOperations subtitleOperations;
	
	/** The timeline operations. */
	private TimelineOperations timelineOperations;
		
	private String accessToken;
	
	private String apiKey;
	
	/**
	 * Instantiates a new beta series template.
	 * 
	 * @param accessToken
	 *            the access token
	 * @param apiKey
	 *            the api key
	 */
	public BetaSeriesTemplate(String accessToken, String apiKey) {		
		super(accessToken);		
		this.accessToken = accessToken;
		this.apiKey = apiKey;		
		initialize();
	}

	private void initialize() {
		getRestTemplate().getInterceptors().clear();
		getRestTemplate().getInterceptors().add(new BetaSeriesApiVersionHeaderParameterInterceptor("2.4"));
		getRestTemplate().getInterceptors().add(new BetaSeriesOAuth2TokenHeaderParameterInterceptor(accessToken));
		getRestTemplate().getInterceptors().add(new BetaSeriesApiKeyHeaderParameterInterceptor(apiKey));
		getRestTemplate().getInterceptors().add(new BetaSeriesAcceptHeaderParameterInterceptor());
		initSubApis();
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#commentOperations()
	 */
	public CommentOperations commentOperations() {		
		return commentOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#episodeOperations()
	 */
	public EpisodeOperations episodeOperations() {		
		return episodeOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#friendOperations()
	 */
	public FriendOperations friendOperations() {		
		return friendOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#memberOperations()
	 */
	public MemberOperations memberOperations() {
		return memberOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#messageOperations()
	 */
	public MessageOperations messageOperations() {
		return messageOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#movieOperations()
	 */
	public MovieOperations movieOperations() {
		return movieOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#pictureOperations()
	 */
	public PictureOperations pictureOperations() {
		return pictureOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#planningOperations()
	 */
	public PlanningOperations planningOperations() {
		return planningOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#showOperations()
	 */
	public ShowOperations showOperations() {
		return showOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#subtitleOperations()
	 */
	public SubtitleOperations subtitleOperations() {		
		return subtitleOperations;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.BetaSeries#timelineOperations()
	 */
	public TimelineOperations timelineOperations() {
		return timelineOperations;
	}
	
	/*
	 * Configuration
	 * 
	 */
	
	/* (non-Javadoc)
	 * @see org.springframework.social.oauth2.AbstractOAuth2ApiBinding#getJsonMessageConverter()
	 */
	@Override
	protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
		final ObjectMapper objectMapper = new ObjectMapper().registerModule(new BetaSeriesModule());									
		//Assert.assertNotNull(objectMapper.findMixInClassFor(Member.class));
		converter.setObjectMapper(objectMapper);		
		return converter;
	}
	
	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.oauth2.AbstractOAuth2ApiBinding#configureRestTemplate(org.springframework.web.client.RestTemplate)
	 */
	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {		
		restTemplate.setErrorHandler(new BetaSerieErrorHandler());			
	}
	
	@Override
	public boolean isAuthorized() {
		return (this.accessToken != null && this.apiKey != null);		
	}
	
	public boolean isAppAuthorized() {
		return this.apiKey != null;
	}
	
	public boolean isUserAuthorized() {
		return this.accessToken != null;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.oauth2.AbstractOAuth2ApiBinding#getOAuth2Version()
	 */
	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.DRAFT_8;
	}
	
	/*
	 *  Private methods
	 */
	
	/**
	 * Inits the sub apis.
	 */
	private void initSubApis() {
		this.commentOperations = new CommentTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.episodeOperations = new EpisodeTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.friendOperations = new FriendTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.memberOperations = new MemberTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.showOperations = new ShowTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.pictureOperations = new PictureTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.subtitleOperations = new SubtitleTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.planningOperations = new PlanningTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.messageOperations = new MessageTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.timelineOperations = new TimelineTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
		this.movieOperations = new MovieTemplate(getRestTemplate(), isUserAuthorized(), isAppAuthorized());
	}	
}
