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
 * The Class BSUser.
 * <p>
 * Represents  
 * </p>
 *
 * @author Guillaume Maka
 */
public class BSUser extends BetaSeriesObject {
	
	/** The id. */
	private final Integer id;
	
	/** The login. */
	private final String login;
	
	/** The in account. */
	private final boolean inAccount;

	/**
	 * Represents an instance of {@code BSUser}.
	 * <p>
	 * This represents a search result item.
	 * </p>
	 * 
	 * @param id  the id
	 * @param login  the login
	 * @param inAccount  the in account
	 */
	public BSUser(Integer id, String login, boolean inAccount) {
		super();
		this.id = id;
		this.login = login;
		this.inAccount = inAccount;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the user login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Checks if the user is in the authenticated account.
	 *
	 * @return true, if is in account
	 */
	public boolean isInAccount() {
		return inAccount;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (inAccount ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		if (!(obj instanceof BSUser))
			return false;
		BSUser other = (BSUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inAccount != other.inAccount)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
}
