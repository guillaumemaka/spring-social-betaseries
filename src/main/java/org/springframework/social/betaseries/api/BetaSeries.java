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

import org.springframework.social.ApiBinding;

// TODO: Auto-generated Javadoc
/*
 * Interface specifying a basic set of operations for interacting with BetaSeries.
 * Implemented by BetaSeriesTemplate.
 * 
 * @author Guillaume Maka
 */
/**
 * The Interface BetaSeries.
 * 
 * @author Guillaume Maka
 */
public interface BetaSeries extends ApiBinding {
	
	/**
	 * Comment operations.
	 * 
	 * @return the comment operations
	 */
	CommentOperations commentOperations();
	
	/**
	 * Episode operations.
	 * 
	 * @return the episode operations
	 */
	EpisodeOperations episodeOperations();
	
	/**
	 * Friend operations.
	 * 
	 * @return the friend operations
	 */
	FriendOperations friendOperations();
	
	/**
	 * Member operations.
	 * 
	 * @return the member operations
	 */
	MemberOperations memberOperations();
	
	/**
	 * Message operations.
	 * 
	 * @return the message operations
	 */
	MessageOperations messageOperations();
	
	/**
	 * Movie operations.
	 * 
	 * @return the movie operations
	 */
	MovieOperations movieOperations();
	
	/**
	 * Picture operations.
	 * 
	 * @return the picture operations
	 */
	PictureOperations pictureOperations();
	
	/**
	 * Planning operations.
	 * 
	 * @return the planning operations
	 */
	PlanningOperations planningOperations();
	
	/**
	 * Show operations.
	 * 
	 * @return the show operations
	 */
	ShowOperations showOperations();
	
	/**
	 * Subtitle operations.
	 * 
	 * @return the subtitle operations
	 */
	SubtitleOperations subtitleOperations();
	
	/**
	 * Timeline operations.
	 * 
	 * @return the timeline operations
	 */
	TimelineOperations timelineOperations();
}
