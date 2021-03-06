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
 * Represents an instance of {@code Character}.
 * <p>
 * Represents show|movie character.
 * </p>
 *
 * @author Guillaume Maka
 */
public class Character extends BetaSeriesObject {

	/** The id. */
	private final int id;

	/** The show id. */
	private final int showId;

	/** The name. */
	private final String name;

	/** The role. */
	private final String role;

	/** The actor. */
	private final String actor;

	/** The picture url. */
	private final String pictureUrl;

	/** The description. */
	private final String description;

	/**
	 * Instantiates a new @{code Character}.
	 *
	 * @param id  the id
	 * @param showId  the show id
	 * @param name  the character name
	 * @param role  the character role
	 * @param actor  the character actor name
	 * @param pictureUrl  the character picture url
	 * @param description  the character description
	 */
	public Character(int id, int showId, String name, String role,
			String actor, String pictureUrl, String description) {
		super();
		this.id = id;
		this.showId = showId;
		this.name = name;
		this.role = role;
		this.actor = actor;
		this.pictureUrl = pictureUrl;
		this.description = description;
	}

	/**
	 * Gets the character id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the character show id.
	 *
	 * @return the show id
	 */
	public int getShowId() {
		return showId;
	}

	/**
	 * Gets the character name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the character role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Gets the character actor name.
	 *
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}

	/**
	 * Gets the character picture url.
	 *
	 * @return the picture url
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * Gets the character description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((pictureUrl == null) ? 0 : pictureUrl.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + showId;
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
		if (!(obj instanceof Character))
			return false;
		Character other = (Character) obj;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pictureUrl == null) {
			if (other.pictureUrl != null)
				return false;
		} else if (!pictureUrl.equals(other.pictureUrl))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (showId != other.showId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Character [id=").append(id).append(", showId=")
				.append(showId).append(", name=").append(name)
				.append(", role=").append(role).append(", actor=")
				.append(actor).append(", pictureUrl=").append(pictureUrl)
				.append(", desctription=").append(description).append("]");
		return builder.toString();
	}
}
