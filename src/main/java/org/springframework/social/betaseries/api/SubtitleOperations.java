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
 * The Interface SubtitleOperations.
 *
 * @author Guillaume Maka
 */
public interface SubtitleOperations {
	
	/**
	 * Gets the subtitles for episode.
	 *
	 * @param episodeId
	 *            the episode id
	 * @return the subtitles for episode
	 */
	List<Subtitle> getSubtitlesForEpisode(int episodeId);
	
	/**
	 * Gets the subtitles for episode.
	 *
	 * @param episodeId
	 *            the episode id
	 * @param language
	 *            the language
	 * @return the subtitles for episode
	 */
	List<Subtitle> getSubtitlesForEpisode(int episodeId, BSSubtitles language);
	
	/**
	 * Gets the subtitles for show.
	 *
	 * @param showId
	 *            the show id
	 * @return the subtitles for show
	 */
	List<Subtitle> getSubtitlesForShow(int showId);
	
	/**
	 * Gets the subtitles for show.
	 *
	 * @param showId
	 *            the show id
	 * @param language
	 *            the language
	 * @return the subtitles for show
	 */
	List<Subtitle> getSubtitlesForShow(int showId, BSSubtitles language);
	
	/**
	 * Gets the last added subtitles.
	 *
	 * @return the last added subtitles
	 */
	List<Subtitle> getLastAddedSubtitles();
	
	/**
	 * Gets the last added subtitles.
	 *
	 * @param number
	 *            the number
	 * @return the last added subtitles
	 */
	List<Subtitle> getLastAddedSubtitles(int number);
	
	/**
	 * Gets the last added subtitles.
	 *
	 * @param number
	 *            the number
	 * @param language
	 *            the language
	 * @return the last added subtitles
	 */
	List<Subtitle> getLastAddedSubtitles(int number, BSSubtitles language);
	
	/**
	 * Report incorrect subtitle.
	 *
	 * @param subtitleId
	 *            the subtitle id
	 * @param reason
	 *            the reason
	 * @return the subtitle
	 */
	Subtitle reportIncorrectSubtitle(int subtitleId, String reason);
}
