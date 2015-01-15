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

public class TimelineTemplate extends AbstractBetaSeriesOperations implements
		TimelineOperations {
	private final RestTemplate restTemplate;

	/**
	 * @param isUserAuthorized
	 * @param isAppAuthorized
	 */
	public TimelineTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}

	public List<Event> getFriendsTimeline() {		
		return getFriendsTimeline(null);
	}

	public List<Event> getFriendsTimeline(Integer nbpp) {
		return getFriendsTimeline(nbpp, null);
	}

	public List<Event> getFriendsTimeline(Integer nbpp, Integer sinceId) {		
		return getFriendsTimeline(nbpp, sinceId, null);
	}

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

	public List<Event> getHomeTimeline() {		
		return getHomeTimeline(null);
	}

	public List<Event> getHomeTimeline(Integer nbpp) {		
		return getHomeTimeline(nbpp, null);
	}

	public List<Event> getHomeTimeline(Integer nbpp, Integer sinceId) {
		return getHomeTimeline(nbpp, sinceId, null);
	}

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

	public List<Event> getMemberTimeline(Integer memberId) {		
		return getMemberTimeline(memberId, null);
	}

	public List<Event> getMemberTimeline(Integer memberId, Integer nbpp) {		
		return getMemberTimeline(memberId, nbpp, null);
	}

	public List<Event> getMemberTimeline(Integer memberId, Integer nbpp,
			Integer sinceId) {		
		return getMemberTimeline(memberId, nbpp, sinceId, null);
	}

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
