package org.springframework.social.betaseries.api;

import java.util.List;

public class UnseenEpisode extends BetaSeriesObject {
	private final int showId;
	private final int theTvDbId;
	private final String title;
	private final int remaining;
	private final List<Episode> episodes;
	/**
	 * @param showId
	 * @param theTvDbId
	 * @param title
	 * @param remaining
	 * @param episodes
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
	 * @return the showId
	 */
	public int getShowId() {
		return showId;
	}
	/**
	 * @return the theTvDbId
	 */
	public int getTheTvDbId() {
		return theTvDbId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the remaining
	 */
	public int getRemaining() {
		return remaining;
	}
	/**
	 * @return the episodes
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
