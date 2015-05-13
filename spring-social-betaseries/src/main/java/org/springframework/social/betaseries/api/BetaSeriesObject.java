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

import java.util.HashMap;
import java.util.Map;

/**
 * Represent a base class for all object representation. 
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
	 * <p>
	 * A {@code Map} containing extra response property that the child class
	 * doesn't handle by default. Prevent Json unknown property error.  
 	 * </p>
 	 * <p>
 	 * This prevent API changes.
 	 * </p>
	 * 
	 * @return the extra data
	 */
	public Map<String,Object> getExtraData() {
		return this.extraData;
	}
	
	/**
	 * Adds the unknown property from json response that child class doesn't 
	 * handle by default.
	 * 
	 * @param key  the key
	 * @param value  the value
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
