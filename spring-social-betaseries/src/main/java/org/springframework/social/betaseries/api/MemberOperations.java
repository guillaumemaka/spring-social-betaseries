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
package org.springframework.social.betaseries.api;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.social.MissingAuthorizationException;

// TODO: Auto-generated Javadoc
/**
 * The Interface MemberOperations.
 * 
 * @author Guillaume Maka
 */
public interface MemberOperations {		
	
	/**
	 * Gets the current user logged in member infos.
	 * 
	 * @return {@link Member} object
	 */
	Member getMemberInfos();
	
	Member getMemberInfos(String memberId);
	
	Member getMemberInfos(String memberId, boolean summary);
	
	Member getMemberInfos(String memberId, boolean summary, BSObjectType showOnly);
	
	/**
	 * Checks if is active.
	 * @return TODO
	 * 
	 * @throws MissingAuthorizationException
	 */
	boolean isActive();
	
	/**
	 * Gets the badges.
	 * 
	 * @param userId
	 *            the user id
	 * @return the badges
	 */
	List<Badge> getBadges(String userId);
	
	/**
	 * Gets notifications.
	 * 
	 * @return a collection of {@link Notification}
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
	 * Member options.
	 * 
	 * @return the list
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
	 * Available usernames.
	 * 
	 * @param username
	 *            the username
	 * @return the list
	 */
	String[] getAvailableUsernames(String username);
	
	/**
	 * Upload avatar.
	 * 
	 * @param avatar
	 *            the avatar
	 * @return TODO
	 */
	Member uploadAvatar(Resource avatar);
	
	/**
	 * Delete avatar.
	 * @return TODO
	 * @return TODO
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
	 * Sets the options.
	 * 
	 * @param options
	 *            the new options {@link MemberOptions}
	 */
	void setOption(BSMemberOptionName name, BSMemberOptionValue value);
	
	/**
	 * Sign up a new user. The password will be in the confirmation email from BetaSeries
	 * 
	 * @param login
	 *            the login of the new user
	 * @param email
	 *            the email of the new user
	 * @return TODO
	 */
	BSAuthObject signUp(String login, String email);
	
	/**
	 * Sign up a new user.
	 * 
	 * @param login
	 *            the login of the new user
	 * @param password
	 *            the plain text password of the new user
	 * @param email
	 *            the email of the new user
	 * @return TODO
	 */
	BSAuthObject signUp(String login, String password, String email);
	
	/**
	 * Search a friend from the current user.
	 * 
	 * @param emails
	 *            the emails of users to find
	 * @return TODO
	 */
	List<BSUser> sync(String[] emails);
	
	BSAuthObject simpleAuthentication(String login, String password);
}
