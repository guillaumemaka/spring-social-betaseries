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

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesObject.
 *
 * @author Guillaume Maka
 */
public class BetaSeriesObject {
	
	/** The extra data. */
	private Map<String,Object> extraData;
	
	/**
	 * Instantiates a new beta series object.
	 */
	public BetaSeriesObject() {
		this.extraData = new HashMap<String,Object>();
	}
	
	/**
	 * Gets the extra data.
	 *
	 * @return the extra data
	 */
	public Map<String,Object> getExtraData() {
		return this.extraData;
	}
	
	/**
	 * Adds the.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void add(String key, Object value) {
		this.extraData.put(key, value);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((extraData == null) ? 0 : extraData.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BetaSeriesObject other = (BetaSeriesObject) obj;
		if (extraData == null) {
			if (other.extraData != null)
				return false;
		} else if (!extraData.equals(other.extraData))
			return false;
		return true;
	}
}
