package org.springframework.social.betaseries.api;


public class BSAuthObject {		
	private final String userId;
	private final String login;
	private final boolean inAccount;
	private final String token;
	private final String hash;
	
	/**
	 * @param userId
	 * @param login
	 * @param inAccount
	 * @param token
	 * @param hash
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
	 * @return the userId
	 */
	public String getUserId() {		
		return userId;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {		
		return login;
	}

	/**
	 * @return the inAccount
	 */
	public boolean isInAccount() {		
		return inAccount;
	}

	/**
	 * @return the token
	 */
	public String getToken() {		
		return token;
	}

	/**
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
