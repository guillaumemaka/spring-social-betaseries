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

import org.springframework.social.ApiException;


// TODO: Auto-generated Javadoc
/**
 * Represents an instance of {@code EpisodeOperations}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public interface EpisodeOperations {
		
	/**
	 * Gets the episodes specified by the given ids without subtitles.
	 *
	 * @param theTvDbIds  an array of id
	 * @param includeSubtitles  if true include subtitles
	 * @return a list of episode
	 */
	List<Episode> getByIds(String[] episodeIds);
	
	/**
	 * Gets the episodes specified by the given TV DB ids without subtitles.
	 *
	 * @param theTvDbIds  an array of TV DB id
	 * @param includeSubtitles  if true include subtitles
	 * @return a list of episode
	 */
	List<Episode> getByTvDbIds(String[] theTvDbIds);
	
	/**
	 * Gets the episodes specified by the given ids without subtitles.
	 *
	 * @param theTvDbIds  an array of id
	 * @return a list of episode
	 */
	List<Episode> getByIds(String[] episodeIds, boolean includeSubtitles);
	
	/**
	 * Gets the episodes specified by the given TV DB ids w/o subtitles.
	 *
	 * @param theTvDbIds  an array of TV DB id
	 * @param includeSubtitles  if true include subtitles
	 * @return a list of episode
	 */
	List<Episode> getByTvDbIds(String[] theTvDbIds, boolean includeSubtitles);
	
	/**
	 * Gets all the unseen episodes of the authenticated user 
	 * for all show that have unseen episodes, without subtitles.
	 *
	 * @return the episodes to be watch
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 * @see UnseenEpisode
	 */
	List<UnseenEpisode> getEpisodesToBeWatch();
	
	/**
	 * Gets all the unseen episodes of the authenticated user 
	 * for the given show, without subtitles.
	 *
	 * @param showId  the show id 
	 * @return the episodes to be watch
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 * @see UnseenEpisode
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId);
	
	/**
	 * Gets the {@code n} first unseen episodes of the authenticated user 
	 * for a given show, without subtitles.
	 *
	 * @param showId  the show id
	 * @param limit  the limit
	 * @return the episodes to be watch
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 * @see UnseenEpisode
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit);
	
	/**
	 * Gets the {@code n} first unseen episodes for a given show, user and without 
	 * subtitles.
	 *
	 * @param showId  the show id to get unseen episode
	 * @param limit  the number of episode to retrieve
	 * @param user_id  retrieve unseen episode for this user
	 * @return the unseen episodes
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 * @see UnseenEpisode
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit, String user_id);
	
	/**
	 * Gets the {@code n} first unseen episodes for a given show, user and optionally 
	 * include subtitles.
	 * <p>
	 * If the specified show doesn't have unseen episode this method return an empty
	 * {@code List<UnseenEpisode>}.
	 * </p>
	 * 
	 * @param showId  the show id
	 * @param limit  the limit
	 * @param user_id  the user_id
	 * @param subtitles  the subtitles
	 * @return the list of unseen episodes
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 * @see UnseenEpisode
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit, String user_id, BSSubtitles subtitles);
	
	/**
	 * Obtains information about an episode.
	 *
	 * @param showId  the show id
	 * @param number  the show number SxxExx or the global number 
	 * @param includeSubtitles  true, include subtitles 
	 * @return the episode
	 * @throws ApiException
	 * @see Episode
	 */
	Episode search(String showId, String number, boolean includeSubtitles);
	
	/**
	 * Gets an episode by its id without subtitles.
	 *
	 * @param theTvDbId  the episode id
	 * @param includeSubtitles  true, include subtitles
	 * @return the episode
	 * @throws ApiException
	 */
	Episode getById(String episodeId);
	
	/**
	 * Gets an episode by its TV DB id without subtitles.
	 *
	 * @param theTvDbId  the episode tv db id
	 * @param includeSubtitles  true, include subtitles
	 * @return the episode
	 * @throws ApiException
	 */
	Episode getByTheTvDbId(String theTvDbId);
	
	/**
	 * Gets an episode by its {@code id} with/without subtitles.
	 *
	 * @param episodeId  the episode id
	 * @param includeSubtitles  true, include subtitles
	 * @return the episode
	 * @throws ApiException
	 */
	Episode getById(String episodeId, boolean includeSubtitles);
	
	/**
	 * Gets an episode by its TV DB id with/without subtitles.
	 *
	 * @param theTvDbId  the episode tv db id
	 * @param includeSubtitles  true, include subtitles
	 * @return the episode
	 * @throws ApiException 
	 */
	Episode getByTheTvDbId(String theTvDbId, boolean includeSubtitles);
	
	/**
	 * Mark an episode as downloaded.
	 *
	 * @param episodeId  the episode id to mark as downloaded
	 * @return the marked episode
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 */
	Episode markAsDownloaded(String episodeId);
	
	/**
	 * Unmark an episode as downloaded.
	 *
	 * @param episodeId  the episode id to remove the downloaded flag
	 * @return the marked episode
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 */
	Episode unmarkAsDownloaded(String episodeId);
	
	/**
	 * Mark an episode as watched.
	 *
	 * @param episodeId  the episode id to mark as watch
	 * @return the marked episode
	 * @throws ApiException 
	 * @throws MissingAuthorizationException
	 */
	Episode markAsWatched(String episodeId);
	
	/**
	 * Un mark an episode as watched.
	 *
	 * @param episodeId  the episode id to mark as unwatch
	 * @return the marked episode
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 */
	Episode unMarkAsWatched(String episodeId);
	
	/**
	 * Rate the specified episode.
	 *
	 * @param episodeId  the episode id to rate
	 * @param note  the note
	 * @return the rated episode
	 * @throws ApiException, MissingAuthorizationException
	 */
	Episode rateEpisode(String episodeId, int note);
	
	/**
	 * Un rate the specified episode.
	 *
	 * @param episodeId  the episode id to unrate
	 * @return the unrated episode
	 * @throws ApiException
	 * @throws MissingAuthorizationException
	 */
	Episode unRateEpisode(String episodeId);
	
	
}
