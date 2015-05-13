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

/**
 * Represents an instance of {@code Video}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public class Video extends BetaSeriesObject {
	
	/** The internal id. */
	private final int id;
	
	/** The show id. */
	private final int showId;
	
	/** The youtube id. */
	private final String youtubeId;
	
	/** The youtube url. */
	private final String youtubeUrl;
	
	/** The title. */
	private final String title;
	
	/** The season. */
	private final int season;
	
	/** The episode. */
	private final int episode;
	
	/** The login. */
	private final String login;
	
	/** The login id. */
	private final int loginId;
	
	/**
	 * Instantiates a {@code Video}.
	 *
	 * @param id  the internal id
	 * @param showId  the show id
	 * @param youtubeId  the youtube id
	 * @param youtubeUrl  the youtube url
	 * @param title  the title
	 * @param season  the season
	 * @param episode  the episode
	 * @param login  the login
	 * @param loginId  the login id
	 */
	public Video(int id, int showId, String youtubeId, String youtubeUrl,
			String title, int season, int episode, String login, int loginId) {
		super();
		this.id = id;
		this.showId = showId;
		this.youtubeId = youtubeId;
		this.youtubeUrl = youtubeUrl;
		this.title = title;
		this.season = season;
		this.episode = episode;
		this.login = login;
		this.loginId = loginId;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * Gets the youtube id.
	 *
	 * @return the youtube id
	 */
	public String getYoutubeId() {
		return youtubeId;
	}
	
	/**
	 * Gets the youtube url.
	 *
	 * @return the youtube url
	 */
	public String getYoutubeUrl() {
		return youtubeUrl;
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Gets the season.
	 *
	 * @return the season
	 */
	public int getSeason() {
		return season;
	}
	
	/**
	 * Gets the episode.
	 *
	 * @return the episode
	 */
	public int getEpisode() {
		return episode;
	}
	
	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Gets the login id.
	 *
	 * @return the login id
	 */
	public int getLoginId() {
		return loginId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + episode;
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + loginId;
		result = prime * result + season;
		result = prime * result + showId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((youtubeId == null) ? 0 : youtubeId.hashCode());
		result = prime * result
				+ ((youtubeUrl == null) ? 0 : youtubeUrl.hashCode());
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
		if (!(obj instanceof Video))
			return false;
		Video other = (Video) obj;
		if (episode != other.episode)
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (loginId != other.loginId)
			return false;
		if (season != other.season)
			return false;
		if (showId != other.showId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (youtubeId == null) {
			if (other.youtubeId != null)
				return false;
		} else if (!youtubeId.equals(other.youtubeId))
			return false;
		if (youtubeUrl == null) {
			if (other.youtubeUrl != null)
				return false;
		} else if (!youtubeUrl.equals(other.youtubeUrl))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Video [id=").append(id).append(", showId=")
				.append(showId).append(", youtubeId=").append(youtubeId)
				.append(", youtubeUrl=").append(youtubeUrl).append(", title=")
				.append(title).append(", season=").append(season)
				.append(", episode=").append(episode).append(", login=")
				.append(login).append(", loginId=").append(loginId).append("]");
		return builder.toString();
	}	
}
