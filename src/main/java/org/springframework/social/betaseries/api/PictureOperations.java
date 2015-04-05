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


// TODO: Auto-generated Javadoc
/**
 * The Interface PictureOperations.
 * 
 * @author Guillaume Maka
 */
public interface PictureOperations {
	
	/**
	 * Gets the badge picture.
	 *
	 * @param badgeId the badge id
	 * @return the badge picture
	 */
	byte[] getBadgePicture(int badgeId);
	
	/**
	 * Gets the badge picture.
	 *
	 * @param badgeId the badge id
	 * @param height the height
	 * @param width the width
	 * @return the badge picture
	 */
	byte[] getBadgePicture(int badgeId, Integer height, Integer width);
	
	/**
	 * Gets the character picture.
	 *
	 * @param characterId the character id
	 * @return the character picture
	 */
	byte[] getCharacterPicture(int characterId);
	
	/**
	 * Gets the character picture.
	 *
	 * @param characterId the character id
	 * @param height the height
	 * @param width the width
	 * @return the character picture
	 */
	byte[] getCharacterPicture(int characterId, Integer height, Integer width);
	
	/**
	 * Gets the episode picture.
	 *
	 * @param episodeId the episode id
	 * @return the episode picture
	 */
	byte[] getEpisodePicture(int episodeId);
	
	/**
	 * Gets the episode picture.
	 *
	 * @param episodeId the episode id
	 * @param height the height
	 * @param width the width
	 * @return the episode picture
	 */
	byte[] getEpisodePicture(int episodeId, Integer height, Integer width);
	
	/**
	 * Gets the member picture.
	 *
	 * @param memberId the member id
	 * @return the member picture
	 */
	byte[] getMemberPicture(int memberId);
	
	/**
	 * Gets the member picture.
	 *
	 * @param memberId the member id
	 * @param height the height
	 * @param width the width
	 * @return the member picture
	 */
	byte[] getMemberPicture(int memberId, Integer height, Integer width);
	
	/**
	 * Gets the movie picture.
	 *
	 * @param movieId the movie id
	 * @return the movie picture
	 */
	byte[] getMoviePicture(int movieId);
	
	/**
	 * Gets the movie picture.
	 *
	 * @param movieId the movie id
	 * @param height the height
	 * @param width the width
	 * @return the movie picture
	 */
	byte[] getMoviePicture(int movieId, Integer height, Integer width);
	
	/**
	 * Gets the show picture.
	 *
	 * @param showId the show id
	 * @return the show picture
	 */
	byte[] getShowPicture(int showId);
	
	/**
	 * Gets the show picture.
	 *
	 * @param showId the show id
	 * @param height the height
	 * @param width the width
	 * @return the show picture
	 */
	byte[] getShowPicture(int showId, Integer height, Integer width);
}
