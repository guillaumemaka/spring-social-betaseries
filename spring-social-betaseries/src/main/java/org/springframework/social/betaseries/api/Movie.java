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

import java.util.Date;

/**
 * Represents an instance of {@code Movie}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public class Movie extends BetaSeriesObject {

	/** The movie id. */
	private final Integer id;

	/** The movie titlw. */
	private final String titlw;

	/** The original movie titlw. */
	private final String originalTitlw;

	/** The movie db id. */
	private final int theMovieDbId;

	/** The movie im db id. */
	private final String imDbId;

	/** The movie url. */
	private final String url;

	/** The movie poster url. */
	private final String posterUrl;

	/** The movie production year. */
	private final String productionYear;

	/** The movie release date. */
	private final Date releaseDate;

	/** The movie sale date. */
	private final Date saleDate;

	/** The movie director name. */
	private final String director;

	/** The movie length. */
	private final String length;

	/** The movie genres. */
	private final String[] genres;

	/** The movie synopsis. */
	private final String synopsis;

	/** The movie language. */
	private final String language;

	/** The movie note. */
	private final Note note;

	/** The number followers that follow this movie. */
	private final int followers;
	
	/** 
	 * The user info about the current user. 
	 * @see UserDetail
	 */
	private final UserDetail userDetail;

	/**
	 * Instantiates a new {@code Movie}.
	 *
	 * @param id  the movie id
	 * @param titlw  the movie titlw
	 * @param originalTitlw  the original movie titlw
	 * @param theMovieDbId  the movie db id
	 * @param imDbId  the movie im db id
	 * @param url  the movie url
	 * @param posterUrl  the movie poster url
	 * @param productionYear  the movie production year
	 * @param releaseDate  the movie release date
	 * @param saleDate  the movie sale date
	 * @param director  the movie director
	 * @param length  the movie length
	 * @param genres  the movie genres
	 * @param synopsis  the movie synopsis
	 * @param language  the movie language
	 * @param note the movie note
	 * @param followers  the number of followers for this movie
	 * @param userDetail  the user  detail for the current authenticated user
	 */
	public Movie(Integer id, String titlw, String originalTitlw,
			int theMovieDbId, String imDbId, String url, String posterUrl,
			String productionYear, Date releaseDate, Date saleDate,
			String director, String length, String[] genres, String synopsis,
			String language, Note note, int followers, UserDetail userDetail) {
		super();
		this.id = id;
		this.titlw = titlw;
		this.originalTitlw = originalTitlw;
		this.theMovieDbId = theMovieDbId;
		this.imDbId = imDbId;
		this.url = url;
		this.posterUrl = posterUrl;
		this.productionYear = productionYear;
		this.releaseDate = releaseDate;
		this.saleDate = saleDate;
		this.director = director;
		this.length = length;
		this.genres = genres;
		this.synopsis = synopsis;
		this.language = language;
		this.note = note;
		this.followers = followers;
		this.userDetail = userDetail;
	}

	/**
	 * Gets the movie id.
	 *
	 * @return the movie id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the movie titlw.
	 *
	 * @return the movie titlw
	 */
	public String getTitlw() {
		return titlw;
	}

	/**
	 * Gets the original movie titlw.
	 *
	 * @return the original movie titlw
	 */
	public String getOriginalTitlw() {
		return originalTitlw;
	}

	/**
	 * Gets the the movie db id.
	 *
	 * @return the the movie db id
	 */
	public int getTheMovieDbId() {
		return theMovieDbId;
	}

	/**
	 * Gets the movie im db id.
	 *
	 * @return the movie im db id
	 */
	public String getImDbId() {
		return imDbId;
	}

	/**
	 * Gets the movie url.
	 *
	 * @return the movie url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the movie poster url.
	 *
	 * @return the movie poster url
	 */
	public String getPosterUrl() {
		return posterUrl;
	}

	/**
	 * Gets the movie production year.
	 *
	 * @return the movie production year
	 */
	public String getProductionYear() {
		return productionYear;
	}

	/**
	 * Gets the movie release date.
	 *
	 * @return the movie release date
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Gets the movie sale date.
	 *
	 * @return the movie sale date
	 */
	public Date getSaleDate() {
		return saleDate;
	}

	/**
	 * Gets the movie director.
	 *
	 * @return the movie director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Gets the movie length.
	 *
	 * @return the movie length
	 */
	public String getLength() {
		return length;
	}

	/**
	 * Gets the movie genres.
	 *
	 * @return the movie genres
	 */
	public String[] getGenres() {
		return genres;
	}

	/**
	 * Gets the movie synopsis.
	 *
	 * @return the movie synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * Gets the movie language.
	 *
	 * @return the movie language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Gets the movie note.
	 *
 	 * @return the movie note
	 */
	public Note getNote() {
		return note;
	}

	/**
	 * Gets the number of followers for this movie.
	 *
	 * @return the number of followers
	 */
	public int getFollowers() {
		return followers;
	}

	/**
	 * Gets the user authenticated detail.
	 *
	 * @return the user detail
	 */
	public UserDetail getUserDetail() {
		return userDetail;
	}

	/**
	 * Represents an instance of {@code UserDetail}.
	 * <p>
	 * </p>
	 *
	 * @author Guillaume Maka
	 */
	static public class UserDetail extends BetaSeriesObject {
		
		/** The in account. */
		private final boolean inAccount;
		
		/** The status. */
		private final BSMovieUserState status;

		/**
		 * Instantiates a new user detail.
		 *
		 * @param inAccount
		 *            the in account
		 * @param status
		 *            the status
		 */
		public UserDetail(boolean inAccount, BSMovieUserState status) {
			super();
			this.inAccount = inAccount;
			this.status = status;
		}

		/**
		 * Checks if is in account.
		 *
		 * @return true, if is in account
		 */
		public boolean isInAccount() {
			return inAccount;
		}

		/**
		 * Gets the status.
		 *
		 * @return the status
		 */
		public BSMovieUserState getStatus() {
			return status;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + (inAccount ? 1231 : 1237);
			result = prime * result
					+ ((status == null) ? 0 : status.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (!(obj instanceof UserDetail))
				return false;
			UserDetail other = (UserDetail) obj;
			if (inAccount != other.inAccount)
				return false;
			if (status != other.status)
				return false;
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("UserDetail [inAccount=").append(inAccount)
					.append(", status=").append(status).append("]");
			return builder.toString();
		}
	}

	/**
	 * Represents an instance of {@code SummarizedMovie}.
	 * <p>
	 * </p>
	 *
	 * @author Guillaume Maka
	 */
	public static class SummarizedMovie extends BetaSeriesObject {
		
		/** The id. */
		private final Integer id;
		
		/** The title. */
		private final String title;
		
		/** The tmdb id. */
		private final String tmdbId;
		
		/** The imdb id. */
		private final String imdbId;
		
		/** The followers. */
		private final Integer followers;

		/**
		 * Instantiates a new summarized movie.
		 *
		 * @param id
		 *            the id
		 * @param title
		 *            the title
		 * @param tmdbId
		 *            the tmdb id
		 * @param imdbId
		 *            the imdb id
		 * @param followers
		 *            the followers
		 */
		public SummarizedMovie(Integer id, String title, String tmdbId,
				String imdbId, Integer followers) {
			super();
			this.id = id;
			this.title = title;
			this.tmdbId = tmdbId;
			this.imdbId = imdbId;
			this.followers = followers;
		}

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public Integer getId() {
			return id;
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
		 * Gets the tmdb id.
		 *
		 * @return the tmdb id
		 */
		public String getTmdbId() {
			return tmdbId;
		}

		/**
		 * Gets the imdb id.
		 *
		 * @return the imdb id
		 */
		public String getImdbId() {
			return imdbId;
		}

		/**
		 * Gets the followers.
		 *
		 * @return the followers
		 */
		public Integer getFollowers() {
			return followers;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result
					+ ((followers == null) ? 0 : followers.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((imdbId == null) ? 0 : imdbId.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			result = prime * result
					+ ((tmdbId == null) ? 0 : tmdbId.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (!(obj instanceof SummarizedMovie))
				return false;
			SummarizedMovie other = (SummarizedMovie) obj;
			if (followers == null) {
				if (other.followers != null)
					return false;
			} else if (!followers.equals(other.followers))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (imdbId == null) {
				if (other.imdbId != null)
					return false;
			} else if (!imdbId.equals(other.imdbId))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			if (tmdbId == null) {
				if (other.tmdbId != null)
					return false;
			} else if (!tmdbId.equals(other.tmdbId))
				return false;
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SummarizedMovie [id=").append(id)
					.append(", title=").append(title).append(", tmdbId=")
					.append(tmdbId).append(", imdbId=").append(imdbId)
					.append(", followers=").append(followers).append("]");
			return builder.toString();
		}
	}
}
