package org.springframework.social.betaseries.api.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.betaseries.api.PictureOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class PictureTemplate extends AbstractBetaSeriesOperations implements
		PictureOperations {
	private final RestTemplate restTemplate;
	
	public PictureTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized)  {
		super(isUserAuthorized,isAppAuthorized);		
		this.restTemplate = restTemplate;
	}
	
	public byte[] getBadgePicture(int badgeId) {		
		return getImage("pictures/badges", badgeId, null, null);
	}
	
	public byte[] getBadgePicture(int badgeId, Integer height, Integer width) {		
		return getImage("pictures/badges", badgeId, height, width);
	}
	
	public byte[] getCharacterPicture(int characterId) {
		return getImage("pictures/characters", characterId, null, null);
	}
	
	public byte[] getCharacterPicture(int characterId, Integer height, Integer width) {
		return getImage("pictures/characters", characterId, height, width);
	}

	public byte[] getEpisodePicture(int episodeId) {
		return getImage("pictures/episodes", episodeId, null, null);
	}
	
	public byte[] getEpisodePicture(int episodeId, Integer height, Integer width) {
		return getImage("pictures/episodes", episodeId, height, width);
	}
	
	public byte[] getMemberPicture(int memberId) {
		return getImage("pictures/members", memberId, null, null);
	}
	
	public byte[] getMemberPicture(int memberId, Integer height, Integer width) {
		return getImage("pictures/members", memberId, height, width);
	}
	
	public byte[] getMoviePicture(int movieId) {
		return getImage("pictures/movies", movieId, null, null);
	}
	
	public byte[] getMoviePicture(int movieId, Integer height, Integer width) {
		return getImage("pictures/movies", movieId, height, width);
	}
	
	public byte[] getShowPicture(int showId) {		
		return getImage("pictures/shows", showId, null, null);
	}
	
	public byte[] getShowPicture(int showId, Integer height, Integer width) {		
		return getImage("pictures/shows", showId, height, width);
	}
	
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
