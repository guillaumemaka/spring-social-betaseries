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


/**
 * The Interface PictureOperations.
 * 
 * @author Guillaume Maka
 */
public interface PictureOperations {
	byte[] getBadgePicture(int badgeId);
	byte[] getBadgePicture(int badgeId, Integer height, Integer width);
	byte[] getCharacterPicture(int characterId);
	byte[] getCharacterPicture(int characterId, Integer height, Integer width);
	byte[] getEpisodePicture(int episodeId);
	byte[] getEpisodePicture(int episodeId, Integer height, Integer width);
	byte[] getMemberPicture(int memberId);
	byte[] getMemberPicture(int memberId, Integer height, Integer width);
	byte[] getMoviePicture(int movieId);
	byte[] getMoviePicture(int movieId, Integer height, Integer width);
	byte[] getShowPicture(int showId);
	byte[] getShowPicture(int showId, Integer height, Integer width);
}
