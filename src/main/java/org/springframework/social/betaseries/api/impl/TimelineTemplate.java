/**
 * Copyright 2015 [name of copyright owner]
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

import java.util.List;

import org.springframework.social.betaseries.api.BSTimelineEventType;
import org.springframework.social.betaseries.api.Event;
import org.springframework.social.betaseries.api.TimelineOperations;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesEventList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class TimelineTemplate.
 *
 * @author Guillaume Maka
 */
public class TimelineTemplate extends AbstractBetaSeriesOperations implements
		TimelineOperations {
	
	/** The rest template. */
	private final RestTemplate restTemplate;

	/**
	 * Instantiates a new timeline template.
	 *
	 * @param restTemplate the rest template
	 * @param isUserAuthorized the is user authorized
	 * @param isAppAuthorized the is app authorized
	 */
	public TimelineTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getFriendsTimeline()
	 */
	public List<Event> getFriendsTimeline() {		
		return getFriendsTimeline(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getFriendsTimeline(java.lang.Integer)
	 */
	public List<Event> getFriendsTimeline(Integer nbpp) {
		return getFriendsTimeline(nbpp, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getFriendsTimeline(java.lang.Integer, java.lang.Integer)
	 */
	public List<Event> getFriendsTimeline(Integer nbpp, Integer sinceId) {		
		return getFriendsTimeline(nbpp, sinceId, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getFriendsTimeline(java.lang.Integer, java.lang.Integer, org.springframework.social.betaseries.api.BSTimelineEventType[])
	 */
	public List<Event> getFriendsTimeline(Integer nbpp, Integer sinceId,
			BSTimelineEventType[] types) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		if (nbpp != null) {
			if (nbpp <= 100) {
				params.set("nbpp", nbpp.toString());
			}
		}
		
		if (sinceId != null) {			
			params.set("since_id", sinceId.toString());	
		}
		
		if(types != null) {
			if (types.length > 0) {
				params.set("types", StringUtils.arrayToCommaDelimitedString(types).toLowerCase());
			}
		}
		
		return restTemplate.getForObject(buildUri("timeline/friends", params), BetaSeriesEventList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getHomeTimeline()
	 */
	public List<Event> getHomeTimeline() {		
		return getHomeTimeline(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getHomeTimeline(java.lang.Integer)
	 */
	public List<Event> getHomeTimeline(Integer nbpp) {		
		return getHomeTimeline(nbpp, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getHomeTimeline(java.lang.Integer, java.lang.Integer)
	 */
	public List<Event> getHomeTimeline(Integer nbpp, Integer sinceId) {
		return getHomeTimeline(nbpp, sinceId, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getHomeTimeline(java.lang.Integer, java.lang.Integer, org.springframework.social.betaseries.api.BSTimelineEventType[])
	 */
	public List<Event> getHomeTimeline(Integer nbpp, Integer sinceId,
			BSTimelineEventType[] types) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		if (nbpp != null) {
			if (nbpp <= 100) {
				params.set("nbpp", nbpp.toString());
			}
		}
		
		if (sinceId != null) {			
			params.set("since_id", sinceId.toString());	
		}
		
		if(types != null) {
			if (types.length > 0) {
				params.set("types", StringUtils.arrayToCommaDelimitedString(types).toLowerCase());
			}
		}
		
		return restTemplate.getForObject(buildUri("timeline/home", params), BetaSeriesEventList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getMemberTimeline(java.lang.Integer)
	 */
	public List<Event> getMemberTimeline(Integer memberId) {		
		return getMemberTimeline(memberId, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getMemberTimeline(java.lang.Integer, java.lang.Integer)
	 */
	public List<Event> getMemberTimeline(Integer memberId, Integer nbpp) {		
		return getMemberTimeline(memberId, nbpp, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getMemberTimeline(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	public List<Event> getMemberTimeline(Integer memberId, Integer nbpp,
			Integer sinceId) {		
		return getMemberTimeline(memberId, nbpp, sinceId, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.TimelineOperations#getMemberTimeline(java.lang.Integer, java.lang.Integer, java.lang.Integer, org.springframework.social.betaseries.api.BSTimelineEventType[])
	 */
	public List<Event> getMemberTimeline(Integer memberId, Integer nbpp,
			Integer sinceId, BSTimelineEventType[] types) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("id", memberId.toString());
		
		if (nbpp != null) {
			if (nbpp <= 100) {
				params.set("nbpp", nbpp.toString());
			}
		}
		
		if (sinceId != null) {			
			params.set("since_id", sinceId.toString());	
		}
		
		if(types != null) {
			if (types.length > 0) {
				params.set("types", StringUtils.arrayToCommaDelimitedString(types).toLowerCase());
			}
		}
		
		return restTemplate.getForObject(buildUri("timeline/member", params), BetaSeriesEventList.class).getList();		
	}	
}
