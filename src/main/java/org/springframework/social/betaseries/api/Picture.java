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

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Picture.
 *
 * @author Guillaume Maka
 */
public class Picture extends BetaSeriesObject {

	/** The id. */
	private final int id;

	/** The show id. */
	private final int showId;

	/** The login id. */
	private final int loginId;

	/** The url. */
	private final String url;

	/** The width. */
	private final int width;

	/** The height. */
	private final int height;

	/** The date. */
	private final Date date;

	/** The type. */
	private final BSPictureType type;

	/**
	 * Instantiates a new picture.
	 *
	 * @param id
	 *            the id
	 * @param showId
	 *            the show id
	 * @param loginId
	 *            the login id
	 * @param url
	 *            the url
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 * @param date
	 *            the date
	 * @param type
	 *            the type
	 */
	public Picture(int id, int showId, int loginId, String url, int width,
			int height, Date date, BSPictureType type) {
		super();
		this.id = id;
		this.showId = showId;
		this.loginId = loginId;
		this.url = url;
		this.width = width;
		this.height = height;
		this.date = date;
		this.type = type;
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
	 * Gets the show id.
	 *
	 * @return the show id
	 */
	public int getShowId() {
		return showId;
	}

	/**
	 * Gets the login id.
	 *
	 * @return the login id
	 */
	public int getLoginId() {
		return loginId;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public BSPictureType getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + height;
		result = prime * result + id;
		result = prime * result + loginId;
		result = prime * result + showId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + width;
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
		if (!(obj instanceof Picture))
			return false;
		Picture other = (Picture) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (height != other.height)
			return false;
		if (id != other.id)
			return false;
		if (loginId != other.loginId)
			return false;
		if (showId != other.showId)
			return false;
		if (type != other.type)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Picture [id=").append(id).append(", showId=")
				.append(showId).append(", loginId=").append(loginId)
				.append(", url=").append(url).append(", width=").append(width)
				.append(", height=").append(height).append(", date=")
				.append(date).append(", type=").append(type).append("]");
		return builder.toString();
	}

}
