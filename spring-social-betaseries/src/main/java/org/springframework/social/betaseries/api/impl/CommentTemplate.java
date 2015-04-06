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
package org.springframework.social.betaseries.api.impl;

import java.util.List;

import org.springframework.social.betaseries.api.BSObjectType;
import org.springframework.social.betaseries.api.BSSortOrder;
import org.springframework.social.betaseries.api.Comment;
import org.springframework.social.betaseries.api.CommentOperations;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesCommentList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * The Class CommentTemplate.
 * 
 * @author Guillaume Maka
 */
public class CommentTemplate extends AbstractBetaSeriesOperations implements
		CommentOperations {
	
	/** The rest template. */
	private final RestTemplate restTemplate;
	
	/**
	 * Instantiates a new comment template.
	 * 
	 * @param restTemplate
	 *            the rest template
	 * @param isUserAuthorized
	 *            the is user authorized
	 * @param isAppAuthorized
	 *            the is app authorized
	 */
	public CommentTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.CommentOperations#getCommentsFor(org.springframework.social.betaseries.api.BSObjectType, java.lang.String)
	 */
	public List<Comment> getCommentsFor(BSObjectType type, String objectId) {				
		return getCommentsFor(type, objectId, -1);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.CommentOperations#getCommentsFor(org.springframework.social.betaseries.api.BSObjectType, java.lang.String, int)
	 */
	public List<Comment> getCommentsFor(BSObjectType type, String objectId,
			int commentPerPage) {		
		return getCommentsFor(type, objectId, commentPerPage, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.CommentOperations#getCommentsFor(org.springframework.social.betaseries.api.BSObjectType, java.lang.String, int, java.lang.String)
	 */
	public List<Comment> getCommentsFor(BSObjectType type, String objectId,
			int commentPerPage, String sinceId) {		
		return getCommentsFor(type, objectId, commentPerPage, sinceId, BSSortOrder.ASC);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.CommentOperations#getCommentsFor(org.springframework.social.betaseries.api.BSObjectType, java.lang.String, int, java.lang.String, org.springframework.social.betaseries.api.BSSortOrder)
	 */
	public List<Comment> getCommentsFor(BSObjectType type, String objectId,
			int commentPerPage, String sinceId, BSSortOrder order) {		
		return getCommentsFor(type, objectId, commentPerPage, sinceId, order, true);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.CommentOperations#getCommentsFor(org.springframework.social.betaseries.api.BSObjectType, java.lang.String, int, java.lang.String, org.springframework.social.betaseries.api.BSSortOrder, boolean)
	 */
	public List<Comment> getCommentsFor(BSObjectType type, String objectId,
			int commentPerPage, String sinceId, BSSortOrder order,
			boolean includeReplies) {
		
		requireAppAuthorization();
		
		LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
				
		parameters.set("id", objectId);
		parameters.set("type", type.toString().toLowerCase());
		
		if(commentPerPage > 10) {
			parameters.set("nbpp", String.valueOf(commentPerPage));
		}
		
		if(sinceId != null) {
			if(!sinceId.isEmpty()) {
				parameters.set("since_id", sinceId);
			}
		}		
		
		if (order != BSSortOrder.ASC) {
			parameters.set("order", order.toString().toLowerCase());
		}
		
		if (!includeReplies) {
			parameters.set("replies", includeReplies ? "1" : "0");
		}
						
		return restTemplate.getForObject(buildUri("comments/comments", parameters), BetaSeriesCommentList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.CommentOperations#getCommentsRepliesFor(java.lang.String, org.springframework.social.betaseries.api.BSSortOrder)
	 */
	public List<Comment> getCommentsRepliesFor(String commentId,
			BSSortOrder order) {
		requireAppAuthorization();
		LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		
		parameters.set("id", commentId);
		
		if (order != BSSortOrder.ASC) {
			parameters.set("order", order.toString().toLowerCase());
		}
		
		return restTemplate.getForObject(buildUri("comments/replies", parameters), BetaSeriesCommentList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.CommentOperations#suscribe(org.springframework.social.betaseries.api.BSObjectType, java.lang.String)
	 */
	public void suscribe(BSObjectType type, String commentId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
		
		data.set("type", type.toString().toLowerCase());
		data.set("id", commentId);
		
		restTemplate.postForObject(buildUri("comments/subscription"), data, String.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.CommentOperations#unSuscribe(org.springframework.social.betaseries.api.BSObjectType, java.lang.String)
	 */
	public void unSuscribe(BSObjectType type, String commentId) {		
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		
		parameters.set("type", type.toString().toLowerCase());
		parameters.set("id", commentId);
		
		restTemplate.delete(buildUri("comments/subscription", parameters));
	}
}
