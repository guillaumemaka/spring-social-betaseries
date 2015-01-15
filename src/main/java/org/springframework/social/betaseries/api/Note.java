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

// TODO: Auto-generated Javadoc
/**
 * The Class Note.
 * 
 * @author Guillaume Maka
 */
public class Note extends BetaSeriesObject {
	
	/** The total. */
	private double total;
	
	/** The average. */
	private double average;
	
	/** The user note. */
	private double userNote;

	public Note() {}
	
	/**
	 * Gets the total.
	 * 
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 * 
	 * @param total
	 *            the new total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Gets the average.
	 * 
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * Sets the average.
	 * 
	 * @param average
	 *            the new average
	 */
	public void setAverage(double average) {
		this.average = average;
	}

	/**
	 * Gets the user note.
	 * 
	 * @return the user note
	 */
	public double getUserNote() {
		return userNote;
	}

	/**
	 * Sets the user note.
	 * 
	 * @param userNote
	 *            the new user note
	 */
	public void setUserNote(double userNote) {
		this.userNote = userNote;
	}

	/**
	 * Instantiates a new note.
	 * 
	 * @param total
	 *            the total
	 * @param average
	 *            the average
	 * @param userNote
	 *            the user note
	 */
	public Note(double total, double average, double userNote) {
		super();
		this.total = total;
		this.average = average;
		this.userNote = userNote;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(average);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(userNote);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!(obj instanceof Note))
			return false;
		Note other = (Note) obj;
		if (Double.doubleToLongBits(average) != Double
				.doubleToLongBits(other.average))
			return false;
		if (Double.doubleToLongBits(total) != Double
				.doubleToLongBits(other.total))
			return false;
		if (Double.doubleToLongBits(userNote) != Double
				.doubleToLongBits(other.userNote))
			return false;
		return true;
	}	
}
