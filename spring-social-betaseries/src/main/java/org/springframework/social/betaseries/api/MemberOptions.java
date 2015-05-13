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

/**
 * Represents an instance of {@code MemberOptions}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public class MemberOptions extends BetaSeriesObject {
	
	/** The notation flag option. */
	private boolean notationEnabled;
	
	/** The downloaded flag option. */	
	private boolean downloadedEnabled;
	
	/** The global flag option. */
	private boolean globalEnabled;
	
	/** The timelag flag option. */
	private boolean timelagEnabled;
	
	/** The friendship status option. */
	private BSMemberOptionValue friendshipStatus;
	
	/**
	 * Instantiates a new  {@code MemberOptions}.
	 */
	public MemberOptions() {
		super();
	}	
	
	/**
	 * Checks if is notation enabled.
	 *
	 * @return true, if is notation enabled
	 */
//	public MemberOptions(boolean notationEnabled, boolean downloadedEnabled,
//			boolean globalEnabled, boolean timelagEnabled,
//			boolean friendshipEnabled) {
//		super();
//		this.notationEnabled = notationEnabled;
//		this.downloadedEnabled = downloadedEnabled;
//		this.globalEnabled = globalEnabled;
//		this.timelagEnabled = timelagEnabled;
//		this.friendshipEnabled = friendshipEnabled;
//	}
	/**
	 * Check if the notation option is enabled.
	 * 
	 * @return the notationEnabled
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
	 * Checks if is download option is enabled.
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
	 * Checks if is global option is enabled.
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
	 * Checks if is timelag option is enabled.
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
	 * Gets the friendship status.
	 *
	 * @return the friendship status
	 */
	public BSMemberOptionValue getFriendshipStatus() {
		return friendshipStatus;
	}
	
	/**
	 * Sets the friendship status.
	 *
	 * @param friendshipStatus
	 *            the new friendship status
	 */
	public void setFriendshipStatus(BSMemberOptionValue friendshipStatus) {
		this.friendshipStatus = friendshipStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (downloadedEnabled ? 1231 : 1237);
		result = prime
				* result
				+ ((friendshipStatus == null) ? 0 : friendshipStatus.hashCode());
		result = prime * result + (globalEnabled ? 1231 : 1237);
		result = prime * result + (notationEnabled ? 1231 : 1237);
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
		if (!(obj instanceof MemberOptions))
			return false;
		MemberOptions other = (MemberOptions) obj;
		if (downloadedEnabled != other.downloadedEnabled)
			return false;
		if (friendshipStatus != other.friendshipStatus)
			return false;
		if (globalEnabled != other.globalEnabled)
			return false;
		if (notationEnabled != other.notationEnabled)
			return false;
		if (timelagEnabled != other.timelagEnabled)
			return false;
		return true;
	}		
}
