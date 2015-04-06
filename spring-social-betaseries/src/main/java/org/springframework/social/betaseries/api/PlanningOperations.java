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

import java.util.Date;
import java.util.List;

/**
 * The Interface PlanningOperations.
 * 
 * @author Guillaume Maka
 */
public interface PlanningOperations {
	List<Episode> getGeneralPlanning();
	List<Episode> getGeneralPlanning(Date date);
	List<Episode> getGeneralPlanning(Date date, int before);
	List<Episode> getGeneralPlanning(Date date, int before, int after);
	List<Episode> getGeneralPlanning(Date date, int before, int after, BSPlanningEpisodeType type);
	List<Episode> getIncomingPlanning();	
	List<Episode> getMemberPlanning();
	List<Episode> getMemberPlanning(boolean unseen);
	List<Episode> getMemberPlanning(boolean unseen, Date month);
	List<Episode> getMemberPlanning(int memberId);
	List<Episode> getMemberPlanning(int memberId, boolean unseen);
	List<Episode> getMemberPlanning(int memberId, boolean unseen, Date month);	
}
