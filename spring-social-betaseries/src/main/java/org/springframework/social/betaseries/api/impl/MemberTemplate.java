package org.springframework.social.betaseries.api.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.betaseries.api.BSAuthObject;
import org.springframework.social.betaseries.api.BSMemberOptionName;
import org.springframework.social.betaseries.api.BSMemberOptionValue;
import org.springframework.social.betaseries.api.BSNotificationType;
import org.springframework.social.betaseries.api.BSObjectType;
import org.springframework.social.betaseries.api.BSOptions;
import org.springframework.social.betaseries.api.BSSortOrder;
import org.springframework.social.betaseries.api.BSUser;
import org.springframework.social.betaseries.api.Badge;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.betaseries.api.MemberOperations;
import org.springframework.social.betaseries.api.Notification;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesAuthObjectWrapper;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesAvailableUsernamesObject;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesBadgeList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesMemberSingleObject;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesNotificationList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesOptionsSingleObject;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesUserList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class MemberTemplate extends AbstractBetaSeriesOperations implements
		MemberOperations {
	
	private final RestTemplate restTemplate;

	public MemberTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}

	public Member getMemberInfos() {					
		return getMemberInfos(null);
	}
	
	public Member getMemberInfos(String memberId) {		
		return getMemberInfos(memberId, false);
	}

	public Member getMemberInfos(String memberId, boolean summary) {		
		return getMemberInfos(memberId, summary, null);
	}

	public Member getMemberInfos(String memberId, boolean summary,
			BSObjectType showOnly) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if (memberId != null) {
			if(!memberId.isEmpty()) {
				params.set("id", memberId);
			}
		}
		
		if (showOnly != null) {
			switch (showOnly) {
			case SHOW:
				params.set("only", "shows");
				break;
			case MOVIE:
				params.set("only", "movies");
				break;
			default:
				break;
			}
		}
		
		if(summary != false) {
			params.set("summary", String.valueOf(summary ? 1 : 0));
		}
		
		return restTemplate.getForObject(buildUri("members/infos", params), BetaSeriesMemberSingleObject.class).getObject();
	} 

	public boolean isActive() {
		requireEitherUserOrAppAuthorization();
		try {
		restTemplate.getForObject(buildUri("members/is_active"), String.class);
		return true;
		} catch (MissingAuthorizationException e) {
			return false;
		}
	}

	public List<Badge> getBadges(String userId) {
		requireEitherUserOrAppAuthorization();
				
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("id", userId);
		
		return restTemplate.getForObject(buildUri("members/badges", params), BetaSeriesBadgeList.class).getList();
	}

	public List<Notification> getNotifications() {		
		return getNotifications(null);
	}

	public List<Notification> getNotifications(String sinceId) {		
		return getNotifications(sinceId, null);
	}

	public List<Notification> getNotifications(String sinceId, String limit) {		
		return getNotifications(sinceId, limit, null);
	}

	public List<Notification> getNotifications(String sinceId, String limit,
			BSSortOrder order) {
		return getNotifications(sinceId, limit, order, null);
	}

	public List<Notification> getNotifications(String sinceId, String limit,
			BSSortOrder order, BSNotificationType[] notificationTypes) {
		return getNotifications(sinceId, limit, order, notificationTypes, false);
	}

	public List<Notification> getNotifications(String sinceId, String limit,
			BSSortOrder order, BSNotificationType[] notificationTypes,
			boolean autoDelete) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if(sinceId != null) {
			if(!sinceId.isEmpty()) {
				params.set("since_id", sinceId);
			}
		}
		
		if(limit != null) {
			if(!limit.isEmpty()) {
				params.set("number", limit);
			}
		}
		
		if(order != null) {			
			params.set("sort", order.toString().toLowerCase());		
		}
		
		if(notificationTypes != null) {
			if(notificationTypes.length > 0) {
				params.set("types", StringUtils.arrayToCommaDelimitedString(notificationTypes));
			}				
		}
		
		if (autoDelete != false) {
			params.set("auto_delete", String.valueOf(autoDelete));
		}
		
		if(params.size() > 0) {
			return restTemplate.getForObject(buildUri("members/notifications", params), BetaSeriesNotificationList.class).getList();
		}
		
		return restTemplate.getForObject(buildUri("members/notifications"), BetaSeriesNotificationList.class).getList();
	}

	public BSOptions getMemberOptions() {		
		requireEitherUserOrAppAuthorization();			
		return restTemplate.getForObject(buildUri("members/options"), BetaSeriesOptionsSingleObject.class).getObject();
	}

	public List<BSUser> search(String login) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("login", login);
		
		return restTemplate.getForObject(buildUri("members/search", params), BetaSeriesUserList.class).getList();
	}

	public String[] getAvailableUsernames(String username) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("username", username);
		
		return restTemplate.getForObject(buildUri("members/username", params),  BetaSeriesAvailableUsernamesObject.class).getObject();
	}
	
	public Member uploadAvatar(Resource avatar) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();		
		data.set("avatar", avatar);
		
		return restTemplate.postForObject(buildUri("members/avatar"),data, BetaSeriesMemberSingleObject.class).getObject();
	}

	public Member deleteAvatar() {
		requireEitherUserOrAppAuthorization();
		return restTemplate.exchange(buildUri("members/avatar"), HttpMethod.DELETE, null, BetaSeriesMemberSingleObject.class).getBody().getObject();
	}

	public void logOut() {
		requireEitherUserOrAppAuthorization();
		restTemplate.delete(buildUri("members/destroy"));
	}

	public void resetPassword(String emailOrUsername) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("find", emailOrUsername);
		
		restTemplate.postForObject(buildUri("members/lost"), params, String.class);
	}
	
	public void setOption(BSMemberOptionName name, BSMemberOptionValue value) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		switch (name) {
		case DOWNLOADED:
		case GLOBAL:
		case TIMELAG:
		case NOTATION:
			switch (value) {
			case ENABLE:
				params.set("name", "1");				
				break;
			case DISABLE:
				params.set("name", "0");				
				break;
			default:
				break;
			}
		case FRIENDSHIP:
			switch (value) {
			case OPEN:
			case REQUESTS:
			case FRIENDS:
			case NOBODY:
				params.set("name", value.toString().toLowerCase());
				break;
			default:
				break;
			}
			break;
		} 		
		
		restTemplate.postForObject(buildUri("members/option"), params, String.class);
	}

	public BSAuthObject signUp(String login, String email) {
		return signUp(login, null, email);
	}

	public BSAuthObject signUp(String login, String password, String email) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("login", login);
		
		if(password != null) {
			if(!password.isEmpty()) {
				params.set("password", hashToMD5(password));										
			}
		}
		
		params.set("email", email);
		
		return restTemplate.postForObject(buildUri("members/signup"), params, BetaSeriesAuthObjectWrapper.class).getAuthenticatedUser();
	}

	public List<BSUser> sync(String[] emails) {
		requireEitherUserOrAppAuthorization();
		
		String emailsStr = StringUtils.arrayToCommaDelimitedString(emails);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("emails", emailsStr);
		
		return restTemplate.postForObject(buildUri("members/sync"), params, BetaSeriesUserList.class).getList();
	}	
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.MemberOperations#simpleAuthentication(java.lang.String, java.lang.String)
	 */
	public BSAuthObject simpleAuthentication(String login, String password) {
		requireAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("login", login);;
		params.set("password", hashToMD5(password));		
		
		return restTemplate.postForObject(buildUri("members/auth"), params, BetaSeriesAuthObjectWrapper.class).getAuthenticatedUser();
	}
	
	/**
	 * Helpers
	 * 
	 */
	
	/**
	 * Hash to md5 a plain text password 
	 * @param password
	 * @return the md5 hashed password
	 */
	private String hashToMD5(String password) {
		String original = password;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(original.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}	
			
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {					
			return password;								
		}		
	}
	
	@SuppressWarnings("serial")
	static class MemberList extends ArrayList<Member>{}
	
	@SuppressWarnings("serial")
	static class UsernameList extends ArrayList<String>{}
	
	@SuppressWarnings("serial")
	static class BadgeList extends ArrayList<Badge>{}
}
