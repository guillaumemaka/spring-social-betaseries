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
 * Represents an instance of {@code SubtitleSource}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public class SubtitleSource extends BetaSeriesObject {
	
	/** The source name. */
	private final String name;
	
	/** The source option flag. */
	private final boolean enabled;
	
	/**
	 * Instantiates a new {@code SubtitleSource}.
	 *
	 * @param name  the source name
	 * @param enabled  the enabled flag
	 */
	public SubtitleSource(String name, boolean enabled) {
		super();
		this.name = name;
		this.enabled = enabled;
	}

	/**
	 * Gets the source name.
	 *
	 * @return the source name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Checks if the source is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof SubtitleSource))
			return false;
		SubtitleSource other = (SubtitleSource) obj;
		if (enabled != other.enabled)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubtitleSource [name=").append(name)
				.append(", enabled=").append(enabled).append("]");
		return builder.toString();
	}	
}
