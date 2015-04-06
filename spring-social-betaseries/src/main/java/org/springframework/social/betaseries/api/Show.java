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

import java.util.Arrays;
import java.util.List;

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

	/** The seasons. */
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

	/** The notes. */
	private Note note;

	/** The in account. */
	private boolean inAccount;

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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the theTvDbId
	 */
	public int getTheTvDbId() {
		return theTvDbId;
	}

	/**
	 * @param theTvDbId
	 *            the theTvDbId to set
	 */
	public void setTheTvDbId(int theTvDbId) {
		this.theTvDbId = theTvDbId;
	}

	/**
	 * @return the imDbId
	 */
	public String getImDbId() {
		return imDbId;
	}

	/**
	 * @param imDbId
	 *            the imDbId to set
	 */
	public void setImDbId(String imDbId) {
		this.imDbId = imDbId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the numberOfSeasons
	 */
	public String getNumberOfSeasons() {
		return numberOfSeasons;
	}

	/**
	 * @param numberOfSeasons
	 *            the numberOfSeasons to set
	 */
	public void setNumberOfSeasons(String numberOfSeasons) {
		this.numberOfSeasons = numberOfSeasons;
	}

	/**
	 * @return the seasonsDetails
	 */
	public List<SeasonDetail> getSeasonsDetails() {
		return seasonsDetails;
	}

	/**
	 * @param seasonsDetails
	 *            the seasonsDetails to set
	 */
	public void setSeasonsDetails(List<SeasonDetail> seasonsDetails) {
		this.seasonsDetails = seasonsDetails;
	}

	/**
	 * @return the numberOfEpisodes
	 */
	public String getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	/**
	 * @param numberOfEpisodes
	 *            the numberOfEpisodes to set
	 */
	public void setNumberOfEpisodes(String numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}

	/**
	 * @return the numberOfFollowers
	 */
	public String getNumberOfFollowers() {
		return numberOfFollowers;
	}

	/**
	 * @param numberOfFollowers
	 *            the numberOfFollowers to set
	 */
	public void setNumberOfFollowers(String numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}

	/**
	 * @return the numberOfComments
	 */
	public String getNumberOfComments() {
		return numberOfComments;
	}

	/**
	 * @param numberOfComments
	 *            the numberOfComments to set
	 */
	public void setNumberOfComments(String numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	/**
	 * @return the similars
	 */
	public String getSimilars() {
		return similars;
	}

	/**
	 * @param similars
	 *            the similars to set
	 */
	public void setSimilars(String similars) {
		this.similars = similars;
	}

	/**
	 * @return the characters
	 */
	public String getCharacters() {
		return characters;
	}

	/**
	 * @param characters
	 *            the characters to set
	 */
	public void setCharacters(String characters) {
		this.characters = characters;
	}

	/**
	 * @return the yearsOfProduction
	 */
	public String getYearsOfProduction() {
		return yearsOfProduction;
	}

	/**
	 * @param yearsOfProduction
	 *            the yearsOfProduction to set
	 */
	public void setYearsOfProduction(String yearsOfProduction) {
		this.yearsOfProduction = yearsOfProduction;
	}

	/**
	 * @return the genres
	 */
	public String[] getGenres() {
		return genres;
	}

	/**
	 * @param genres
	 *            the genres to set
	 */
	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	/**
	 * @return the episodeLength
	 */
	public String getEpisodeLength() {
		return episodeLength;
	}

	/**
	 * @param episodeLength
	 *            the episodeLength to set
	 */
	public void setEpisodeLength(String episodeLength) {
		this.episodeLength = episodeLength;
	}

	/**
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @param network
	 *            the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the notes
	 */
	public Note getNote() {
		return note;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNote(Note notes) {
		this.note = notes;
	}

	/**
	 * @return the inAccount
	 */
	public boolean isInAccount() {
		return inAccount;
	}

	/**
	 * @param inAccount
	 *            the inAccount to set
	 */
	public void setInAccount(boolean inAccount) {
		this.inAccount = inAccount;
	}

	/**
	 * @return the user
	 */
	public UserDetail getUserDetail() {
		return userDetail;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserDetail user) {
		this.userDetail = user;
	}

	/**
	 * @return the resourceUrl
	 */
	public String getResourceUrl() {
		return resourceUrl;
	}

	/**
	 * @param resourceUrl
	 *            the resourceUrl to set
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

	static public class SeasonDetail extends BetaSeriesObject {
		private final int seasonNumber;
		private final int numberOfEpisode;

		/**
		 * @param seasonNumber
		 * @param numberOfEpisode
		 * @return
		 */
		public SeasonDetail(int seasonNumber, int numberOfEpisode) {
			this.seasonNumber = seasonNumber;
			this.numberOfEpisode = numberOfEpisode;
		}

		/**
		 * @return the seasonNumber
		 */
		public int getSeasonNumber() {
			return seasonNumber;
		}

		/**
		 * @return the numberOfEpisode
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

	static public class UserDetail extends BetaSeriesObject {
		private final boolean archived;
		private final boolean favorited;
		private final String remaining;
		private final String status;
		private final String last;
		private final String tags;
		
		
		
		/**
		 * @param archived
		 * @param favorited
		 * @param remaining
		 * @param status
		 * @param last
		 * @param tags
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
		 * @return the archived
		 */
		public boolean isArchived() {
			return archived;
		}

		/**
		 * @return the favorited
		 */
		public boolean isFavorited() {
			return favorited;
		}

		/**
		 * @return the remaining
		 */
		public String getRemaining() {
			return remaining;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @return the last
		 */
		public String getLast() {
			return last;
		}

		/**
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
