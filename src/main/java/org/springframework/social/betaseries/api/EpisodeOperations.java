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


// TODO: Auto-generated Javadoc
/**
 * The Interface EpisodeOperations.
 *
 * @author Guillaume Maka
 */
public interface EpisodeOperations {
	
	
	
	/**
	 * Gets the by ids.
	 *
	 * @param episodeIds
	 *            the episode ids
	 * @return the by ids
	 */
	List<Episode> getByIds(String[] episodeIds);
	
	/**
	 * Gets the by tv db ids.
	 *
	 * @param theTvDbIds
	 *            the the tv db ids
	 * @return the by tv db ids
	 */
	List<Episode> getByTvDbIds(String[] theTvDbIds);
	
	/**
	 * Gets the by ids.
	 *
	 * @param episodeIds
	 *            the episode ids
	 * @param includeSubtitles
	 *            the include subtitles
	 * @return the by ids
	 */
	List<Episode> getByIds(String[] episodeIds, boolean includeSubtitles);
	
	/**
	 * Gets the by tv db ids.
	 *
	 * @param theTvDbIds
	 *            the the tv db ids
	 * @param includeSubtitles
	 *            the include subtitles
	 * @return the by tv db ids
	 */
	List<Episode> getByTvDbIds(String[] theTvDbIds, boolean includeSubtitles);
	
	/**
	 * Gets the episodes to be watch.
	 *
	 * @return the episodes to be watch
	 */
	List<UnseenEpisode> getEpisodesToBeWatch();
	
	/**
	 * Gets the episodes to be watch.
	 *
	 * @param showId
	 *            the show id
	 * @return the episodes to be watch
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId);
	
	/**
	 * Gets the episodes to be watch.
	 *
	 * @param showId
	 *            the show id
	 * @param limit
	 *            the limit
	 * @return the episodes to be watch
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit);
	
	/**
	 * Gets the episodes to be watch.
	 *
	 * @param showId
	 *            the show id
	 * @param limit
	 *            the limit
	 * @param user_id
	 *            the user_id
	 * @return the episodes to be watch
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit, String user_id);
	
	/**
	 * Gets the episodes to be watch.
	 *
	 * @param showId
	 *            the show id
	 * @param limit
	 *            the limit
	 * @param user_id
	 *            the user_id
	 * @param subtitles
	 *            the subtitles
	 * @return the episodes to be watch
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit, String user_id, BSSubtitles subtitles);
	
	/**
	 * Search.
	 *
	 * @param showId
	 *            the show id
	 * @param number
	 *            the number
	 * @param includeSubtitles
	 *            the include subtitles
	 * @return the episode
	 */
	Episode search(String showId, String number, boolean includeSubtitles);
	
	/**
	 * Gets the by id.
	 *
	 * @param episodeId
	 *            the episode id
	 * @return the by id
	 */
	Episode getById(String episodeId);
	
	/**
	 * Gets the by the tv db id.
	 *
	 * @param theTvDbId
	 *            the the tv db id
	 * @return the by the tv db id
	 */
	Episode getByTheTvDbId(String theTvDbId);
	
	/**
	 * Gets the by id.
	 *
	 * @param episodeId
	 *            the episode id
	 * @param includeSubtitles
	 *            the include subtitles
	 * @return the by id
	 */
	Episode getById(String episodeId, boolean includeSubtitles);
	
	/**
	 * Gets the by the tv db id.
	 *
	 * @param theTvDbId
	 *            the the tv db id
	 * @param includeSubtitles
	 *            the include subtitles
	 * @return the by the tv db id
	 */
	Episode getByTheTvDbId(String theTvDbId, boolean includeSubtitles);
	
	/**
	 * Mark as downloaded.
	 *
	 * @param episodeId
	 *            the episode id
	 * @return the episode
	 */
	Episode markAsDownloaded(String episodeId);
	
	/**
	 * Unmark as downloaded.
	 *
	 * @param episodeId
	 *            the episode id
	 * @return the episode
	 */
	Episode unmarkAsDownloaded(String episodeId);
	
	/**
	 * Mark as watched.
	 *
	 * @param episodeId
	 *            the episode id
	 * @return the episode
	 */
	Episode markAsWatched(String episodeId);
	
	/**
	 * Un mark as watched.
	 *
	 * @param episodeId
	 *            the episode id
	 * @return the episode
	 */
	Episode unMarkAsWatched(String episodeId);
	
	/**
	 * Rate episode.
	 *
	 * @param episodeId
	 *            the episode id
	 * @param note
	 *            the note
	 * @return the episode
	 */
	Episode rateEpisode(String episodeId, int note);
	
	/**
	 * Un rate episode.
	 *
	 * @param episodeId
	 *            the episode id
	 * @return the episode
	 */
	Episode unRateEpisode(String episodeId);
	
	
}
