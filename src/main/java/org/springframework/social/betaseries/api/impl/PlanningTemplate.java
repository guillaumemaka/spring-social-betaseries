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

public class PlanningTemplate extends AbstractBetaSeriesOperations implements
		PlanningOperations {
	private final RestTemplate restTemplate;

	/**
	 * @param isUserAuthorized
	 * @param isAppAuthorized
	 */
	public PlanningTemplate(RestTemplate restTemplate,
			boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}

	public List<Episode> getGeneralPlanning() {
		return getGeneralPlanning(null);
	}

	public List<Episode> getGeneralPlanning(Date date) {
		return getGeneralPlanning(date, -1);
	}

	public List<Episode> getGeneralPlanning(Date date, int before) {
		return getGeneralPlanning(date, before, -1);
	}

	public List<Episode> getGeneralPlanning(Date date, int before, int after) {
		return getGeneralPlanning(date, before, after, null);
	}

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

	public List<Episode> getIncomingPlanning() {
		requireAppAuthorization();
		return restTemplate.getForObject(buildUri("planning/incoming"),
				BetaSeriesEpisodeList.class).getList();
	}

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

	public List<Episode> getMemberPlanning(int memberId) {
		return getMemberPlanning(memberId, false);
	}

	public List<Episode> getMemberPlanning(int memberId, boolean unseen) {
		return getMemberPlanning(memberId, unseen, null);
	}

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
