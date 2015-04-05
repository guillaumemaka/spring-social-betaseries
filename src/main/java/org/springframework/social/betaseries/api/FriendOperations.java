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
	 * Block a user.
	 * 
	 * @param userId
	 *            the user id to block
	 * @return TODO
	 */
	Member block(int userId);
	
	/**
	 * Unblock a user.
	 * 
	 * @param userId
	 *            the user id to unblock
	 * @return TODO
	 */
	Member unblock(int userId);
	
	/**
	 * Add a friend relationship.
	 * 
	 * @param userId
	 *            the user id to add
	 * @return TODO
	 */
	Member addFriend(int userId);
	
	/**
	 * Removes a friend relationship.
	 * 
	 * @param userId
	 *            the user id to remove
	 * @return TODO
	 */
	Member removeFriend(int userId);
	
	/**
	 * Get the Friends list for the currenr user.
	 * 
	 * @return the list
	 */
	List<BSUser> getFriendsList();
	
	/**
	 * Get the Friends list for a specific user.
	 *
	 * @param userId            the user id
	 * @return the list
	 */
	List<BSUser> getFriendsList(String userId);
	
	/**
	 * Get the Blocked friends list for the current user. 
	 * 
	 * @return a collection of {@link Friend}
	 */
	List<BSUser> getBlockedFriendsList();
	
	/**
	 * Blocked friends list a specific user.
	 * 
	 * @param userId
	 *            the user id
	 * @return the list
	 */
	List<BSUser> getBlockedFriendsList(String userId);
	
	/**
	 * Get the requested friendship sent.
	 * 
	 * @return the list
	 */
	List<BSUser> getRequestedFriends();
	
	/**
	 * Get the requested friendship sent, including the received request friendship.
	 * 
	 * @param received
	 *            the received
	 * @return the list
	 */
	List<BSUser> getRequestedFriends(boolean received);
}
