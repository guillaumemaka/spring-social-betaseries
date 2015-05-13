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

import org.springframework.social.ApiBinding;

/*
 * Interface specifying a basic set of operations for interacting with BetaSeries.
 * Implemented by BetaSeriesTemplate.
 * 
 * @author Guillaume Maka
 */
public interface BetaSeries extends ApiBinding {
	
	/**
	 * Gets a an instance of {@code CommentOperations}.
	 * <p>
	 * A {@code CommentOperations} exposes all operation that can be performed
	 * relative to comments endpoint
	 * </p>
	 * 
	 * 
	 * @return the comment operations
	 */
	CommentOperations commentOperations();
	
	/**
	 * Gets an instance {@code EpisodeOperations}.
	 * <p>
	 * An {@code EpisodeOperations} exposes all operations that can be performed
	 * relative to the episodes endpoint.
	 * </p>
	 * 
	 * @return the episode operations
	 */
	EpisodeOperations episodeOperations();
	
	/**
	 * Gets an instance {@code FriendOperations}.
	 * <p>
	 * An {@code FriendOperations} exposes all operations that can be performed
	 * relative to the member friends relationship.
	 * </p>
	 * 
	 * @return the friend operations
	 */
	FriendOperations friendOperations();
	
	/**
	 * Gets an instance {@code MemberOperations}.
	 * <p>
	 * An {@code MemberOperations} exposes all operations that can be performed
	 * relative to the member endpoint.
	 * </p>
	 * 
	 * @return the member operations
	 */
	MemberOperations memberOperations();
	
	/**
	 * * Gets an instance {@code MessageOperations}.
	 * <p>
	 * An {@code MessageOperationsFriendOperations} exposes all operations that can be performed
	 * relative to the message endpoint.
	 * </p>
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
	 * Gets an instance {@code SubtitleOperations}.
	 * <p>
	 * An {@code SubtitleOperationsFriendOperations} exposes all operations that can be performed
	 * relative to the subtitle endpoint.
	 * </p>
	 * 
	 * @return the subtitle operations
	 */
	SubtitleOperations subtitleOperations();
	
	/**
 	 * Gets an instance {@code TimelineOperations}.
	 * <p>
	 * An {@code TimelineOperationsFriendOperations} exposes all operations that can be performed
	 * relative to the timeline endpoint.
	 * </p>
	 * 
	 * @return the timeline operations
	 */
	TimelineOperations timelineOperations();
}



