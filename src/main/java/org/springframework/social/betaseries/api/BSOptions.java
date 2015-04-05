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

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class BSOptions.
 *
 * @author Guillaume Maka
 */
public class BSOptions extends BetaSeriesObject {
	
	/** The notation enabled. */
	private boolean notationEnabled;
	
	/** The downloaded enabled. */	
	private boolean downloadedEnabled;
	
	/** The global enabled. */
	private boolean globalEnabled;
	
	/** The timelag enabled. */
	private boolean timelagEnabled;
	
	/** The friendship enabled. */
	private boolean friendshipEnabled;

	/** The sources. */
	List<SubtitleSource> sources;
	
	/**
	 * Instantiates a new BS options.
	 */
	public BSOptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks if is notation enabled.
	 *
	 * @return true, if is notation enabled
	 */
	public boolean isNotationEnabled() {
		return notationEnabled;
	}

	/**
	 * Sets the notation enabled.
	 *
	 * @param notationEnabled
	 *            the new notation enabled
	 */
	public void setNotationEnabled(boolean notationEnabled) {
		this.notationEnabled = notationEnabled;
	}

	/**
	 * Checks if is downloaded enabled.
	 *
	 * @return true, if is downloaded enabled
	 */
	public boolean isDownloadedEnabled() {
		return downloadedEnabled;
	}

	/**
	 * Sets the downloaded enabled.
	 *
	 * @param downloadedEnabled
	 *            the new downloaded enabled
	 */
	public void setDownloadedEnabled(boolean downloadedEnabled) {
		this.downloadedEnabled = downloadedEnabled;
	}

	/**
	 * Checks if is global enabled.
	 *
	 * @return true, if is global enabled
	 */
	public boolean isGlobalEnabled() {
		return globalEnabled;
	}

	/**
	 * Sets the global enabled.
	 *
	 * @param globalEnabled
	 *            the new global enabled
	 */
	public void setGlobalEnabled(boolean globalEnabled) {
		this.globalEnabled = globalEnabled;
	}

	/**
	 * Checks if is timelag enabled.
	 *
	 * @return true, if is timelag enabled
	 */
	public boolean isTimelagEnabled() {
		return timelagEnabled;
	}

	/**
	 * Sets the timelag enabled.
	 *
	 * @param timelagEnabled
	 *            the new timelag enabled
	 */
	public void setTimelagEnabled(boolean timelagEnabled) {
		this.timelagEnabled = timelagEnabled;
	}

	/**
	 * Checks if is friendship enabled.
	 *
	 * @return true, if is friendship enabled
	 */
	public boolean isFriendshipEnabled() {
		return friendshipEnabled;
	}

	/**
	 * Sets the friendship enabled.
	 *
	 * @param friendshipEnabled
	 *            the new friendship enabled
	 */
	public void setFriendshipEnabled(boolean friendshipEnabled) {
		this.friendshipEnabled = friendshipEnabled;
	}

	/**
	 * Gets the sources.
	 *
	 * @return the sources
	 */
	public List<SubtitleSource> getSources() {
		return sources;
	}

	/**
	 * Sets the sources.
	 *
	 * @param sources
	 *            the new sources
	 */
	public void setSources(List<SubtitleSource> sources) {
		this.sources = sources;
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
}
