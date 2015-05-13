/**
 * Copyright 2015 Guillaume Maka
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
package org.springframework.social.betaseries.api;

import java.util.List;

import org.springframework.core.io.Resource;

/**
 * Represents an instance of {@code MemberOperations}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public interface MemberOperations {		
	
	/**
	 * Gets the member infos.
	 *
	 * @return the member infos
	 */
	Member getMemberInfos();
	
	/**
	 * Gets the member infos.
	 *
	 * @param memberId
	 *            the member id
	 * @return the member infos
	 */
	Member getMemberInfos(String memberId);
	
	/**
	 * Gets the member infos.
	 *
	 * @param memberId
	 *            the member id
	 * @param summary
	 *            the summary
	 * @return the member infos
	 */
	Member getMemberInfos(String memberId, boolean summary);
	
	/**
	 * Gets the member infos.
	 *
	 * @param memberId
	 *            the member id
	 * @param summary
	 *            the summary
	 * @param showOnly
	 *            the show only
	 * @return the member infos
	 */
	Member getMemberInfos(String memberId, boolean summary, BSObjectType showOnly);
	
	/**
	 * Checks if the member is active.
	 *
	 * @return true, if is active
	 */
	boolean isActive();
	
	/**
	 * Gets the badges.
	 *
	 * @param userId  the user id
	 * @return the badges
	 */
	List<Badge> getBadges(String userId);
	
	/**
	 * Gets the notifications.
	 *
	 * @return the notifications
	 */
	List<Notification> getNotifications();
	
	/**
	 * Gets the notifications.
	 *
	 * @param sinceId
	 *            the since id
	 * @return the notifications
	 */
	List<Notification> getNotifications(String sinceId);
	
	/**
	 * Gets the notifications.
	 *
	 * @param sinceId
	 *            the since id
	 * @param limit
	 *            the limit
	 * @return the notifications
	 */
	List<Notification> getNotifications(String sinceId, String limit);
	
	/**
	 * Gets the notifications.
	 *
	 * @param sinceId
	 *            the since id
	 * @param limit
	 *            the limit
	 * @param order
	 *            the order
	 * @return the notifications
	 */
	List<Notification> getNotifications(String sinceId, String limit, BSSortOrder order);
	
	/**
	 * Gets the notifications.
	 *
	 * @param sinceId
	 *            the since id
	 * @param limit
	 *            the limit
	 * @param order
	 *            the order
	 * @param notificationTypes
	 *            the notification types
	 * @return the notifications
	 */
	List<Notification> getNotifications(String sinceId, String limit, BSSortOrder order, BSNotificationType[] notificationTypes);
	
	/**
	 * Gets the notifications.
	 *
	 * @param sinceId
	 *            the since id
	 * @param limit
	 *            the limit
	 * @param order
	 *            the order
	 * @param notificationTypes
	 *            the notification types
	 * @param autoDelete
	 *            the auto delete
	 * @return the notifications
	 */
	List<Notification> getNotifications(String sinceId, String limit, BSSortOrder order, BSNotificationType[] notificationTypes, boolean autoDelete);
		
	/**
	 * Gets the member options.
	 *
	 * @return the member options
	 */
	BSOptions getMemberOptions();
	
	/**
	 * Search.
	 *
	 * @param login
	 *            the login
	 * @return the list
	 */
	List<BSUser> search(String login);
	
	/**
	 * Gets the available usernames.
	 *
	 * @param username
	 *            the username
	 * @return the available usernames
	 */
	String[] getAvailableUsernames(String username);
	
	/**
	 * Upload avatar.
	 *
	 * @param avatar
	 *            the avatar
	 * @return the member
	 */
	Member uploadAvatar(Resource avatar);
	
	/**
	 * Delete avatar.
	 *
	 * @return the member
	 */
	Member deleteAvatar();
	
	/**
	 * Log out.
	 */
	void logOut();
	
	/**
	 * Reset password.
	 *
	 * @param emailOrUsername
	 *            the email or username
	 */
	void resetPassword(String emailOrUsername);
	
	/**
	 * Sets the option.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	void setOption(BSMemberOptionName name, BSMemberOptionValue value);
	
	/**
	 * Sign up.
	 *
	 * @param login
	 *            the login
	 * @param email
	 *            the email
	 * @return the BS auth object
	 */
	BSAuthObject signUp(String login, String email);
	
	/**
	 * Sign up.
	 *
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @param email
	 *            the email
	 * @return the BS auth object
	 */
	BSAuthObject signUp(String login, String password, String email);
	
	/**
	 * Sync.
	 *
	 * @param emails
	 *            the emails
	 * @return the list
	 */
	List<BSUser> sync(String[] emails);
	
	/**
	 * Simple authentication.
	 *
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return the BS auth object
	 */
	BSAuthObject simpleAuthentication(String login, String password);
}
