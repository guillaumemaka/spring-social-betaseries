package org.springframework.social.betaseries.api;

import java.util.Date;

public class Notification extends BetaSeriesObject {
//	Json Representtation
//	{
//        "id": 252644325,
//        "type": "episode",
//        "ref_id": "417761",
//        "text": "Nouvel \u00e9pisode : Fairy Tail S05E32 - Stand, Hisui",
//        "html": "Nouvel \u00e9pisode : <a href=\"\/serie\/fairytail\">Fairy Tail<\/a> S05E32 - Stand, Hisui",
//        "date": "2014-11-09 00:03:16",
//        "seen": null
//    }
	private Long id;
	
	private BSNotificationType type;
	
	private String refId;
	
	private String text;
	
	private String html;
	
	private Date date;
	
	private boolean seen;
	
	public Notification() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public BSNotificationType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(BSNotificationType type) {
		this.type = type;
	}

	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * @param html the html to set
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the seen
	 */
	public boolean isSeen() {
		return seen;
	}

	/**
	 * @param seen the seen to set
	 */
	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((html == null) ? 0 : html.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((refId == null) ? 0 : refId.hashCode());
		result = prime * result + (seen ? 1231 : 1237);
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof Notification))
			return false;
		Notification other = (Notification) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (html == null) {
			if (other.html != null)
				return false;
		} else if (!html.equals(other.html))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (refId == null) {
			if (other.refId != null)
				return false;
		} else if (!refId.equals(other.refId))
			return false;
		if (seen != other.seen)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notification [id=").append(id).append(", type=")
				.append(type).append(", refId=").append(refId)
				.append(", text=").append(text).append(", html=").append(html)
				.append(", date=").append(date).append(", seen=").append(seen)
				.append("]");
		return builder.toString();
	}		
}
