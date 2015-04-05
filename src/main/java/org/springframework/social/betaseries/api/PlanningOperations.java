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
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlanningOperations.
 *
 * @author Guillaume Maka
 */
public interface PlanningOperations {
	
	/**
	 * Gets the general planning.
	 *
	 * @return the general planning
	 */
	List<Episode> getGeneralPlanning();
	
	/**
	 * Gets the general planning.
	 *
	 * @param date
	 *            the date
	 * @return the general planning
	 */
	List<Episode> getGeneralPlanning(Date date);
	
	/**
	 * Gets the general planning.
	 *
	 * @param date
	 *            the date
	 * @param before
	 *            the before
	 * @return the general planning
	 */
	List<Episode> getGeneralPlanning(Date date, int before);
	
	/**
	 * Gets the general planning.
	 *
	 * @param date
	 *            the date
	 * @param before
	 *            the before
	 * @param after
	 *            the after
	 * @return the general planning
	 */
	List<Episode> getGeneralPlanning(Date date, int before, int after);
	
	/**
	 * Gets the general planning.
	 *
	 * @param date
	 *            the date
	 * @param before
	 *            the before
	 * @param after
	 *            the after
	 * @param type
	 *            the type
	 * @return the general planning
	 */
	List<Episode> getGeneralPlanning(Date date, int before, int after, BSPlanningEpisodeType type);
	
	/**
	 * Gets the incoming planning.
	 *
	 * @return the incoming planning
	 */
	List<Episode> getIncomingPlanning();	
	
	/**
	 * Gets the member planning.
	 *
	 * @return the member planning
	 */
	List<Episode> getMemberPlanning();
	
	/**
	 * Gets the member planning.
	 *
	 * @param unseen
	 *            the unseen
	 * @return the member planning
	 */
	List<Episode> getMemberPlanning(boolean unseen);
	
	/**
	 * Gets the member planning.
	 *
	 * @param unseen
	 *            the unseen
	 * @param month
	 *            the month
	 * @return the member planning
	 */
	List<Episode> getMemberPlanning(boolean unseen, Date month);
	
	/**
	 * Gets the member planning.
	 *
	 * @param memberId
	 *            the member id
	 * @return the member planning
	 */
	List<Episode> getMemberPlanning(int memberId);
	
	/**
	 * Gets the member planning.
	 *
	 * @param memberId
	 *            the member id
	 * @param unseen
	 *            the unseen
	 * @return the member planning
	 */
	List<Episode> getMemberPlanning(int memberId, boolean unseen);
	
	/**
	 * Gets the member planning.
	 *
	 * @param memberId
	 *            the member id
	 * @param unseen
	 *            the unseen
	 * @param month
	 *            the month
	 * @return the member planning
	 */
	List<Episode> getMemberPlanning(int memberId, boolean unseen, Date month);	
}
