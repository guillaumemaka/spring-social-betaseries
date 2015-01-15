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
package org.springframework.social.betaseries.api;

import java.util.Date;
import java.util.List;

/**
 * The Interface ShowOperations.
 * 
 * @author Guillaume Maka
 */
public interface ShowOperations {
	Show archive(int showId);	
	Show unarchive(int showId);
	List<Character> getCharacters(int showId);
	Show getShow(int showId);
	List<Show> getShows(String... showIds);
	List<Episode> getShowEpisodes(int showId);
	List<Episode> getShowEpisodes(int showId, int seasonNumber);
	List<Episode> getShowEpisodes(int showId, int seasonNumber, int episodeNumber);
	List<Episode> getShowEpisodes(int showId, int seasonNumber, int episodeNumber, boolean includeSubtitles);
	Show addToFavorite(int showId);
	Show removeFromFavorite(int showId);
	List<Show> getFavoritesShow();
	List<Show> getFavoritesShow(Long memberId);
	List<Show> list();
	List<Show> list(BSShowOrder order);
	List<Show> list(BSShowOrder order, Date sinceDate);
	List<Show> rateShow(int showId, int note);
	List<Show> unRateShow(int showId);
	List<Picture> getShowPictures(int showId);
	List<Show> getRandomShow();
	List<Show> getRandomShow(int limit);
	List<Show> getRandomShow(int limit, boolean summary);
	Recommendation sendRecommendation(int showId, int toMemberId);
	Recommendation sendRecommendation(int showId, int toMemberId, String comments);
	List<Recommendation> getRecommendations();
	Recommendation deleteRecomendation(int recomendationId);
	List<Show> search(String title);
	List<Show> search(String title, BSSearchOrder order);
	List<Show> search(String title, BSSearchOrder order, int nbpp);
	List<Show> search(String title, BSSearchOrder order, int nbpp, int page);
	List<Show> search(String title, BSSearchOrder order, int nbpp, int page, boolean summary);
	List<SimilarShow> getSimilarsShow(int showId);
	Show addShowTagsShow(int showId, String... tags);
	List<Video> getShowVideos(int showId);
	Show addShow(int showId);
	Show addShow(int showId, int lastSeenEpisodeId);
	List<Show> addShows(String[] showIds);
	List<Show> addShows(String[] showIds, String[] lastSeenEpisodeIds);
	Show removeShow(int showId);
	Show removeShow(int showId, int lastSeenEpisodeId);
	List<Show> removeShows(String[] showIds);
	List<Show> removeShows(String[] showIds, String[] lastSeenEpisodeIds);
}
