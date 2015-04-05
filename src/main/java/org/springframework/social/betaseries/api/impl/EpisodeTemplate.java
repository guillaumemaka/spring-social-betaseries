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

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.social.betaseries.api.BSSubtitles;
import org.springframework.social.betaseries.api.Episode;
import org.springframework.social.betaseries.api.EpisodeOperations;
import org.springframework.social.betaseries.api.UnseenEpisode;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesEpisodeList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesEpisodeSingleObject;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesUnseenEpisodeList;
import org.springframework.social.betaseries.utils.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class EpisodeTemplate.
 *
 * @author Guillaume Maka
 */
public class EpisodeTemplate extends AbstractBetaSeriesOperations implements EpisodeOperations {
	
	/** The rest template. */
	private final RestTemplate restTemplate;
	
	/**
	 * Instantiates a new episode template.
	 *
	 * @param restTemplate
	 *            the rest template
	 * @param isUserAuthorized
	 *            the is user authorized
	 * @param isAppAuthorized
	 *            the is app authorized
	 */
	public EpisodeTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getByIds(java.lang.String[])
	 */
	public List<Episode> getByIds(String[] episodeIds) {
		requireEitherUserOrAppAuthorization();
		return getByIds(episodeIds, false);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getByTvDbIds(java.lang.String[])
	 */
	public List<Episode> getByTvDbIds(String[] theTvDbIds) {
		requireEitherUserOrAppAuthorization();
		return getByTvDbIds(theTvDbIds, false);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getByIds(java.lang.String[], boolean)
	 */
	public List<Episode> getByIds(String[] episodeIds, boolean includeSubtitles) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		String tokenizedIds = StringUtils.tokenize(episodeIds, ",");
		
		params.set("id", tokenizedIds);
		if(includeSubtitles)
			params.set("subtitles", String.valueOf(includeSubtitles));
		
		return restTemplate.getForObject(buildUri("episodes/display", params), BetaSeriesEpisodeList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getByTvDbIds(java.lang.String[], boolean)
	 */
	public List<Episode> getByTvDbIds(String[] theTvDbIds, boolean includeSubtitles) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		String tokenizedIds = StringUtils.tokenize(theTvDbIds, ",");
		
		params.set("thetvdb_id", tokenizedIds);
		
		if(includeSubtitles)
			params.set("subtitles", String.valueOf(includeSubtitles));
		
		return restTemplate.getForObject(buildUri("episodes/display", params), BetaSeriesEpisodeList.class).getList();
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getEpisodesToBeWatch()
	 */
	public List<UnseenEpisode> getEpisodesToBeWatch() {				
		return getEpisodesToBeWatch(null, -1, null, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getEpisodesToBeWatch(java.lang.String)
	 */
	public List<UnseenEpisode> getEpisodesToBeWatch(String showId) {		
		return getEpisodesToBeWatch(showId, -1, null, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getEpisodesToBeWatch(java.lang.String, int)
	 */
	public List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit) {		
		return getEpisodesToBeWatch(showId, limit, null, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getEpisodesToBeWatch(java.lang.String, int, java.lang.String)
	 */
	public List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit,
			String user_id) {
		return getEpisodesToBeWatch(showId, limit, user_id, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getEpisodesToBeWatch(java.lang.String, int, java.lang.String, org.springframework.social.betaseries.api.BSSubtitles)
	 */	
	public List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit,
			String user_id, BSSubtitles subtitles) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if (showId != null) {
			if(!showId.isEmpty()) {
				params.set("showId", showId);
			}
		}
		
		if (limit > 0) {
			params.set("limit", String.valueOf(limit));
		}
		
		if (user_id != null) {
			if(!user_id.isEmpty()) {
				params.set("user_id", user_id);
			}
		}
		
		if(subtitles != null) {
			params.set("subtitles", subtitles.toString().toLowerCase());
		}
		
		return restTemplate.getForObject(buildUri("episodes/list", params), BetaSeriesUnseenEpisodeList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#search(java.lang.String, java.lang.String, org.springframework.social.betaseries.api.BSSubtitles)
	 */
	public Episode search(String showId, String number,
			boolean includeSubtitles) {
		requireAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if (showId != null) {
			if (!showId.isEmpty()) {
				params.set("show_id", showId);
			}
		}
		
		if (number != null) {
			if (!number.isEmpty() ) {
				params.set("number", number);
			}
		}
		
		if(includeSubtitles) { 
			params.set("subtitles", String.valueOf(includeSubtitles));
		}
		
		return restTemplate.getForObject(buildUri("episodes/search", params), BetaSeriesEpisodeSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getById(java.lang.String)
	 */
	public Episode getById(String episodeId) {		
		return getById(episodeId, false);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getByTheTvDbId(java.lang.String)
	 */
	public Episode getByTheTvDbId(String theTvDbId) {		
		return getByTheTvDbId(theTvDbId, false);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getById(java.lang.String, boolean)
	 */
	public Episode getById(String episodeId, boolean includeSubtitles) {
		requireAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("id", episodeId);
		
		if(includeSubtitles)
			params.set("subtitles", String.valueOf(includeSubtitles));
		
		return restTemplate.getForObject(buildUri("episodes/display", params), BetaSeriesEpisodeSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#getByTheTvDbId(java.lang.String, boolean)
	 */
	public Episode getByTheTvDbId(String theTvDbId, boolean includeSubtitles) {
		requireAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("thetvdb_id", theTvDbId);
		
		if(includeSubtitles)
			params.set("subtitles", String.valueOf(includeSubtitles));
		
		return restTemplate.getForObject(buildUri("episodes/display", params), BetaSeriesEpisodeSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#markAsDownloaded(org.springframework.social.betaseries.api.Episode)
	 */
	public Episode markAsDownloaded(String episodeId) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();				
		params.set("id", String.valueOf(episodeId));
					
		return restTemplate.postForObject(buildUri("episodes/downloaded"), params, BetaSeriesEpisodeSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#unmarkAsDownloaded(org.springframework.social.betaseries.api.Episode)
	 */
	public Episode unmarkAsDownloaded(String episodeId) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();				
		params.set("id", String.valueOf(episodeId));
		
		//HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<LinkedMultiValueMap<String,String>>(params, new HttpHeaders());
		
		return restTemplate.exchange(buildUri("episodes/downloaded",params), HttpMethod.DELETE, null, BetaSeriesEpisodeSingleObject.class).getBody().getObject();
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#markAsWatched(org.springframework.social.betaseries.api.Episode)
	 */
	public Episode markAsWatched(String episodeId) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();				
		params.set("id", String.valueOf(episodeId));
					
		return restTemplate.postForObject(buildUri("episodes/watched"), params, BetaSeriesEpisodeSingleObject.class).getObject();		
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#unMarkAsWatched(org.springframework.social.betaseries.api.Episode)
	 */
	public Episode unMarkAsWatched(String episodeId) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();				
		params.set("id", String.valueOf(episodeId));		
		//HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<LinkedMultiValueMap<String,String>>(params, new HttpHeaders());
		
		return restTemplate.exchange(buildUri("episodes/watched", params), HttpMethod.DELETE, null,BetaSeriesEpisodeSingleObject.class).getBody().getObject();		
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#rateEpisode(org.springframework.social.betaseries.api.Episode)
	 */
	public Episode rateEpisode(String episodeId, int note) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();				
		
		params.set("id", String.valueOf(episodeId));
		params.set("note", String.valueOf(note));
		
		return restTemplate.postForObject(buildUri("episodes/note"), params, BetaSeriesEpisodeSingleObject.class).getObject();		
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.EpisodeOperations#unRateEpisode(org.springframework.social.betaseries.api.Episode)
	 */
	public Episode unRateEpisode(String episodeId) {
		requireEitherUserOrAppAuthorization();
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();						
		params.set("id", String.valueOf(episodeId));				
		//HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<LinkedMultiValueMap<String,String>>(params, new HttpHeaders());
		
		return restTemplate.exchange(buildUri("episodes/note", params), HttpMethod.DELETE, null, BetaSeriesEpisodeSingleObject.class).getBody().getObject();			
	}
}
