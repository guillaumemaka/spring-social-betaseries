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

/**
 * Represents an instance of {@code Friend}.
 * <p>
 * This class is derived of the {@link Member} class. The Api for the friend
 * endpoint return a similar subset of the {@link Member} class. 
 * </p> 
 * 
 * @author Guillaume Maka
 */
public class Friend extends BetaSeriesObject {
	
	/** The friend id. Similar to {@link Member#getId()} */
	private final String id;
	
	/** The friend login. Similar to {@link Member#getLogin()} */
	private final String login;
	
	/** The friend in account flag. Similar to  {@link Member#isInAccount()}}. */
	private final boolean inAccount;

	/**
	 * Construct an instance of {@code Friend}.
	 * 
	 * @param  the friend id
	 * @param  the friend login
	 * @param  the friend inAccount
	 */
	public Friend(String id, String login, boolean inAccount) {
		super();
		this.id = id;
		this.login = login;
		this.inAccount = inAccount;
	}

	/**
	 * Gets the friend id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * Gets the friend login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Gets the friend inAccount.
	 * 
	 * @return the inAccount
	 */
	public boolean isInAccount() {
		return inAccount;
	}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Friend))
			return false;
		Friend other = (Friend) obj;
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
