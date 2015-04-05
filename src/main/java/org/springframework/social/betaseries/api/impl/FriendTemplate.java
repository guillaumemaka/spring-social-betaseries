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

import org.springframework.http.HttpMethod;
import org.springframework.social.betaseries.api.BSUser;
import org.springframework.social.betaseries.api.FriendOperations;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesBSUserList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesMemberSingleObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class FriendTemplate.
 *
 * @author Guillaume Maka
 */
public class FriendTemplate extends AbstractBetaSeriesOperations implements
		FriendOperations {
	
	/** The rest template. */
	private final RestTemplate restTemplate;
	
	/**
	 * Instantiates a new friend template.
	 *
	 * @param restTemplate the rest template
	 * @param isUserAuthorized the is user authorized
	 * @param isAppAuthorized the is app authorized
	 */
	public FriendTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;		
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#block(int)
	 */
	public Member block(int userId) {
		requireEitherUserOrAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(userId));		
		return restTemplate.postForObject(buildUri("friends/block"), params, BetaSeriesMemberSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#unblock(int)
	 */
	public Member unblock(int userId) {
		requireEitherUserOrAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(userId));		
		return restTemplate.exchange(buildUri("friends/block", params), HttpMethod.DELETE, null, BetaSeriesMemberSingleObject.class).getBody().getObject();		
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#addFriend(int)
	 */
	public Member addFriend(int userId) {
		requireEitherUserOrAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(userId));		
		return restTemplate.postForObject(buildUri("friends/friend"), params, BetaSeriesMemberSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#removeFriend(int)
	 */
	public Member removeFriend(int userId) {
		requireEitherUserOrAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(userId));		
		return restTemplate.exchange(buildUri("friends/friend", params), HttpMethod.DELETE, null, BetaSeriesMemberSingleObject.class).getBody().getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#getFriendsList()
	 */
	public List<BSUser> getFriendsList() {		
		return getFriendsList(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#getFriendsList(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#getBlockedFriendsList()
	 */
	public List<BSUser> getBlockedFriendsList() {		
		return getBlockedFriendsList(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#getBlockedFriendsList(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#getRequestedFriends()
	 */
	public List<BSUser> getRequestedFriends() {
		return getRequestedFriends(false);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.FriendOperations#getRequestedFriends(boolean)
	 */
	public List<BSUser> getRequestedFriends(boolean received) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
													
		params.set("received", received ? "1" : "0");											
				
		return restTemplate.getForObject(buildUri("friends/requests", params), BetaSeriesBSUserList.class).getList();	
	} 
}
