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

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Subtitle.
 * 
 * @author Guillaume Maka
 * @param <EmbededEpidose>
 */
public class Subtitle extends BetaSeriesObject {

	/** The id. */
	private final int id;

	/** The language. */
	private final String language;

	/** The source. */
	private final String source;

	/** The quality. */
	private final int quality;

	/** The file. */
	private final String file;

	private final List<String> content;

	/** The url. */
	private final String url;

	private final EmbededEpisode episode;

	/** The date. */
	private final Date date;

	/**
	 * @param id
	 * @param language
	 * @param source
	 * @param quality
	 * @param file
	 * @param content
	 * @param url
	 * @param episode
	 * @param date
	 */
	public Subtitle(int id, String language, String source, int quality,
			String file, List<String> content, String url,
			EmbededEpisode episode, Date date) {
		super();
		this.id = id;
		this.language = language;
		this.source = source;
		this.quality = quality;
		this.file = file;
		this.content = content;
		this.url = url;
		this.episode = episode;
		this.date = date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @return the quality
	 */
	public int getQuality() {
		return quality;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @return the content
	 */
	public List<String> getContent() {
		return content;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the episode
	 */
	public EmbededEpisode getEpisode() {
		return episode;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
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
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((episode == null) ? 0 : episode.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + quality;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		if (!(obj instanceof Subtitle))
			return false;
		Subtitle other = (Subtitle) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (episode == null) {
			if (other.episode != null)
				return false;
		} else if (!episode.equals(other.episode))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (quality != other.quality)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
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
		builder.append("Subtitle [id=").append(id).append(", language=")
				.append(language).append(", source=").append(source)
				.append(", quality=").append(quality).append(", file=")
				.append(file).append(", content=").append(content)
				.append(", url=").append(url).append(", episode=")
				.append(episode).append(", date=").append(date).append("]");
		return builder.toString();
	}

	public static class EmbededEpisode extends BetaSeriesObject {
		private final int showId;
		private final int episodeId;
		private final int season;
		private final int episode;

		/**
		 * @param showId
		 * @param episodeId
		 * @param season
		 * @param episode
		 */
		public EmbededEpisode(int showId, int episodeId, int season, int episode) {
			super();
			this.showId = showId;
			this.episodeId = episodeId;
			this.season = season;
			this.episode = episode;
		}

		/**
		 * @return the showId
		 */
		public int getShowId() {
			return showId;
		}

		/**
		 * @return the episodeId
		 */
		public int getEpisodeId() {
			return episodeId;
		}

		/**
		 * @return the season
		 */
		public int getSeason() {
			return season;
		}

		/**
		 * @return the episode
		 */
		public int getEpisode() {
			return episode;
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
			result = prime * result + episode;
			result = prime * result + episodeId;
			result = prime * result + season;
			result = prime * result + showId;
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
			if (!(obj instanceof EmbededEpisode))
				return false;
			EmbededEpisode other = (EmbededEpisode) obj;
			if (episode != other.episode)
				return false;
			if (episodeId != other.episodeId)
				return false;
			if (season != other.season)
				return false;
			if (showId != other.showId)
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
			builder.append("EmbededEpisode [showId=").append(showId)
					.append(", episodeId=").append(episodeId)
					.append(", season=").append(season).append(", episode=")
					.append(episode).append("]");
			return builder.toString();
		}

	}
}