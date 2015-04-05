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
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Episode.
 * 
 * @author Guillaume Maka
 */
public class Episode extends BetaSeriesObject {
	
	/** The id. */
	private int id;
	
	/** The tv db id. */
	private int theTvDbId;
	
	/** The title. */
	private String title;
	
	/** The season number. */
	private int seasonNumber;
	
	/** The episode number. */
	private int episodeNumber;
	
	/** The show id. */
	private int showId;	
	
	/** The show tv db id. */
	private int showTvDbId;
	
	/** The show title. */
	private String showTitle;	 
	
	/** The code. */
	private String code;
	
	/** The global. */
	private int global;
	
	/** The description. */
	private String description;
	
	/** The air date. */
	private Date airDate;
	
	/** The note. */
	private Note note;
	
	/** The is seen. */
	private boolean isSeen;
	
	/** The is downloaded. */
	private boolean isDownloaded;
	
	/** The number of comment. */
	private int numberOfComment;
	
	/** The subtitles. */
	private List<Subtitle> subtitles;
	
	/**
	 * Instantiates a new episode.
	 * 
	 * @param id
	 *            the id
	 * @param theTvDbId
	 *            the the tv db id
	 * @param title
	 *            the title
	 */
	public Episode(int id, int theTvDbId, String title) {
		super();
		this.id = id;
		this.theTvDbId = theTvDbId;
		this.title = title;
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
	 * Gets the season number.
	 * 
	 * @return the season number
	 */
	public int getSeasonNumber() {
		return seasonNumber;
	}

	/**
	 * Sets the season number.
	 * 
	 * @param seasonNumber
	 *            the new season number
	 */
	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
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
	 * Sets the episode number.
	 * 
	 * @param episodeNumber
	 *            the new episode number
	 */
	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
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
	 * Sets the show id.
	 * 
	 * @param showId
	 *            the new show id
	 */
	public void setShowId(int showId) {
		this.showId = showId;
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
	 * Sets the show tv db id.
	 * 
	 * @param showTvDbId
	 *            the new show tv db id
	 */
	public void setShowTvDbId(int showTvDbId) {
		this.showTvDbId = showTvDbId;
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
	 * Sets the show title.
	 * 
	 * @param showTitle
	 *            the new show title
	 */
	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
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
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * Sets the global.
	 * 
	 * @param global
	 *            the new global
	 */
	public void setGlobal(int global) {
		this.global = global;
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
	 * Gets the air date.
	 * 
	 * @return the air date
	 */
	public Date getAirDate() {
		return airDate;
	}

	/**
	 * Sets the air date.
	 * 
	 * @param airDate
	 *            the new air date
	 */
	public void setAirDate(Date airDate) {
		this.airDate = airDate;
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
	 * @param note
	 *            the new note
	 */
	public void setNote(Note note) {
		this.note = note;
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
	 * Sets the seen.
	 * 
	 * @param isSeen
	 *            the new seen
	 */
	public void setSeen(boolean isSeen) {
		this.isSeen = isSeen;
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
	 * Sets the downloaded.
	 * 
	 * @param isDownloaded
	 *            the new downloaded
	 */
	public void setDownloaded(boolean isDownloaded) {
		this.isDownloaded = isDownloaded;
	}

	/**
	 * Gets the number of comment.
	 *
	 * @return the numberOfComment
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

	/**
	 * Sets the subtitles.
	 *
	 * @param subtitles the subtitles to set
	 */
	public void setSubtitles(List<Subtitle> subtitles) {
		this.subtitles = subtitles;
	}

	/**
	 * Sets the number of comment.
	 *
	 * @param numberOfComment the numberOfComment to set
	 */
	public void setNumberOfComment(int numberOfComment) {
		this.numberOfComment = numberOfComment;
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
