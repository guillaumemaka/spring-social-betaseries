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

import java.util.List;

/**
 * Represents an instance of {@code Member}.
 * 
 * @author Guillaume Maka
 */
public class Member extends BetaSeriesObject {
	
	/** The member id. */	
	private String memberId;
	
	/** The member login. */
	private String login;
	
	/** The member experience point. */
	private int xp;
	
	/** The member avatar url. */
	private String avatarUrl;
	
	/** The member last cached timestamp */
	private int cached;
	
	/** The member flag in account. */
	private boolean inAccount;
	
	/** The member statistics {@see MemberStats}. */
	private MemberStats stats;
	
	/** The member list of show. */
	private List<Show> shows;
	
	/** The member list of movie. */
	private List<Movie> movies;
	
	/** The member account options. */
	private MemberOptions options;
	
	

	/**
	 * Construct an instance of {@code Member}.
	 */
	public Member() {
		super();
	}

	/**
	 * Gets the member id.
	 * 
	 * @return the id
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * Sets the member id.
	 * @param id the id to set
	 */
	public void setMemberId(String id) {
		this.memberId = id;
	}

	/**
	 * Gets the member login
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the member xp.
	 * 
	 * @return the xp
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * 
	 * @param xp the xp to set
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}

	/**
	 * Gets the member avatar url.
	 * 
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * Gets the member cached timestamp.
	 * 
	 * @return the cached
	 */
	public int getCached() {
		return cached;
	}

	/**
	 * @param cached the cached to set
	 */
	public void setCached(int cached) {
		this.cached = cached;
	}

	/**
	 * Gets the member in account flag.
	 * 
	 * @return the inAccount
	 */
	public boolean isInAccount() {
		return inAccount;
	}

	/**
	 * @param inAccount the inAccount to set
	 */
	public void setInAccount(boolean inAccount) {
		this.inAccount = inAccount;
	}

	/**
	 * Get the member account options.
	 * 
	 * @return the stats
	 * @see MemberStats
	 */
	public MemberStats getStats() {
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(MemberStats stats) {
		this.stats = stats;
	}

	/**
	 * Gets the member list of show
	 * 
	 * @return the shows
	 */
	public List<Show> getShows() {
		return shows;
	}

	/**
	 * 
	 * 
	 * @param shows the shows to set
	 */
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	/**
	 * Gets the member list of movie.
	 * 
	 * @return the movies
	 */
	public List<Movie> getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	/**
	 * Gets the member account options.
	 * 
	 * @return the options
	 */
	public MemberOptions getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(MemberOptions options) {
		this.options = options;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((avatarUrl == null) ? 0 : avatarUrl.hashCode());
		result = prime * result + cached;
		result = prime * result + (inAccount ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((movies == null) ? 0 : movies.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + ((shows == null) ? 0 : shows.hashCode());
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
		result = prime * result + xp;
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
		if (!(obj instanceof Member))
			return false;
		Member other = (Member) obj;
		if (avatarUrl == null) {
			if (other.avatarUrl != null)
				return false;
		} else if (!avatarUrl.equals(other.avatarUrl))
			return false;
		if (cached != other.cached)
			return false;
		if (inAccount != other.inAccount)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (movies == null) {
			if (other.movies != null)
				return false;
		} else if (!movies.equals(other.movies))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (shows == null) {
			if (other.shows != null)
				return false;
		} else if (!shows.equals(other.shows))
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		if (xp != other.xp)
			return false;
		return true;
	}
	
	
}
