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

/**
 * The Interface FriendOperations.
 * 
 * @author Guillaume Maka
 */
public interface FriendOperations {
	
	/**
	 * Block a user.
	 * 
	 * @param userId  the user id to block
	 * @return the blocked member
	 */
	Member block(int userId);
	
	/**
	 * Unblock a user.
	 * 
	 * @param userId  the user id to unblock
	 * @return the unblocked member
	 */
	Member unblock(int userId);
	
	/**
	 * Add a friend relationship.
	 * 
	 * @param userId  the user id to add
	 * @return the new added friend
	 */
	Member addFriend(int userId);
	
	/**
	 * Removes a friend relationship.
	 * 
	 * @param userId  the user id to remove
	 * @return the new removed friend
	 */
	Member removeFriend(int userId);
	
	/**
	 * Get the Friends list for the currenr user.
	 * 
	 * @return the friend list
	 */
	List<BSUser> getFriendsList();
	
	/**
	 * Get the Friends list for a specific user
	 * 
	 * @param userId  the user id
	 * @return the friend list
	 */
	List<BSUser> getFriendsList(String userId);
	
	/**
	 * Get the Blocked friends list for the current user. 
	 * 
	 * @return a collection of {@link BSUser}
	 */
	List<BSUser> getBlockedFriendsList();
	
	/**
	 * Blocked friends list a specific user.
	 * 
	 * @param userId  the user id
	 * @return the blocked friend list
	 */
	List<BSUser> getBlockedFriendsList(String userId);
	
	/**
	 * Get the list of requested friendship sent.
	 * 
	 * @return the requested friendship list
	 */
	List<BSUser> getRequestedFriends();
	
	/**
	 * Get the list of requested friendship sent, including the received request friendship.
	 * 
	 * @param received  the received
	 * @return the requested friendship list
	 */
	List<BSUser> getRequestedFriends(boolean received);
}
