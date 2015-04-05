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

// TODO: Auto-generated Javadoc
/**
 * The Interface FriendOperations.
 *
 * @author Guillaume Maka
 */
public interface FriendOperations {
	
	/**
	 * Block.
	 *
	 * @param userId
	 *            the user id
	 * @return the member
	 */
	Member block(int userId);
	
	/**
	 * Unblock.
	 *
	 * @param userId
	 *            the user id
	 * @return the member
	 */
	Member unblock(int userId);
	
	/**
	 * Adds the friend.
	 *
	 * @param userId
	 *            the user id
	 * @return the member
	 */
	Member addFriend(int userId);
	
	/**
	 * Removes the friend.
	 *
	 * @param userId
	 *            the user id
	 * @return the member
	 */
	Member removeFriend(int userId);
	
	/**
	 * Gets the friends list.
	 *
	 * @return the friends list
	 */
	List<BSUser> getFriendsList();
	
	/**
	 * Gets the friends list.
	 *
	 * @param userId
	 *            the user id
	 * @return the friends list
	 */
	List<BSUser> getFriendsList(String userId);
	
	/**
	 * Gets the blocked friends list.
	 *
	 * @return the blocked friends list
	 */
	List<BSUser> getBlockedFriendsList();
	
	/**
	 * Gets the blocked friends list.
	 *
	 * @param userId
	 *            the user id
	 * @return the blocked friends list
	 */
	List<BSUser> getBlockedFriendsList(String userId);
	
	/**
	 * Gets the requested friends.
	 *
	 * @return the requested friends
	 */
	List<BSUser> getRequestedFriends();
	
	/**
	 * Gets the requested friends.
	 *
	 * @param received
	 *            the received
	 * @return the requested friends
	 */
	List<BSUser> getRequestedFriends(boolean received);
}
