package org.springframework.social.betaseries.api;

public class BSUser extends BetaSeriesObject {
	private final Integer id;
	private final String login;
	private final boolean inAccount;

	/**
	 * @param id
	 * @param login
	 * @param inAccount
	 */
	public BSUser(Integer id, String login, boolean inAccount) {
		super();
		this.id = id;
		this.login = login;
		this.inAccount = inAccount;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
