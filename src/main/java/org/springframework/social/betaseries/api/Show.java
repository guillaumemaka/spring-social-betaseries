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

import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Show.
 *
 * @author Guillaume Maka
 */
public class Show extends BetaSeriesObject {

	/** The id. */
	private int id;

	/** The tv db id. */
	private int theTvDbId;

	/** The im db id. */
	private String imDbId;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The number of seasons. */
	private String numberOfSeasons;

	/** The seasons details. */
	private List<SeasonDetail> seasonsDetails;

	/** The number of episodes. */
	private String numberOfEpisodes;

	/** The number of followers. */
	private String numberOfFollowers;

	/** The number of comments. */
	private String numberOfComments;

	/** The similars. */
	private String similars;

	/** The characters. */
	private String characters;

	/** The years of production. */
	private String yearsOfProduction;

	/** The genres. */
	private String[] genres;

	/** The episode length. */
	private String episodeLength;

	/** The network. */
	private String network;

	/** The rating. */
	private String rating;

	/** The status. */
	private String status;

	/** The language. */
	private String language;

	/** The note. */
	private Note note;

	/** The in account. */
	private boolean inAccount;

	/** The user detail. */
	private UserDetail userDetail;

	/** The resource url. */
	private String resourceUrl;

	/**
	 * Instantiates a new show.
	 *
	 * @param id
	 *            the id
	 * @param theTvDbId
	 *            the the tv db id
	 * @param imDbId
	 *            the im db id
	 * @param title
	 *            the title
	 * @param description
	 *            the description
	 * @param seasons
	 *            the seasons
	 */
	public Show(int id, int theTvDbId, String imDbId, String title,
			String description, String seasons) {
		super();
		this.id = id;
		this.theTvDbId = theTvDbId;
		this.imDbId = imDbId;
		this.title = title;
		this.description = description;
		this.numberOfSeasons = seasons;
	}

	/**
	 * Instantiates a new show.
	 */
	public Show() {
		super();
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
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the the tv db id.
	 *
	 * @return the the tv db id
	 */
	public int getTheTvDbId() {
		return theTvDbId;
	}

	/**
	 * Sets the the tv db id.
	 *
	 * @param theTvDbId
	 *            the new the tv db id
	 */
	public void setTheTvDbId(int theTvDbId) {
		this.theTvDbId = theTvDbId;
	}

	/**
	 * Gets the im db id.
	 *
	 * @return the im db id
	 */
	public String getImDbId() {
		return imDbId;
	}

	/**
	 * Sets the im db id.
	 *
	 * @param imDbId
	 *            the new im db id
	 */
	public void setImDbId(String imDbId) {
		this.imDbId = imDbId;
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
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the number of seasons.
	 *
	 * @return the number of seasons
	 */
	public String getNumberOfSeasons() {
		return numberOfSeasons;
	}

	/**
	 * Sets the number of seasons.
	 *
	 * @param numberOfSeasons
	 *            the new number of seasons
	 */
	public void setNumberOfSeasons(String numberOfSeasons) {
		this.numberOfSeasons = numberOfSeasons;
	}

	/**
	 * Gets the seasons details.
	 *
	 * @return the seasons details
	 */
	public List<SeasonDetail> getSeasonsDetails() {
		return seasonsDetails;
	}

	/**
	 * Sets the seasons details.
	 *
	 * @param seasonsDetails
	 *            the new seasons details
	 */
	public void setSeasonsDetails(List<SeasonDetail> seasonsDetails) {
		this.seasonsDetails = seasonsDetails;
	}

	/**
	 * Gets the number of episodes.
	 *
	 * @return the number of episodes
	 */
	public String getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	/**
	 * Sets the number of episodes.
	 *
	 * @param numberOfEpisodes
	 *            the new number of episodes
	 */
	public void setNumberOfEpisodes(String numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}

	/**
	 * Gets the number of followers.
	 *
	 * @return the number of followers
	 */
	public String getNumberOfFollowers() {
		return numberOfFollowers;
	}

	/**
	 * Sets the number of followers.
	 *
	 * @param numberOfFollowers
	 *            the new number of followers
	 */
	public void setNumberOfFollowers(String numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}

	/**
	 * Gets the number of comments.
	 *
	 * @return the number of comments
	 */
	public String getNumberOfComments() {
		return numberOfComments;
	}

	/**
	 * Sets the number of comments.
	 *
	 * @param numberOfComments
	 *            the new number of comments
	 */
	public void setNumberOfComments(String numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	/**
	 * Gets the similars.
	 *
	 * @return the similars
	 */
	public String getSimilars() {
		return similars;
	}

	/**
	 * Sets the similars.
	 *
	 * @param similars
	 *            the new similars
	 */
	public void setSimilars(String similars) {
		this.similars = similars;
	}

	/**
	 * Gets the characters.
	 *
	 * @return the characters
	 */
	public String getCharacters() {
		return characters;
	}

	/**
	 * Sets the characters.
	 *
	 * @param characters
	 *            the new characters
	 */
	public void setCharacters(String characters) {
		this.characters = characters;
	}

	/**
	 * Gets the years of production.
	 *
	 * @return the years of production
	 */
	public String getYearsOfProduction() {
		return yearsOfProduction;
	}

	/**
	 * Sets the years of production.
	 *
	 * @param yearsOfProduction
	 *            the new years of production
	 */
	public void setYearsOfProduction(String yearsOfProduction) {
		this.yearsOfProduction = yearsOfProduction;
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
	 * Sets the genres.
	 *
	 * @param genres
	 *            the new genres
	 */
	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	/**
	 * Gets the episode length.
	 *
	 * @return the episode length
	 */
	public String getEpisodeLength() {
		return episodeLength;
	}

	/**
	 * Sets the episode length.
	 *
	 * @param episodeLength
	 *            the new episode length
	 */
	public void setEpisodeLength(String episodeLength) {
		this.episodeLength = episodeLength;
	}

	/**
	 * Gets the network.
	 *
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * Sets the network.
	 *
	 * @param network
	 *            the new network
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating
	 *            the new rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * Sets the language.
	 *
	 * @param language
	 *            the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
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
	 * Sets the note.
	 *
	 * @param notes
	 *            the new note
	 */
	public void setNote(Note notes) {
		this.note = notes;
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
	 * Sets the in account.
	 *
	 * @param inAccount
	 *            the new in account
	 */
	public void setInAccount(boolean inAccount) {
		this.inAccount = inAccount;
	}

	/**
	 * Gets the user detail.
	 *
	 * @return the user detail
	 */
	public UserDetail getUserDetail() {
		return userDetail;
	}

	/**
	 * Sets the user.
	 *
	 * @param user
	 *            the new user
	 */
	public void setUser(UserDetail user) {
		this.userDetail = user;
	}

	/**
	 * Gets the resource url.
	 *
	 * @return the resource url
	 */
	public String getResourceUrl() {
		return resourceUrl;
	}

	/**
	 * Sets the resource url.
	 *
	 * @param resourceUrl
	 *            the new resource url
	 */
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((characters == null) ? 0 : characters.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((episodeLength == null) ? 0 : episodeLength.hashCode());
		result = prime * result + Arrays.hashCode(genres);
		result = prime * result + id;
		result = prime * result + ((imDbId == null) ? 0 : imDbId.hashCode());
		result = prime * result + (inAccount ? 1231 : 1237);
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((network == null) ? 0 : network.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime
				* result
				+ ((numberOfComments == null) ? 0 : numberOfComments.hashCode());
		result = prime
				* result
				+ ((numberOfEpisodes == null) ? 0 : numberOfEpisodes.hashCode());
		result = prime
				* result
				+ ((numberOfFollowers == null) ? 0 : numberOfFollowers
						.hashCode());
		result = prime * result
				+ ((numberOfSeasons == null) ? 0 : numberOfSeasons.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result
				+ ((resourceUrl == null) ? 0 : resourceUrl.hashCode());
		result = prime * result
				+ ((seasonsDetails == null) ? 0 : seasonsDetails.hashCode());
		result = prime * result
				+ ((similars == null) ? 0 : similars.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + theTvDbId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((userDetail == null) ? 0 : userDetail.hashCode());
		result = prime
				* result
				+ ((yearsOfProduction == null) ? 0 : yearsOfProduction
						.hashCode());
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
		if (!(obj instanceof Show))
			return false;
		Show other = (Show) obj;
		if (characters == null) {
			if (other.characters != null)
				return false;
		} else if (!characters.equals(other.characters))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (episodeLength == null) {
			if (other.episodeLength != null)
				return false;
		} else if (!episodeLength.equals(other.episodeLength))
			return false;
		if (!Arrays.equals(genres, other.genres))
			return false;
		if (id != other.id)
			return false;
		if (imDbId == null) {
			if (other.imDbId != null)
				return false;
		} else if (!imDbId.equals(other.imDbId))
			return false;
		if (inAccount != other.inAccount)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (network == null) {
			if (other.network != null)
				return false;
		} else if (!network.equals(other.network))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (numberOfComments == null) {
			if (other.numberOfComments != null)
				return false;
		} else if (!numberOfComments.equals(other.numberOfComments))
			return false;
		if (numberOfEpisodes == null) {
			if (other.numberOfEpisodes != null)
				return false;
		} else if (!numberOfEpisodes.equals(other.numberOfEpisodes))
			return false;
		if (numberOfFollowers == null) {
			if (other.numberOfFollowers != null)
				return false;
		} else if (!numberOfFollowers.equals(other.numberOfFollowers))
			return false;
		if (numberOfSeasons == null) {
			if (other.numberOfSeasons != null)
				return false;
		} else if (!numberOfSeasons.equals(other.numberOfSeasons))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (resourceUrl == null) {
			if (other.resourceUrl != null)
				return false;
		} else if (!resourceUrl.equals(other.resourceUrl))
			return false;
		if (seasonsDetails == null) {
			if (other.seasonsDetails != null)
				return false;
		} else if (!seasonsDetails.equals(other.seasonsDetails))
			return false;
		if (similars == null) {
			if (other.similars != null)
				return false;
		} else if (!similars.equals(other.similars))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (theTvDbId != other.theTvDbId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userDetail == null) {
			if (other.userDetail != null)
				return false;
		} else if (!userDetail.equals(other.userDetail))
			return false;
		if (yearsOfProduction == null) {
			if (other.yearsOfProduction != null)
				return false;
		} else if (!yearsOfProduction.equals(other.yearsOfProduction))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Show [id=").append(id).append(", theTvDbId=")
				.append(theTvDbId).append(", imDbId=").append(imDbId)
				.append(", title=").append(title).append(", description=")
				.append(description).append(", numberOfSeasons=")
				.append(numberOfSeasons).append(", seasonsDetails=")
				.append(seasonsDetails).append(", numberOfEpisodes=")
				.append(numberOfEpisodes).append(", numberOfFollowers=")
				.append(numberOfFollowers).append(", numberOfComments=")
				.append(numberOfComments).append(", similars=")
				.append(similars).append(", characters=").append(characters)
				.append(", yearsOfProduction=").append(yearsOfProduction)
				.append(", genres=").append(Arrays.toString(genres))
				.append(", episodeLength=").append(episodeLength)
				.append(", network=").append(network).append(", rating=")
				.append(rating).append(", status=").append(status)
				.append(", language=").append(language).append(", note=")
				.append(note).append(", inAccount=").append(inAccount)
				.append(", userDetail=").append(userDetail)
				.append(", resourceUrl=").append(resourceUrl).append("]");
		return builder.toString();
	}

	/**
	 * The Class SeasonDetail.
	 *
	 * @author Guillaume Maka
	 */
	static public class SeasonDetail extends BetaSeriesObject {
		
		/** The season number. */
		private final int seasonNumber;
		
		/** The number of episode. */
		private final int numberOfEpisode;

		/**
		 * Instantiates a new season detail.
		 *
		 * @param seasonNumber
		 *            the season number
		 * @param numberOfEpisode
		 *            the number of episode
		 */
		public SeasonDetail(int seasonNumber, int numberOfEpisode) {
			this.seasonNumber = seasonNumber;
			this.numberOfEpisode = numberOfEpisode;
		}

		/**
		 * Gets the season number.
		 *
		 * @return the season number
		 */
		public int getSeasonNumber() {
			return seasonNumber;
		}

		/**
		 * Gets the number of episode.
		 *
		 * @return the number of episode
		 */
		public int getNumberOfEpisode() {
			return numberOfEpisode;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + numberOfEpisode;
			result = prime * result + seasonNumber;
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
			if (!(obj instanceof SeasonDetail))
				return false;
			SeasonDetail other = (SeasonDetail) obj;
			if (numberOfEpisode != other.numberOfEpisode)
				return false;
			if (seasonNumber != other.seasonNumber)
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
			builder.append("SeasonDetail [seasonNumber=").append(seasonNumber)
					.append(", numberOfEpisode=").append(numberOfEpisode)
					.append("]");
			return builder.toString();
		}
	}

	/**
	 * The Class UserDetail.
	 *
	 * @author Guillaume Maka
	 */
	static public class UserDetail extends BetaSeriesObject {
		
		/** The archived. */
		private final boolean archived;
		
		/** The favorited. */
		private final boolean favorited;
		
		/** The remaining. */
		private final String remaining;
		
		/** The status. */
		private final String status;
		
		/** The last. */
		private final String last;
		
		/** The tags. */
		private final String tags;
		
		
		
		/**
		 * Instantiates a new user detail.
		 *
		 * @param archived
		 *            the archived
		 * @param favorited
		 *            the favorited
		 * @param remaining
		 *            the remaining
		 * @param status
		 *            the status
		 * @param last
		 *            the last
		 * @param tags
		 *            the tags
		 */
		public UserDetail(boolean archived, boolean favorited, String remaining,
				String status, String last, String tags) {
			super();
			this.archived = archived;
			this.favorited = favorited;
			this.remaining = remaining;
			this.status = status;
			this.last = last;
			this.tags = tags;
		}

		/**
		 * Checks if is archived.
		 *
		 * @return true, if is archived
		 */
		public boolean isArchived() {
			return archived;
		}

		/**
		 * Checks if is favorited.
		 *
		 * @return true, if is favorited
		 */
		public boolean isFavorited() {
			return favorited;
		}

		/**
		 * Gets the remaining.
		 *
		 * @return the remaining
		 */
		public String getRemaining() {
			return remaining;
		}

		/**
		 * Gets the status.
		 *
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * Gets the last.
		 *
		 * @return the last
		 */
		public String getLast() {
			return last;
		}

		/**
		 * Gets the tags.
		 *
		 * @return the tags
		 */
		public String getTags() {
			return tags;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + (archived ? 1231 : 1237);
			result = prime * result + (favorited ? 1231 : 1237);
			result = prime * result + ((last == null) ? 0 : last.hashCode());
			result = prime * result
					+ ((remaining == null) ? 0 : remaining.hashCode());
			result = prime * result
					+ ((status == null) ? 0 : status.hashCode());
			result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
			if (!(obj instanceof UserDetail))
				return false;
			UserDetail other = (UserDetail) obj;
			if (archived != other.archived)
				return false;
			if (favorited != other.favorited)
				return false;
			if (last == null) {
				if (other.last != null)
					return false;
			} else if (!last.equals(other.last))
				return false;
			if (remaining == null) {
				if (other.remaining != null)
					return false;
			} else if (!remaining.equals(other.remaining))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			if (tags == null) {
				if (other.tags != null)
					return false;
			} else if (!tags.equals(other.tags))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("UserDetail [archived=").append(archived)
					.append(", favorited=").append(favorited)
					.append(", remaining=").append(remaining)
					.append(", status=").append(status).append(", last=")
					.append(last).append(", tags=").append(tags).append("]");
			return builder.toString();
		}
	}
}
