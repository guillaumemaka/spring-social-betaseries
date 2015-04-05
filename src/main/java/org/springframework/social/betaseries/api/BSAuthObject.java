/**
 * Copyright 2015 [name of copyright owner]
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


// TODO: Auto-generated Javadoc
/**
 * The Class BSAuthObject.
 *
 * @author Guillaume Maka
 */
public class BSAuthObject {		
	
	/** The user id. */
	private final String userId;
	
	/** The login. */
	private final String login;
	
	/** The in account. */
	private final boolean inAccount;
	
	/** The token. */
	private final String token;
	
	/** The hash. */
	private final String hash;
	
	/**
	 * Instantiates a new BS auth object.
	 *
	 * @param userId the user id
	 * @param login the login
	 * @param inAccount the in account
	 * @param token the token
	 * @param hash the hash
	 */
	public BSAuthObject(String userId, String login, boolean inAccount,
			String token, String hash) {
		super();
		this.userId = userId;
		this.login = login;
		this.inAccount = inAccount;
		this.token = token;
		this.hash = hash;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public String getUserId() {		
		return userId;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {		
		return login;
	}

	/**
	 * Checks if is in account.
	 *
	 * @return the inAccount
	 */
	public boolean isInAccount() {		
		return inAccount;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {		
		return token;
	}

	/**
	 * Gets the hash.
	 *
	 * @return the hash
	 */
	public String getHash() {		
		return hash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + (inAccount ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (getClass() != obj.getClass())
			return false;
		BSAuthObject other = (BSAuthObject) obj;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (inAccount != other.inAccount)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberAuthObject [userId=").append(userId)
				.append(", login=").append(login).append(", inAccount=")
				.append(inAccount).append(", token=").append(token)
				.append(", hash=").append(hash).append("]");
		return builder.toString();
	}	
}
