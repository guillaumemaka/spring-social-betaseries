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


/**
 * Represents an instance of {@code CommentOperations}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public interface CommentOperations {
	
	/**
	 * Gets the {@code 10} first comments for an element {@code id}
	 * in descending order including replies.
	 * <p>
	 * You can get 4 type of element comments:
	 * <ul>
	 * <li>EPISODE</li>
	 * <li>SHOW</li>
	 * <li>MEMBER</li>
	 * <li>MOVIE</li>
	 * </ul>
	 * </p>
	 * 
	 * @param type  the type of element {@link BSObjectType}
	 * @param objectId  the object id
	 * @return the list of comments for the specified element
	 * @throws ApiException
	 * @see BSObjectType
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId);
	
	/**
	 * Gets the {@code n} comments for an element starting at the specified element {@code id}
	 * in descending order including replies.
	 * <p>
	 * You can get 4 type of element comments:
	 * <ul>
	 * <li>EPISODE</li>
	 * <li>SHOW</li>
	 * <li>MEMBER</li>
	 * <li>MOVIE</li>
	 * </ul>
	 * </p>
	 * 
	 * @param type  the type of element {@link BSObjectType}
	 * @param objectId  the object id
	 * @param commentPerPage  the number of comment per page
	 * @return the list of comments for the specified element
	 * @throws ApiException
	 * @see BSObjectType
	 * @see Comment
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId, int commentPerPage);
	
	/**
	 * Gets the {@code n} comments for an element starting at the specified element {@code id}
	 * in descending order including replies.
	 * <p>
	 * You can get 4 type of element comments:
	 * <ul>
	 * <li>EPISODE</li>
	 * <li>SHOW</li>
	 * <li>MEMBER</li>
	 * <li>MOVIE</li>
	 * </ul>
	 * </p>
	 * 
	 * @param type  the type of element {@link BSObjectType}
	 * @param objectId  the object id of the element
	 * @param commentPerPage  the number of comment per page to retrieve
	 * @param sinceId  the last comment received id to start 
	 * @return the list of comments for the specified element
	 * @throws ApiException
	 * @see BSObjectType
	 * @see Comment
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId, int commentPerPage, String sinceId);
	
	/**
	 * Gets the {@code n} comments for an element starting at the specified element {@code id}
	 * in the given order including replies.
	 * <p>
	 * You can get 4 type of element comments:
	 * <ul>
	 * <li>EPISODE</li>
	 * <li>SHOW</li>
	 * <li>MEMBER</li>
	 * <li>MOVIE</li>
	 * </ul>
	 * </p>
	 * 
	 * @param type  the type of element {@link BSObjectType}
	 * @param objectId  the object id of the element
	 * @param commentPerPage  the number of comment per page to retrieve
	 * @param sinceId  the last comment received id to start
	 * @param order  the order
	 * @return the list of comments for the specified element
	 * @throws ApiException
	 * @see BSObjectType
	 * @see BSSortOrder
	 * @see Comment
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId, int commentPerPage, String sinceId, BSSortOrder order);
	
	/**
	 * Gets the {@code n} comments for an element starting at the specified element {@code id}
	 * in the given order with/without replies.
	 * <p>
	 * You can get 4 type of element comments:
	 * <ul>
	 * <li>EPISODE</li>
	 * <li>SHOW</li>
	 * <li>MEMBER</li>
	 * <li>MOVIE</li>
	 * </ul>
	 * </p>
	 * 
	 * @param type  the type of element {@link BSObjectType}
	 * @param objectId  the object id of the element
	 * @param commentPerPage  the number of comment per page to retrieve
	 * @param sinceId  the last comment received id to start
	 * @param order  the order
	 * @param includeReplies  if true include replies
	 * @return the list of comments for the specified element
	 * @throws ApiException
	 * @see BSObjectType
	 * @see BSSortOrder
	 * @see Comment
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId, int commentPerPage, String sinceId, BSSortOrder order, boolean includeReplies);
	
	/**
	 * Gets the comments replies for a specific comment.
	 *
	 * @param commentId  the comment id
	 * @param order  the order
	 * @return the list of comments repllies for the specified comment
	 * @throws ApiException
	 * @see BSSortOrder
	 * @see Comment
	 */
	List<Comment> getCommentsRepliesFor(String commentId, BSSortOrder order);
	
	/**
	 * Subscribe to a comment feed.
	 *
	 * @param type  the element type
	 * @param commentId  the comment id to subscribe
	 * @throws ApiException
	 */
	void suscribe(BSObjectType type, String commentId);
	
	/**
	 * Unsubscribe to a comment feed.
	 *
	 * @param type  the element type
	 * @param commentId  the comment id to unsubscribe
	 * @throws ApiException 
	 */
	void unSuscribe(BSObjectType type, String commentId);
}
