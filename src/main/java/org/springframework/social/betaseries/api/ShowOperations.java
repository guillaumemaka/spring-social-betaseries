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

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface ShowOperations.
 * 
 * @author Guillaume Maka
 */
public interface ShowOperations {
	
	/**
	 * Archive.
	 *
	 * @param showId the show id
	 * @return the show
	 */
	Show archive(int showId);	
	
	/**
	 * Unarchive.
	 *
	 * @param showId the show id
	 * @return the show
	 */
	Show unarchive(int showId);
	
	/**
	 * Gets the characters.
	 *
	 * @param showId the show id
	 * @return the characters
	 */
	List<Character> getCharacters(int showId);
	
	/**
	 * Gets the show.
	 *
	 * @param showId the show id
	 * @return the show
	 */
	Show getShow(int showId);
	
	/**
	 * Gets the shows.
	 *
	 * @param showIds the show ids
	 * @return the shows
	 */
	List<Show> getShows(String... showIds);
	
	/**
	 * Gets the show episodes.
	 *
	 * @param showId the show id
	 * @return the show episodes
	 */
	List<Episode> getShowEpisodes(int showId);
	
	/**
	 * Gets the show episodes.
	 *
	 * @param showId the show id
	 * @param seasonNumber the season number
	 * @return the show episodes
	 */
	List<Episode> getShowEpisodes(int showId, int seasonNumber);
	
	/**
	 * Gets the show episodes.
	 *
	 * @param showId the show id
	 * @param seasonNumber the season number
	 * @param episodeNumber the episode number
	 * @return the show episodes
	 */
	List<Episode> getShowEpisodes(int showId, int seasonNumber, int episodeNumber);
	
	/**
	 * Gets the show episodes.
	 *
	 * @param showId the show id
	 * @param seasonNumber the season number
	 * @param episodeNumber the episode number
	 * @param includeSubtitles the include subtitles
	 * @return the show episodes
	 */
	List<Episode> getShowEpisodes(int showId, int seasonNumber, int episodeNumber, boolean includeSubtitles);
	
	/**
	 * Adds the to favorite.
	 *
	 * @param showId the show id
	 * @return the show
	 */
	Show addToFavorite(int showId);
	
	/**
	 * Removes the from favorite.
	 *
	 * @param showId the show id
	 * @return the show
	 */
	Show removeFromFavorite(int showId);
	
	/**
	 * Gets the favorites show.
	 *
	 * @return the favorites show
	 */
	List<Show> getFavoritesShow();
	
	/**
	 * Gets the favorites show.
	 *
	 * @param memberId the member id
	 * @return the favorites show
	 */
	List<Show> getFavoritesShow(Long memberId);
	
	/**
	 * List.
	 *
	 * @return the list
	 */
	List<Show> list();
	
	/**
	 * List.
	 *
	 * @param order the order
	 * @return the list
	 */
	List<Show> list(BSShowOrder order);
	
	/**
	 * List.
	 *
	 * @param order the order
	 * @param sinceDate the since date
	 * @return the list
	 */
	List<Show> list(BSShowOrder order, Date sinceDate);
	
	/**
	 * Rate show.
	 *
	 * @param showId the show id
	 * @param note the note
	 * @return the list
	 */
	List<Show> rateShow(int showId, int note);
	
	/**
	 * Un rate show.
	 *
	 * @param showId the show id
	 * @return the list
	 */
	List<Show> unRateShow(int showId);
	
	/**
	 * Gets the show pictures.
	 *
	 * @param showId the show id
	 * @return the show pictures
	 */
	List<Picture> getShowPictures(int showId);
	
	/**
	 * Gets the random show.
	 *
	 * @return the random show
	 */
	List<Show> getRandomShow();
	
	/**
	 * Gets the random show.
	 *
	 * @param limit the limit
	 * @return the random show
	 */
	List<Show> getRandomShow(int limit);
	
	/**
	 * Gets the random show.
	 *
	 * @param limit the limit
	 * @param summary the summary
	 * @return the random show
	 */
	List<Show> getRandomShow(int limit, boolean summary);
	
	/**
	 * Send recommendation.
	 *
	 * @param showId the show id
	 * @param toMemberId the to member id
	 * @return the recommendation
	 */
	Recommendation sendRecommendation(int showId, int toMemberId);
	
	/**
	 * Send recommendation.
	 *
	 * @param showId the show id
	 * @param toMemberId the to member id
	 * @param comments the comments
	 * @return the recommendation
	 */
	Recommendation sendRecommendation(int showId, int toMemberId, String comments);
	
	/**
	 * Gets the recommendations.
	 *
	 * @return the recommendations
	 */
	List<Recommendation> getRecommendations();
	
	/**
	 * Delete recomendation.
	 *
	 * @param recomendationId the recomendation id
	 * @return the recommendation
	 */
	Recommendation deleteRecomendation(int recomendationId);
	
	/**
	 * Search.
	 *
	 * @param title the title
	 * @return the list
	 */
	List<Show> search(String title);
	
	/**
	 * Search.
	 *
	 * @param title the title
	 * @param order the order
	 * @return the list
	 */
	List<Show> search(String title, BSSearchOrder order);
	
	/**
	 * Search.
	 *
	 * @param title the title
	 * @param order the order
	 * @param nbpp the nbpp
	 * @return the list
	 */
	List<Show> search(String title, BSSearchOrder order, int nbpp);
	
	/**
	 * Search.
	 *
	 * @param title the title
	 * @param order the order
	 * @param nbpp the nbpp
	 * @param page the page
	 * @return the list
	 */
	List<Show> search(String title, BSSearchOrder order, int nbpp, int page);
	
	/**
	 * Search.
	 *
	 * @param title the title
	 * @param order the order
	 * @param nbpp the nbpp
	 * @param page the page
	 * @param summary the summary
	 * @return the list
	 */
	List<Show> search(String title, BSSearchOrder order, int nbpp, int page, boolean summary);
	
	/**
	 * Gets the similars show.
	 *
	 * @param showId the show id
	 * @return the similars show
	 */
	List<SimilarShow> getSimilarsShow(int showId);
	
	/**
	 * Adds the show tags show.
	 *
	 * @param showId the show id
	 * @param tags the tags
	 * @return the show
	 */
	Show addShowTagsShow(int showId, String... tags);
	
	/**
	 * Gets the show videos.
	 *
	 * @param showId the show id
	 * @return the show videos
	 */
	List<Video> getShowVideos(int showId);
	
	/**
	 * Adds the show.
	 *
	 * @param showId the show id
	 * @return the show
	 */
	Show addShow(int showId);
	
	/**
	 * Adds the show.
	 *
	 * @param showId the show id
	 * @param lastSeenEpisodeId the last seen episode id
	 * @return the show
	 */
	Show addShow(int showId, int lastSeenEpisodeId);
	
	/**
	 * Adds the shows.
	 *
	 * @param showIds the show ids
	 * @return the list
	 */
	List<Show> addShows(String[] showIds);
	
	/**
	 * Adds the shows.
	 *
	 * @param showIds the show ids
	 * @param lastSeenEpisodeIds the last seen episode ids
	 * @return the list
	 */
	List<Show> addShows(String[] showIds, String[] lastSeenEpisodeIds);
	
	/**
	 * Removes the show.
	 *
	 * @param showId the show id
	 * @return the show
	 */
	Show removeShow(int showId);
	
	/**
	 * Removes the show.
	 *
	 * @param showId the show id
	 * @param lastSeenEpisodeId the last seen episode id
	 * @return the show
	 */
	Show removeShow(int showId, int lastSeenEpisodeId);
	
	/**
	 * Removes the shows.
	 *
	 * @param showIds the show ids
	 * @return the list
	 */
	List<Show> removeShows(String[] showIds);
	
	/**
	 * Removes the shows.
	 *
	 * @param showIds the show ids
	 * @param lastSeenEpisodeIds the last seen episode ids
	 * @return the list
	 */
	List<Show> removeShows(String[] showIds, String[] lastSeenEpisodeIds);
}
