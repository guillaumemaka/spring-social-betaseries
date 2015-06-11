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
import java.util.List;

/**
 * Represents an instance of {@code Episode}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public class Episode extends BetaSeriesObject {
	
	/** The episode id. */
	private final  int id;
	
	/** The episode TV DB id. */
	private final int theTvDbId;
	
	/** The episode title. */
	private final String title;
	
	/** The episode season number. */
	private final int seasonNumber;
	
	/** The episode number. */
	private final int episodeNumber;
	
	/** The episode show id. */
	private final int showId;	
	
	/** The episode show TV DB id. */
	private final int showTvDbId;
	
	/** The episode show title. */
	private final String showTitle;	 
	
	/** The episode code. */
	private final String code;
	
	/** The episode global number. */
	private final int global;
	
	/** The episode description. */
	private final String description;
	
	/** The episode airing date. */
	private final Date airDate;
	
	/** The episode note. */
	private final Note note;
	
	/** Is the episode marked as seen. */
	private final boolean isSeen;
	
	/** Is the episode marked as downloaded. */
	private final boolean isDownloaded;
	
	/** The episode number of comment. */
	private final int numberOfComment;
	
	/** The episode available subtitles. */
	private final List<Subtitle> subtitles;
	
	/**
	 * Instantiates a new {@code Episode}.
	 *
	 * @param id  the episode id
	 * @param theTvDbId  the episodeTV DB id
	 * @param title  the episode title
	 * @param seasonNumber
	 * @param episodeNumber
	 * @param showId
	 * @param showTvDbId
	 * @param showTitle
	 * @param code
	 * @param global
	 * @param description
	 * @param airDate
	 * @param note
	 * @param isSeen
	 * @param isDownloaded
	 * @param numberOfComment
	 * @param subtitles
	 */
	public Episode(int id, int theTvDbId, String title, int seasonNumber,
			int episodeNumber, int showId, int showTvDbId, String showTitle,
			String code, int global, String description, Date airDate,
			Note note, boolean isSeen, boolean isDownloaded,
			int numberOfComment, List<Subtitle> subtitles) {
		super();
		this.id = id;
		this.theTvDbId = theTvDbId;
		this.title = title;
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.showId = showId;
		this.showTvDbId = showTvDbId;
		this.showTitle = showTitle;
		this.code = code;
		this.global = global;
		this.description = description;
		this.airDate = airDate;
		this.note = note;
		this.isSeen = isSeen;
		this.isDownloaded = isDownloaded;
		this.numberOfComment = numberOfComment;
		this.subtitles = subtitles;
	}


	/**
	 * Gets the episode id.
	 *
	 * @return the episode id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the episode TV DB id.
	 *
	 * @return the episode TV DB id
	 */
	public int getTheTvDbId() {
		return theTvDbId;
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
	 * Gets the season number.
	 *
	 * @return the season number
	 */
	public int getSeasonNumber() {
		return seasonNumber;
	}

	/**
	 * Gets the episode number.
	 *
	 * @return the episode number
	 */
	public int getEpisodeNumber() {
		return episodeNumber;
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
	 * Gets the show tv db id.
	 *
	 * @return the show tv db id
	 */
	public int getShowTvDbId() {
		return showTvDbId;
	}

	/**
	 * Gets the show title.
	 *
	 * @return the show title
	 */
	public String getShowTitle() {
		return showTitle;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the global.
	 *
	 * @return the global
	 */
	public int getGlobal() {
		return global;
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
	 * Gets the air date.
	 *
	 * @return the air date
	 */
	public Date getAirDate() {
		return airDate;
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
	 * Checks if is seen.
	 *
	 * @return true, if is seen
	 */
	public boolean isSeen() {
		return isSeen;
	}

	/**
	 * Checks if is downloaded.
	 *
	 * @return true, if is downloaded
	 */
	public boolean isDownloaded() {
		return isDownloaded;
	}

	/**
	 * Gets the number of comment.
	 *
	 * @return the number of comment
	 */
	public int getNumberOfComment() {
		return numberOfComment;
	}

	/**
	 * Gets the subtitles.
	 *
	 * @return the subtitles
	 */
	public List<Subtitle> getSubtitles() {
		return subtitles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((airDate == null) ? 0 : airDate.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + episodeNumber;
		result = prime * result + global;
		result = prime * result + id;
		result = prime * result + (isDownloaded ? 1231 : 1237);
		result = prime * result + (isSeen ? 1231 : 1237);
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + numberOfComment;
		result = prime * result + seasonNumber;
		result = prime * result + showId;
		result = prime * result
				+ ((showTitle == null) ? 0 : showTitle.hashCode());
		result = prime * result + showTvDbId;
		result = prime * result
				+ ((subtitles == null) ? 0 : subtitles.hashCode());
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
		if (!(obj instanceof Episode))
			return false;
		Episode other = (Episode) obj;
		if (airDate == null) {
			if (other.airDate != null)
				return false;
		} else if (!airDate.equals(other.airDate))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (episodeNumber != other.episodeNumber)
			return false;
		if (global != other.global)
			return false;
		if (id != other.id)
			return false;
		if (isDownloaded != other.isDownloaded)
			return false;
		if (isSeen != other.isSeen)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (numberOfComment != other.numberOfComment)
			return false;
		if (seasonNumber != other.seasonNumber)
			return false;
		if (showId != other.showId)
			return false;
		if (showTitle == null) {
			if (other.showTitle != null)
				return false;
		} else if (!showTitle.equals(other.showTitle))
			return false;
		if (showTvDbId != other.showTvDbId)
			return false;
		if (subtitles == null) {
			if (other.subtitles != null)
				return false;
		} else if (!subtitles.equals(other.subtitles))
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
		builder.append("Episode [id=").append(id).append(", theTvDbId=")
				.append(theTvDbId).append(", title=").append(title)
				.append(", seasonNumber=").append(seasonNumber)
				.append(", episodeNumber=").append(episodeNumber)
				.append(", showId=").append(showId).append(", showTvDbId=")
				.append(showTvDbId).append(", showTitle=").append(showTitle)
				.append(", code=").append(code).append(", global=")
				.append(global).append(", description=").append(description)
				.append(", airDate=").append(airDate).append(", note=")
				.append(note).append(", isSeen=").append(isSeen)
				.append(", isDownloaded=").append(isDownloaded)
				.append(", numberOfComment=").append(numberOfComment)
				.append(", subtitles=").append(subtitles).append("]");
		return builder.toString();
	}	
}
