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

/**
 * Represents an instance of {@code UnseenEpisode}.
 * <p>
 * This class is derived subset of {@code Episode} describing an unseen episode. 
 * </p>
 *
 * @author Guillaume Maka
 */
public class UnseenEpisode extends BetaSeriesObject {
	
	/** The show id. */
	private final int showId;
	
	/** The show tv db id. */
	private final int theTvDbId;
	
	/** The show title. */
	private final String title;
	
	/** The show remaining episode to see. */
	private final int remaining;
	
	/** The unseen episodes. */
	private final List<Episode> episodes;
	
	/**
	 * Instantiates a new {@code UnseenEpisode}.
	 *
	 * @param showId  the show id
	 * @param theTvDbId  the show the tv db id
	 * @param title  the show title
	 * @param remaining  the show remaining episode to see
	 * @param episodes  the unseen episodes
	 * @see Episode
	 */
	public UnseenEpisode(int showId, int theTvDbId, String title,
			int remaining, List<Episode> episodes) {
		super();
		this.showId = showId;
		this.theTvDbId = theTvDbId;
		this.title = title;
		this.remaining = remaining;
		this.episodes = episodes;
	}
	
	/**
	 * Gets the show id.
	 *
	 * @return the show id
	 */
	public int getShowId() {
		return showId;
	}
	
	/**
	 * Gets the show tv db id.
	 *
	 * @return the show tv db id
	 */
	public int getTheTvDbId() {
		return theTvDbId;
	}
	
	/**
	 * Gets the show title.
	 *
	 * @return the show title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Gets the show remaining episode to see.
	 *
	 * @return the show remaining episode to see.
	 */
	public int getRemaining() {
		return remaining;
	}
	
	/**
	 * Gets the unseen episodes.
	 *
	 * @return the unseen episodes
	 */
	public List<Episode> getEpisodes() {
		return episodes;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((episodes == null) ? 0 : episodes.hashCode());
		result = prime * result + remaining;
		result = prime * result + showId;
		result = prime * result + theTvDbId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof UnseenEpisode))
			return false;
		UnseenEpisode other = (UnseenEpisode) obj;
		if (episodes == null) {
			if (other.episodes != null)
				return false;
		} else if (!episodes.equals(other.episodes))
			return false;
		if (remaining != other.remaining)
			return false;
		if (showId != other.showId)
			return false;
		if (theTvDbId != other.theTvDbId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnseenEpisode [showId=").append(showId)
				.append(", theTvDbId=").append(theTvDbId).append(", title=")
				.append(title).append(", remaining=").append(remaining)
				.append(", episodes=").append(episodes).append("]");
		return builder.toString();
	}

	
}
