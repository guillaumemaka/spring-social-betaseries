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
 * The Interface TimelineOperations.
 * 
 * @author Guillaume Maka
 */
public interface TimelineOperations {	
	
	/**
	 * Gets the friends timeline.
	 *
	 * @return the friends timeline
	 */
	List<Event> getFriendsTimeline();
	
	/**
	 * Gets the friends timeline.
	 *
	 * @param nbpp the nbpp
	 * @return the friends timeline
	 */
	List<Event> getFriendsTimeline(Integer nbpp);
	
	/**
	 * Gets the friends timeline.
	 *
	 * @param nbpp the nbpp
	 * @param sinceId the since id
	 * @return the friends timeline
	 */
	List<Event> getFriendsTimeline(Integer nbpp, Integer sinceId);
	
	/**
	 * Gets the friends timeline.
	 *
	 * @param nbpp the nbpp
	 * @param sinceId the since id
	 * @param types the types
	 * @return the friends timeline
	 */
	List<Event> getFriendsTimeline(Integer nbpp, Integer sinceId, BSTimelineEventType[] types);
	
	/**
	 * Gets the home timeline.
	 *
	 * @return the home timeline
	 */
	List<Event> getHomeTimeline();
	
	/**
	 * Gets the home timeline.
	 *
	 * @param nbpp the nbpp
	 * @return the home timeline
	 */
	List<Event> getHomeTimeline(Integer nbpp);
	
	/**
	 * Gets the home timeline.
	 *
	 * @param nbpp the nbpp
	 * @param sinceId the since id
	 * @return the home timeline
	 */
	List<Event> getHomeTimeline(Integer nbpp, Integer sinceId);
	
	/**
	 * Gets the home timeline.
	 *
	 * @param nbpp the nbpp
	 * @param sinceId the since id
	 * @param types the types
	 * @return the home timeline
	 */
	List<Event> getHomeTimeline(Integer nbpp, Integer sinceId, BSTimelineEventType[] types);
	
	/**
	 * Gets the member timeline.
	 *
	 * @param memberId the member id
	 * @return the member timeline
	 */
	List<Event> getMemberTimeline(Integer memberId);
	
	/**
	 * Gets the member timeline.
	 *
	 * @param memberId the member id
	 * @param nbpp the nbpp
	 * @return the member timeline
	 */
	List<Event> getMemberTimeline(Integer memberId, Integer nbpp);
	
	/**
	 * Gets the member timeline.
	 *
	 * @param memberId the member id
	 * @param nbpp the nbpp
	 * @param sinceId the since id
	 * @return the member timeline
	 */
	List<Event> getMemberTimeline(Integer memberId, Integer nbpp, Integer sinceId);
	
	/**
	 * Gets the member timeline.
	 *
	 * @param memberId the member id
	 * @param nbpp the nbpp
	 * @param sinceId the since id
	 * @param types the types
	 * @return the member timeline
	 */
	List<Event> getMemberTimeline(Integer memberId, Integer nbpp, Integer sinceId, BSTimelineEventType[] types);
}
