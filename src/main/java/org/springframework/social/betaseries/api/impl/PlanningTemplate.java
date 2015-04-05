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
package org.springframework.social.betaseries.api.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.social.betaseries.api.BSPlanningEpisodeType;
import org.springframework.social.betaseries.api.Episode;
import org.springframework.social.betaseries.api.PlanningOperations;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesEpisodeList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanningTemplate.
 *
 * @author Guillaume Maka
 */
public class PlanningTemplate extends AbstractBetaSeriesOperations implements
		PlanningOperations {
	
	/** The rest template. */
	private final RestTemplate restTemplate;

	/**
	 * Instantiates a new planning template.
	 *
	 * @param restTemplate the rest template
	 * @param isUserAuthorized the is user authorized
	 * @param isAppAuthorized the is app authorized
	 */
	public PlanningTemplate(RestTemplate restTemplate,
			boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getGeneralPlanning()
	 */
	public List<Episode> getGeneralPlanning() {
		return getGeneralPlanning(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getGeneralPlanning(java.util.Date)
	 */
	public List<Episode> getGeneralPlanning(Date date) {
		return getGeneralPlanning(date, -1);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getGeneralPlanning(java.util.Date, int)
	 */
	public List<Episode> getGeneralPlanning(Date date, int before) {
		return getGeneralPlanning(date, before, -1);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getGeneralPlanning(java.util.Date, int, int)
	 */
	public List<Episode> getGeneralPlanning(Date date, int before, int after) {
		return getGeneralPlanning(date, before, after, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getGeneralPlanning(java.util.Date, int, int, org.springframework.social.betaseries.api.BSPlanningEpisodeType)
	 */
	public List<Episode> getGeneralPlanning(Date date, int before, int after,
			BSPlanningEpisodeType type) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		if (date != null) {
			final String formatedDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(date);
			params.set("date", formatedDate);
		}

		if (before > 8) {
			params.set("before", String.valueOf(before));
		}

		if (after > 8) {
			params.set("after", String.valueOf(after));
		}

		if (type != null) {
			if (type != BSPlanningEpisodeType.ALL) {
				params.set("type", type.toString().toLowerCase());
			}
		}

		return restTemplate.getForObject(buildUri("planning/general", params),
				BetaSeriesEpisodeList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getIncomingPlanning()
	 */
	public List<Episode> getIncomingPlanning() {
		requireAppAuthorization();
		return restTemplate.getForObject(buildUri("planning/incoming"),
				BetaSeriesEpisodeList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getMemberPlanning()
	 */
	public List<Episode> getMemberPlanning() {
		return getMemberPlanning(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.social.betaseries.api.PlanningOperations#
	 * getMemberPlanning(boolean)
	 */
	public List<Episode> getMemberPlanning(boolean unseen) {
		return getMemberPlanning(unseen, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.social.betaseries.api.PlanningOperations#
	 * getMemberPlanning(boolean, java.util.Date)
	 */
	public List<Episode> getMemberPlanning(boolean unseen, Date month) {
		return getMemberPlanning(-1, unseen, month);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getMemberPlanning(int)
	 */
	public List<Episode> getMemberPlanning(int memberId) {
		return getMemberPlanning(memberId, false);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getMemberPlanning(int, boolean)
	 */
	public List<Episode> getMemberPlanning(int memberId, boolean unseen) {
		return getMemberPlanning(memberId, unseen, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.PlanningOperations#getMemberPlanning(int, boolean, java.util.Date)
	 */
	public List<Episode> getMemberPlanning(int memberId, boolean unseen,
			Date month) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		if (memberId != -1) {
			params.set("id", String.valueOf(memberId));
		}

		if (unseen) {
			params.set("unseen", "1");
		}

		if (month != null) {
			params.set("month", new SimpleDateFormat("yyyy-MM").format(month));
		}

		return restTemplate.getForObject(buildUri("planning/member", params),
				BetaSeriesEpisodeList.class).getList();
	}

}
