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

/**
 * This class represent a {@code Badge} object representation
 */
public class Badge extends BetaSeriesObject {	
	
	

	/** The badge id. */
	private final Long id;
	
	/** The badge code. */
	private final String code;
	
	/** The badge name. */
	private final String name;
	
	/** The badge description. */
	private final String description;
	
	/** The badge earning date. */
	private final Date date;

	/**
	 * Construct e new {@link Badge} object.
	 * 
	 * @param id  the badge id  
	 * @param code  the badge code 
	 * @param name  the badge name
	 * @param description  the badge description
	 * @param date  the badge date
	 */
	public Badge(Long id, String code, String name, String description,
			Date date) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.date = date;
	}

	/**
	 * Gets the badge id.
	 * 
	 * @return the badgw id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Gets the badge code.
	 * 
	 * @return the badge code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the badge name.
	 * 
	 * @return the badge name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the badge description.
	 * 
	 * @return the badge description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gwts the badge date.
	 * 
	 * @return the badge earning date
	 */
	public Date getDate() {
		return date;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Badge other = (Badge) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
