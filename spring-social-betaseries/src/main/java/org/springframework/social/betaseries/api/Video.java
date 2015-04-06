package org.springframework.social.betaseries.api;

public class Video extends BetaSeriesObject {
	private final int id;
	private final int showId;
	private final String youtubeId;
	private final String youtubeUrl;
	private final String title;
	private final int season;
	private final int episode;
	private final String login;
	private final int loginId;
	/**
	 * @param id
	 * @param showId
	 * @param youtubeId
	 * @param youtubeUrl
	 * @param title
	 * @param season
	 * @param episode
	 * @param login
	 * @param loginId
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the showId
	 */
	public int getShowId() {
		return showId;
	}
	/**
	 * @return the youtubeId
	 */
	public String getYoutubeId() {
		return youtubeId;
	}
	/**
	 * @return the youtubeUrl
	 */
	public String getYoutubeUrl() {
		return youtubeUrl;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the season
	 */
	public int getSeason() {
		return season;
	}
	/**
	 * @return the episode
	 */
	public int getEpisode() {
		return episode;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @return the loginId
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
