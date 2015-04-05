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
 * The Class MemberStats.
 * 
 * @author Guillaume Maka
 */
public class MemberStats extends BetaSeriesObject {
	
	/** The number of friends. */
	private int numberOfFriends;
	
	/** The number of shows. */
	private int numberOfShows;
	
	/** The number of seasons. */
	private int numberOfSeasons;
	
	/** The number of episodes. */
	private int numberOfEpisodes;
	
	/** The number of comments. */
	private int numberOfComments;
	
	/** The progress. */
	private double progress;
	
	/** The episodes to watch. */
	private int episodesToWatch;
	
	/** The time on tv. */
	private int timeOnTv;
	
	/** The time to spend. */
	private int timeToSpend;
	
	/** The badges. */
	private int badges;

	/**
	 * Instantiates a new member stats.
	 */
	public MemberStats() {}
	
	/**
	 * Instantiates a new member stats.
	 * 
	 * @param numberOfFriends
	 *            the number of friends
	 * @param numberOfShows
	 *            the number of shows
	 * @param numberOfSeasons
	 *            the number of seasons
	 * @param numberOfEpisodes
	 *            the number of episodes
	 * @param numberOfComments
	 *            the number of comments
	 * @param progress
	 *            the progress
	 * @param episodesToWatch
	 *            the episodes to watch
	 * @param timeOnTv
	 *            the time on tv
	 * @param timeToSpend
	 *            the time to spend
	 * @param badges
	 *            the badges
	 */
	public MemberStats(int numberOfFriends, int numberOfShows,
			int numberOfSeasons, int numberOfEpisodes, int numberOfComments,
			double progress, int episodesToWatch, int timeOnTv, int timeToSpend,
			int badges) {
		super();
		this.numberOfFriends = numberOfFriends;
		this.numberOfShows = numberOfShows;
		this.numberOfSeasons = numberOfSeasons;
		this.numberOfEpisodes = numberOfEpisodes;
		this.numberOfComments = numberOfComments;
		this.progress = progress;
		this.episodesToWatch = episodesToWatch;
		this.timeOnTv = timeOnTv;
		this.timeToSpend = timeToSpend;
		this.badges = badges;
	}

	/**
	 * Gets the number of friends.
	 * 
	 * @return the number of friends
	 */
	public int getNumberOfFriends() {
		return numberOfFriends;
	}

	/**
	 * Sets the number of friends.
	 * 
	 * @param numberOfFriends
	 *            the new number of friends
	 */
	public void setNumberOfFriends(int numberOfFriends) {
		this.numberOfFriends = numberOfFriends;
	}

	/**
	 * Gets the number of shows.
	 * 
	 * @return the number of shows
	 */
	public int getNumberOfShows() {
		return numberOfShows;
	}

	/**
	 * Sets the number of shows.
	 * 
	 * @param numberOfShows
	 *            the new number of shows
	 */
	public void setNumberOfShows(int numberOfShows) {
		this.numberOfShows = numberOfShows;
	}

	/**
	 * Gets the number of seasons.
	 * 
	 * @return the number of seasons
	 */
	public int getNumberOfSeasons() {
		return numberOfSeasons;
	}

	/**
	 * Sets the number of seasons.
	 * 
	 * @param numberOfSeasons
	 *            the new number of seasons
	 */
	public void setNumberOfSeasons(int numberOfSeasons) {
		this.numberOfSeasons = numberOfSeasons;
	}

	/**
	 * Gets the number of episodes.
	 * 
	 * @return the number of episodes
	 */
	public int getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	/**
	 * Sets the number of episodes.
	 * 
	 * @param numberOfEpisodes
	 *            the new number of episodes
	 */
	public void setNumberOfEpisodes(int numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}

	/**
	 * Gets the number of comments.
	 * 
	 * @return the number of comments
	 */
	public int getNumberOfComments() {
		return numberOfComments;
	}

	/**
	 * Sets the number of comments.
	 * 
	 * @param numberOfComments
	 *            the new number of comments
	 */
	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	/**
	 * Gets the progress.
	 * 
	 * @return the progress
	 */
	public double getProgress() {
		return progress;
	}

	/**
	 * Sets the progress.
	 * 
	 * @param progress
	 *            the new progress
	 */
	public void setProgress(double progress) {
		this.progress = progress;
	}

	/**
	 * Gets the episodes to watch.
	 * 
	 * @return the episodes to watch
	 */
	public int getEpisodesToWatch() {
		return episodesToWatch;
	}

	/**
	 * Sets the episodes to watch.
	 * 
	 * @param episodesToWatch
	 *            the new episodes to watch
	 */
	public void setEpisodesToWatch(int episodesToWatch) {
		this.episodesToWatch = episodesToWatch;
	}

	/**
	 * Gets the time on tv.
	 * 
	 * @return the time on tv
	 */
	public int getTimeOnTv() {
		return timeOnTv;
	}

	/**
	 * Sets the time on tv.
	 * 
	 * @param timeOnTv
	 *            the new time on tv
	 */
	public void setTimeOnTv(int timeOnTv) {
		this.timeOnTv = timeOnTv;
	}

	/**
	 * Gets the time to spend.
	 * 
	 * @return the time to spend
	 */
	public int getTimeToSpend() {
		return timeToSpend;
	}

	/**
	 * Sets the time to spend.
	 * 
	 * @param timeToSpend
	 *            the new time to spend
	 */
	public void setTimeToSpend(int timeToSpend) {
		this.timeToSpend = timeToSpend;
	}

	/**
	 * Gets the badges.
	 * 
	 * @return the badges
	 */
	public int getBadges() {
		return badges;
	}

	/**
	 * Sets the badges.
	 * 
	 * @param badges
	 *            the new badges
	 */
	public void setBadges(int badges) {
		this.badges = badges;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + badges;
		result = prime * result + episodesToWatch;
		result = prime * result + numberOfComments;
		result = prime * result + numberOfEpisodes;
		result = prime * result + numberOfFriends;
		result = prime * result + numberOfSeasons;
		result = prime * result + numberOfShows;
		long temp;
		temp = Double.doubleToLongBits(progress);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + timeOnTv;
		result = prime * result + timeToSpend;
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
		if (!(obj instanceof MemberStats))
			return false;
		MemberStats other = (MemberStats) obj;
		if (badges != other.badges)
			return false;
		if (episodesToWatch != other.episodesToWatch)
			return false;
		if (numberOfComments != other.numberOfComments)
			return false;
		if (numberOfEpisodes != other.numberOfEpisodes)
			return false;
		if (numberOfFriends != other.numberOfFriends)
			return false;
		if (numberOfSeasons != other.numberOfSeasons)
			return false;
		if (numberOfShows != other.numberOfShows)
			return false;
		if (Double.doubleToLongBits(progress) != Double
				.doubleToLongBits(other.progress))
			return false;
		if (timeOnTv != other.timeOnTv)
			return false;
		if (timeToSpend != other.timeToSpend)
			return false;
		return true;
	}
	
	
}
