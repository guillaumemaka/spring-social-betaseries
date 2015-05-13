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
 * The Class BSOptions.
 * <p>
 * Represents the available subtitles options of a member.
 * </p>
 * 
 * @author Guillaume Maka
 */
public class BSOptions extends BetaSeriesObject {
	/** The notation option. */
	private final boolean notationEnabled;
	
	/** The downloaded option. */	
	private final boolean downloadedEnabled;
	
	/** The global option. */
	private final boolean globalEnabled;
	
	/** The timelag option. */
	private final boolean timelagEnabled;
	
	/** The friendship option. */
	private final boolean friendshipEnabled;

	/** The subtitles sources. */
	private final List<SubtitleSource> sources;
	
	/**
	 * Represent a new instance of {@code BSOptions}.
	 * 
	 * @param notationEnabled
	 * @param downloadedEnabled
	 * @param globalEnabled
	 * @param timelagEnabled
	 * @param friendshipEnabled
	 * @param sources
	 */
	public BSOptions(boolean notationEnabled, boolean downloadedEnabled,
			boolean globalEnabled, boolean timelagEnabled,
			boolean friendshipEnabled, List<SubtitleSource> sources) {
		super();
		this.notationEnabled = notationEnabled;
		this.downloadedEnabled = downloadedEnabled;
		this.globalEnabled = globalEnabled;
		this.timelagEnabled = timelagEnabled;
		this.friendshipEnabled = friendshipEnabled;
		this.sources = sources;
	}

	/**
	 * Gets the notation option.
	 * 
	 * @return the notationEnabled
	 */
	public boolean isNotationEnabled() {
		return notationEnabled;
	}


	/**
	 * Gets the downloaded option.
	 * 
	 * @return the downloadedEnabled
	 */
	public boolean isDownloadedEnabled() {
		return downloadedEnabled;
	}


	/**
	 * Gets the global option.
	 * 
	 * @return the globalEnabled
	 */
	public boolean isGlobalEnabled() {
		return globalEnabled;
	}


	/**
	 * Gets the notation option.
	 * 
	 * @return the timelagEnabled
	 */
	public boolean isTimelagEnabled() {
		return timelagEnabled;
	}

	/**
	 * @return the friendshipEnabled
	 */
	public boolean isFriendshipEnabled() {
		return friendshipEnabled;
	}

	/**
	 * @return the sources
	 */
	public List<SubtitleSource> getSources() {
		return sources;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (downloadedEnabled ? 1231 : 1237);
		result = prime * result + (friendshipEnabled ? 1231 : 1237);
		result = prime * result + (globalEnabled ? 1231 : 1237);
		result = prime * result + (notationEnabled ? 1231 : 1237);
		result = prime * result + ((sources == null) ? 0 : sources.hashCode());
		result = prime * result + (timelagEnabled ? 1231 : 1237);
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
		if (!(obj instanceof BSOptions))
			return false;
		BSOptions other = (BSOptions) obj;
		if (downloadedEnabled != other.downloadedEnabled)
			return false;
		if (friendshipEnabled != other.friendshipEnabled)
			return false;
		if (globalEnabled != other.globalEnabled)
			return false;
		if (notationEnabled != other.notationEnabled)
			return false;
		if (sources == null) {
			if (other.sources != null)
				return false;
		} else if (!sources.equals(other.sources))
			return false;
		if (timelagEnabled != other.timelagEnabled)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BSOptions [notationEnabled=").append(notationEnabled)
				.append(", downloadedEnabled=").append(downloadedEnabled)
				.append(", globalEnabled=").append(globalEnabled)
				.append(", timelagEnabled=").append(timelagEnabled)
				.append(", friendshipEnabled=").append(friendshipEnabled)
				.append(", sources=").append(sources).append("]");
		return builder.toString();
	}
	
}
