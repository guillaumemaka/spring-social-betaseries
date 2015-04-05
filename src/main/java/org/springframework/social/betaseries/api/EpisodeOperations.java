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
 * The Interface EpisodeOperations.
 * 
 * @author Guillaume Maka
 */
public interface EpisodeOperations {
	
	
	
	/**
	 * Gets the by ids.
	 * 
	 * @param episodeIds
	 *            the BetaSerie episode object ids
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
	 *            the BetaSerie episode object ids
	 * @param includeSubtitles
	 *            the subtitles {@link BSSubtitles}
	 * @return the by ids
	 */
	List<Episode> getByIds(String[] episodeIds, boolean includeSubtitles);
	
	/**
	 * Gets the by tv db ids.
	 * 
	 * @param theTvDbIds
	 *            the the tv db ids
	 * @param includeSubtitles
	 *            the subtitles {@link BSSubtitles}
	 * @return the by tv db ids
	 */
	List<Episode> getByTvDbIds(String[] theTvDbIds, boolean includeSubtitles);
	
	/**
	 * Gets all episodes to be watch.
	 * 
	 * @return a collection of {@link Episode}
	 */
	List<UnseenEpisode> getEpisodesToBeWatch();
	
	/**
	 * Gets the episodes to be watch for a specific show.
	 * 
	 * @param showId
	 *            the show id
	 * @return a collection of {@link Episode}
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId);
	
	/**
	 * Gets (N) episodes to be watch for a specific show.
	 * 
	 * @param showId
	 *            the show id
	 * @param limit
	 *            the limit
	 * @return a collection of {@link Episode}
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit);
	
	/**
	 * Gets (N) the episodes to be watch. for a specific show and a given user
	 * 
	 * @param showId
	 *            the show id
	 * @param limit
	 *            the limit
	 * @param user_id
	 *            the user_id
	 * @return a collection of {@link Episode}
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit, String user_id);
	
	/**
	 * Gets (N) the episodes to be watch. for a specific show and a given user, including subtitles
	 * 
	 * @param showId
	 *            the show id
	 * @param limit
	 *            the limit
	 * @param user_id
	 *            the user_id
	 * @param subtitles
	 *            the subtitles {@link BSSubtitles} if specified return subtitle in the result set
	 * @return a collection of {@link Episode}
	 */
	List<UnseenEpisode> getEpisodesToBeWatch(String showId, int limit, String user_id, BSSubtitles subtitles);
	
	/**
	 * Search .
	 * 
	 * @param showId
	 *            the show id
	 * @param number
	 *            the show number SXXEXX e.g: S01E01
	 * @param includeSubtitles
	 *            the subtitles
	 * @return a collection of {@link Episode}
	 */
	Episode search(String showId, String number, boolean includeSubtitles);
	
	/**
	 * Gets the by id.
	 * 
	 * @param episodeId
	 *            the BetaSerie episode object id
	 * @return the by id
	 */
	Episode getById(String episodeId);
	
	/**
	 * Get an episode by the tv db id.
	 * 
	 * @param theTvDbId
	 *            the the tv db id
	 * @return the by the tv db id
	 */
	Episode getByTheTvDbId(String theTvDbId);
	
	/**
	 * Gets episode by id.
	 * 
	 * @param episodeId
	 *            the BetaSerie episode object id
	 * @param includeSubtitles 
	 *            the subtitles {@link BSSubtitles}
	 * @return the by id
	 */
	Episode getById(String episodeId, boolean includeSubtitles);
	
	/**
	 * Get an episode by the tv db id.
	 * 
	 * @param theTvDbId
	 *            the tv db id
	 * @param includeSubtitles
	 *            the subtitles {@link BSSubtitles}
	 * @return {@link Episode}
	 */
	Episode getByTheTvDbId(String theTvDbId, boolean includeSubtitles);
	
	/**
	 * Mark as downloaded.
	 * 
	 * @param episodeId
	 *            an episode {@link Episode}
	 * @return TODO
	 */
	Episode markAsDownloaded(String episodeId);
	
	/**
	 * Unmark as downloaded.
	 * 
	 * @param episodeId
	 *            an episode {@link Episode}
	 * @return TODO
	 */
	Episode unmarkAsDownloaded(String episodeId);
	
	/**
	 * Mark as watched.
	 * 
	 * @param episodeId
	 *            the an episode
	 * @return TODO
	 */
	Episode markAsWatched(String episodeId);
	
	/**
	 * Un mark as watched.
	 * 
	 * @param episodeId
	 *            the an episode
	 * @return TODO
	 */
	Episode unMarkAsWatched(String episodeId);
	
	/**
	 * Rate episode.
	 *
	 * @param episodeId            the an episode
	 * @param note the note
	 * @return TODO
	 */
	Episode rateEpisode(String episodeId, int note);
	
	/**
	 * Un rate episode.
	 * 
	 * @param episodeId
	 *            the an episode
	 * @return TODO
	 */
	Episode unRateEpisode(String episodeId);
	
	
}
