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
 * The Interface CommentOperations.
 * 
 * @author Guillaume Maka
 */
public interface CommentOperations {
	
	/**
	 * Gets the latest comments for a specific object type.
	 *
	 * @param type            the BetaSeries element type {@link BSObjectType} episode|movie|show|member episode|movie|show|member
	 * @param objectId            the BetaSeries element object id
	 * @return collection of {@link Comment}
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId);
	
	/**
	 * Gets a subset of comments.
	 *
	 * @param type            the BetaSerie element type {@link BSObjectType} episode|movie|show|member
	 * @param objectId            the object id
	 * @param commentPerPage            the number of comment per page
	 * @return a collection of {@link Comment}
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId, int commentPerPage);
	
	/**
	 * Gets the comments for.
	 * 
	 * @param type
	 *            the BetaSerie element type {@link BSObjectType} episode|movie|show|member
	 * @param objectId
	 *            the object id
	 * @param commentPerPage
	 *            the comment per page
	 * @param sinceId
	 *            the since id
	 * @return the comments for
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId, int commentPerPage, String sinceId);
	
	/**
	 * Gets the comments for.
	 * 
	 * @param type
	 *            the BetaSerie element type {@link BSObjectType} episode|movie|show|member
	 * @param objectId
	 *            the object id
	 * @param commentPerPage
	 *            the comment per page
	 * @param sinceId
	 *            the since id
	 * @param order
	 *            the order
	 * @return the comments for
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId, int commentPerPage, String sinceId, BSSortOrder order);
	
	/**
	 * Gets the comments for.
	 * 
	 * @param type
	 *            the BetaSerie element type {@link BSObjectType} episode|movie|show|member
	 * @param objectId
	 *            the object id
	 * @param commentPerPage
	 *            the comment per page
	 * @param sinceId
	 *            the since id
	 * @param order
	 *            the order
	 * @param includeReplies
	 *            the include replies
	 * @return the comments for
	 */
	List<Comment> getCommentsFor(BSObjectType type, String objectId, int commentPerPage, String sinceId, BSSortOrder order, boolean includeReplies);
	
	/**
	 * Gets the comments replies for a specific comment.
	 *
	 * @param commentId            the comment id
	 * @param order            the order
	 * @return the comments replies for
	 */
	List<Comment> getCommentsRepliesFor(String commentId, BSSortOrder order);
	
	/**
	 * Suscribe.
	 * 
	 * @param type
	 *            the BetaSerie element type {@link BSObjectType} episode|movie|show|member
	 * @param commentId
	 *            the comment id
	 */
	void suscribe(BSObjectType type, String commentId);
	
	/**
	 * Unsuscribe.
	 * 
	 * @param type
	 *            the BetaSerie element type {@link BSObjectType} episode|movie|show|member
	 * @param commentId
	 *            the comment id
	 */
	void unSuscribe(BSObjectType type, String commentId);
}
