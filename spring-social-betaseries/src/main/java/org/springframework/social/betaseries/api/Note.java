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
 * Represents an instance of {@code Note}.
 * <p>
 * </p>
 *
 * @author Guillaume Maka
 */
public class Note extends BetaSeriesObject {
	
	/** The total rating. */
	private final double total;
	
	/** The average rating. */
	private final double average;
	
	/** The user note rating. */
	private final double userNote;
	
	/**
	 * Instantiates a new {@code Note}.
	 * 
	 * @param total  the total
	 * @param average  the average
	 * @param userNote  the user note
	 */
	public Note(double total, double average, double userNote) {
		super();
		this.total = total;
		this.average = average;
		this.userNote = userNote;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public double getTotal() {
		return total;
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
	 * Gets the user note.
	 *
	 * @return the user note
	 */
	public double getUserNote() {
		return userNote;
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
