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
 * Represent an instance of {@code MemberStats}.
 * 
 * @author Guillaume Maka
 */
public class MemberStats extends BetaSeriesObject {
	
	/** The number of friends stats for the member. */
	private int numberOfFriends;
	
	/** The number of shows stats for the member. */
	private int numberOfShows;
	
	/** The number of seasons stats for the member. */
	private int numberOfSeasons;
	
	/** The number of episodes stats for the member. */
	private int numberOfEpisodes;
	
	/** The number of comments stats for the member. */
	private int numberOfComments;
	
	/** The progress stats for the member. */
	private double progress;
	
	/** The episodes to watch stats for the member. */
	private int episodesToWatch;
	
	/** The time on tv stats for the member. */
	private int timeOnTv;
	
	/** The time to spend stats for the member. */
	private int timeToSpend;
	
	/** The badges stats for the member. */
	private int badges;

	public MemberStats() {}
	
	/**
	 * Instantiates a new {@code MemberStats}.
	 * 
	 * @param numberOfFriends  the number of friends stats
	 * @param numberOfShows  the number of shows stats
	 * @param numberOfSeasons  the number of seasons stats
	 * @param numberOfEpisodes  the number of episodes stats
	 * @param numberOfComments  the number of comments stats
	 * @param progress  the progress stats
	 * @param episodesToWatch  the episodes to watch stats
	 * @param timeOnTv  the time on tv stats
	 * @param timeToSpend  the time to spend stats
	 * @param badges  the badges stats
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
	 * Gets the number of friends stats.
	 * 
	 * @return the number of friends
	 */
	public int getNumberOfFriends() {
		return numberOfFriends;
	}

	/**
	 * Gets the number of shows stats.
	 * 
	 * @return the number of shows
	 */
	public int getNumberOfShows() {
		return numberOfShows;
	}


	/**
	 * Gets the number of seasons stats.
	 * 
	 * @return the number of seasons
	 */
	public int getNumberOfSeasons() {
		return numberOfSeasons;
	}

	/**
	 * Gets the number of episodes stats.
	 * 
	 * @return the number of episodes
	 */
	public int getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	/**
	 * Gets the number of comments stats.
	 * 
	 * @return the number of comments
	 */
	public int getNumberOfComments() {
		return numberOfComments;
	}

	/**
	 * Gets the progress stats.
	 * 
	 * @return the progress
	 */
	public double getProgress() {
		return progress;
	}

	/**
	 * Gets the number of episodes to watch stats.
	 * 
	 * @return the number of episodes to watch
	 */
	public int getEpisodesToWatch() {
		return episodesToWatch;
	}

	/**
	 * Gets the time on tv stats.
	 * 
	 * @return the time on tv
	 */
	public int getTimeOnTv() {
		return timeOnTv;
	}

	/**
	 * Gets the time to spend stats.
	 * 
	 * @return the time to spend
	 */
	public int getTimeToSpend() {
		return timeToSpend;
	}

	/**
	 * Gets the badges stats.
	 * 
	 * @return the badges
	 */
	public int getBadges() {
		return badges;
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
