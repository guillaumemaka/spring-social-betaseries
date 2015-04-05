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

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Movie.
 * 
 * @author Guillaume Maka
 */
public class Movie extends BetaSeriesObject {

	/** The id. */
	private final Integer id;

	/** The titlw. */
	private final String titlw;

	/** The original titlw. */
	private final String originalTitlw;

	/** The movie db id. */
	private final int theMovieDbId;

	/** The im db id. */
	private final String imDbId;

	/** The url. */
	private final String url;

	/** The poster url. */
	private final String posterUrl;

	/** The production year. */
	private final String productionYear;

	/** The release date. */
	private final Date releaseDate;

	/** The sale date. */
	private final Date saleDate;

	/** The director. */
	private final String director;

	/** The length. */
	private final String length;

	/** The genres. */
	private final String[] genres;

	/** The synopsis. */
	private final String synopsis;

	/** The language. */
	private final String language;

	/** The note. */
	private final Note note;

	/** The followers. */
	private final int followers;
	
	/** The user detail. */
	private final UserDetail userDetail;

	/**
	 * Instantiates a new movie.
	 *
	 * @param id the id
	 * @param titlw the titlw
	 * @param originalTitlw the original titlw
	 * @param theMovieDbId the the movie db id
	 * @param imDbId the im db id
	 * @param url the url
	 * @param posterUrl the poster url
	 * @param productionYear the production year
	 * @param releaseDate the release date
	 * @param saleDate the sale date
	 * @param director the director
	 * @param length the length
	 * @param genres the genres
	 * @param synopsis the synopsis
	 * @param language the language
	 * @param note the note
	 * @param followers the followers
	 * @param userDetail the user detail
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the titlw.
	 *
	 * @return the titlw
	 */
	public String getTitlw() {
		return titlw;
	}

	/**
	 * Gets the original titlw.
	 *
	 * @return the originalTitlw
	 */
	public String getOriginalTitlw() {
		return originalTitlw;
	}

	/**
	 * Gets the the movie db id.
	 *
	 * @return the theMovieDbId
	 */
	public int getTheMovieDbId() {
		return theMovieDbId;
	}

	/**
	 * Gets the im db id.
	 *
	 * @return the imDbId
	 */
	public String getImDbId() {
		return imDbId;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the poster url.
	 *
	 * @return the posterUrl
	 */
	public String getPosterUrl() {
		return posterUrl;
	}

	/**
	 * Gets the production year.
	 *
	 * @return the productionYear
	 */
	public String getProductionYear() {
		return productionYear;
	}

	/**
	 * Gets the release date.
	 *
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Gets the sale date.
	 *
	 * @return the saleDate
	 */
	public Date getSaleDate() {
		return saleDate;
	}

	/**
	 * Gets the director.
	 *
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public String getLength() {
		return length;
	}

	/**
	 * Gets the genres.
	 *
	 * @return the genres
	 */
	public String[] getGenres() {
		return genres;
	}

	/**
	 * Gets the synopsis.
	 *
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Gets the note.
	 *
	 * @return the note
	 */
	public Note getNote() {
		return note;
	}

	/**
	 * Gets the followers.
	 *
	 * @return the followers
	 */
	public int getFollowers() {
		return followers;
	}

	/**
	 * Gets the user detail.
	 *
	 * @return the userDetail
	 */
	public UserDetail getUserDetail() {
		return userDetail;
	}

	/**
	 * The Class UserDetail.
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
		 * @param inAccount the in account
		 * @param status the status
		 */
		public UserDetail(boolean inAccount, BSMovieUserState status) {
			super();
			this.inAccount = inAccount;
			this.status = status;
		}

		/**
		 * Checks if is in account.
		 *
		 * @return the inAccount
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
	 * The Class SummarizedMovie.
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
		 * @param id the id
		 * @param title the title
		 * @param tmdbId the tmdb id
		 * @param imdbId the imdb id
		 * @param followers the followers
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
		 * @return the tmdbId
		 */
		public String getTmdbId() {
			return tmdbId;
		}

		/**
		 * Gets the imdb id.
		 *
		 * @return the imdbId
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
