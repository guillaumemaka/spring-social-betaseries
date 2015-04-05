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
package org.springframework.social.betaseries.api.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.betaseries.api.PictureOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class PictureTemplate.
 *
 * @author Guillaume Maka
 */
public class PictureTemplate extends AbstractBetaSeriesOperations implements
		PictureOperations {
	
	/** The rest template. */
	private final RestTemplate restTemplate;
	
	/**
	 * Instantiates a new picture template.
	 *
	 * @param restTemplate
	 *            the rest template
	 * @param isUserAuthorized
	 *            the is user authorized
	 * @param isAppAuthorized
	 *            the is app authorized
	 */
	public PictureTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized)  {
		super(isUserAuthorized,isAppAuthorized);		
		this.restTemplate = restTemplate;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getBadgePicture(int)
	 */
	public byte[] getBadgePicture(int badgeId) {		
		return getImage("pictures/badges", badgeId, null, null);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getBadgePicture(int, java.lang.Integer, java.lang.Integer)
	 */
	public byte[] getBadgePicture(int badgeId, Integer height, Integer width) {		
		return getImage("pictures/badges", badgeId, height, width);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getCharacterPicture(int)
	 */
	public byte[] getCharacterPicture(int characterId) {
		return getImage("pictures/characters", characterId, null, null);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getCharacterPicture(int, java.lang.Integer, java.lang.Integer)
	 */
	public byte[] getCharacterPicture(int characterId, Integer height, Integer width) {
		return getImage("pictures/characters", characterId, height, width);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getEpisodePicture(int)
	 */
	public byte[] getEpisodePicture(int episodeId) {
		return getImage("pictures/episodes", episodeId, null, null);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getEpisodePicture(int, java.lang.Integer, java.lang.Integer)
	 */
	public byte[] getEpisodePicture(int episodeId, Integer height, Integer width) {
		return getImage("pictures/episodes", episodeId, height, width);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getMemberPicture(int)
	 */
	public byte[] getMemberPicture(int memberId) {
		return getImage("pictures/members", memberId, null, null);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getMemberPicture(int, java.lang.Integer, java.lang.Integer)
	 */
	public byte[] getMemberPicture(int memberId, Integer height, Integer width) {
		return getImage("pictures/members", memberId, height, width);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getMoviePicture(int)
	 */
	public byte[] getMoviePicture(int movieId) {
		return getImage("pictures/movies", movieId, null, null);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getMoviePicture(int, java.lang.Integer, java.lang.Integer)
	 */
	public byte[] getMoviePicture(int movieId, Integer height, Integer width) {
		return getImage("pictures/movies", movieId, height, width);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getShowPicture(int)
	 */
	public byte[] getShowPicture(int showId) {		
		return getImage("pictures/shows", showId, null, null);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PictureOperations#getShowPicture(int, java.lang.Integer, java.lang.Integer)
	 */
	public byte[] getShowPicture(int showId, Integer height, Integer width) {		
		return getImage("pictures/shows", showId, height, width);
	}
	
	/**
	 * Gets the image.
	 *
	 * @param path
	 *            the path
	 * @param objectId
	 *            the object id
	 * @param height
	 *            the height
	 * @param width
	 *            the width
	 * @return the image
	 */
	private byte[] getImage(String path, Integer objectId, Integer height, Integer width) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("id", String.valueOf(objectId));
		
		if (height != null) {
			if (height > 250) {
				params.set("height", height.toString());
			}
		}
		
		if (width != null) {
			if (width > 250) {
				params.set("width", width.toString());
			}
		}
		
		ResponseEntity<byte[]> response = restTemplate.getForEntity(buildUri(path, params), byte[].class);
		
		if(response.getStatusCode() == HttpStatus.FOUND) {
			throw new UnsupportedOperationException("Attempt to fetch image resulted in a redirect which could not be followed. Add Apache HttpComponents HttpClient to the classpath " +
					"to be able to follow redirects.");
		}
		
		return response.getBody();
	}

}
