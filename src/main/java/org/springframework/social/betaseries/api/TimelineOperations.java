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
 * The Interface TimelineOperations.
 * 
 * @author Guillaume Maka
 */
public interface TimelineOperations {	
	List<Event> getFriendsTimeline();
	List<Event> getFriendsTimeline(Integer nbpp);
	List<Event> getFriendsTimeline(Integer nbpp, Integer sinceId);
	List<Event> getFriendsTimeline(Integer nbpp, Integer sinceId, BSTimelineEventType[] types);
	List<Event> getHomeTimeline();
	List<Event> getHomeTimeline(Integer nbpp);
	List<Event> getHomeTimeline(Integer nbpp, Integer sinceId);
	List<Event> getHomeTimeline(Integer nbpp, Integer sinceId, BSTimelineEventType[] types);
	List<Event> getMemberTimeline(Integer memberId);
	List<Event> getMemberTimeline(Integer memberId, Integer nbpp);
	List<Event> getMemberTimeline(Integer memberId, Integer nbpp, Integer sinceId);
	List<Event> getMemberTimeline(Integer memberId, Integer nbpp, Integer sinceId, BSTimelineEventType[] types);
}
