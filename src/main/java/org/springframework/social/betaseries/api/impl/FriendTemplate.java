package org.springframework.social.betaseries.api.impl;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.social.betaseries.api.BSUser;
import org.springframework.social.betaseries.api.FriendOperations;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesBSUserList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesMemberSingleObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class FriendTemplate extends AbstractBetaSeriesOperations implements
		FriendOperations {
	private final RestTemplate restTemplate;
	
	public FriendTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;		
	}

	public Member block(int userId) {
		requireEitherUserOrAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(userId));		
		return restTemplate.postForObject(buildUri("friends/block"), params, BetaSeriesMemberSingleObject.class).getObject();
	}

	public Member unblock(int userId) {
		requireEitherUserOrAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(userId));		
		return restTemplate.exchange(buildUri("friends/block", params), HttpMethod.DELETE, null, BetaSeriesMemberSingleObject.class).getBody().getObject();		
	}

	public Member addFriend(int userId) {
		requireEitherUserOrAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(userId));		
		return restTemplate.postForObject(buildUri("friends/friend"), params, BetaSeriesMemberSingleObject.class).getObject();
	}

	public Member removeFriend(int userId) {
		requireEitherUserOrAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(userId));		
		return restTemplate.exchange(buildUri("friends/friend", params), HttpMethod.DELETE, null, BetaSeriesMemberSingleObject.class).getBody().getObject();
	}

	public List<BSUser> getFriendsList() {		
		return getFriendsList(null);
	}

	public List<BSUser> getFriendsList(String userId) {
		requireEitherUserOrAppAuthorization();
						
		if (userId != null ) {
			if(!userId.isEmpty()) {
				MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();				
				params.set("id", userId);
				
				return restTemplate.getForObject(buildUri("friends/list", params), BetaSeriesBSUserList.class).getList();
			}
		}
		
		return restTemplate.getForObject(buildUri("friends/list"), BetaSeriesBSUserList.class).getList();
	}

	public List<BSUser> getBlockedFriendsList() {		
		return getBlockedFriendsList(null);
	}

	public List<BSUser> getBlockedFriendsList(String userId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("blocked","1");
		
		if (userId != null ) {
			if(!userId.isEmpty()) {								
				params.set("id", userId);								
			}
		}
		
		return restTemplate.getForObject(buildUri("friends/list", params), BetaSeriesBSUserList.class).getList();		
	}

	public List<BSUser> getRequestedFriends() {
		return getRequestedFriends(false);
	}

	public List<BSUser> getRequestedFriends(boolean received) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
													
		params.set("received", received ? "1" : "0");											
				
		return restTemplate.getForObject(buildUri("friends/requests", params), BetaSeriesBSUserList.class).getList();	
	} 
}
