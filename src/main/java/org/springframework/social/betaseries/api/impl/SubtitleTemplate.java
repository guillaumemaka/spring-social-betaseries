package org.springframework.social.betaseries.api.impl;

import java.util.List;

import org.springframework.social.betaseries.api.BSSubtitles;
import org.springframework.social.betaseries.api.Subtitle;
import org.springframework.social.betaseries.api.SubtitleOperations;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesSubtitleList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesSubtitleSingleObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class SubtitleTemplate extends AbstractBetaSeriesOperations implements
		SubtitleOperations {
	private final RestTemplate restTemplate;
	
	public SubtitleTemplate(RestTemplate restTemplate, boolean isUserAuthorized,
			boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.SubtitleOperations#getSubtitlesForEpisode(int)
	 */
	public List<Subtitle> getSubtitlesForEpisode(int episodeId) {		
		return getSubtitlesForEpisode(episodeId, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.SubtitleOperations#getSubtitlesForEpisode(int, org.springframework.social.betaseries.api.BSSubtitles)
	 */
	public List<Subtitle> getSubtitlesForEpisode(int episodeId,
			BSSubtitles language) {
		requireAppAuthorization();		
		return restTemplate.getForObject(buildUri("subtitles/episode", buildParams(episodeId, language)), BetaSeriesSubtitleList.class).getList();
	}	

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.SubtitleOperations#getSubtitlesForShow(int)
	 */
	public List<Subtitle> getSubtitlesForShow(int showId) {
		return getSubtitlesForShow(showId, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.SubtitleOperations#getSubtitlesForShow(int, org.springframework.social.betaseries.api.BSSubtitles)
	 */
	public List<Subtitle> getSubtitlesForShow(int showId, BSSubtitles language) {
		requireAppAuthorization();
		return restTemplate.getForObject(buildUri("subtitles/show", buildParams(showId, language)), BetaSeriesSubtitleList.class).getList();
	}
	
	public List<Subtitle> getLastAddedSubtitles(){
		return getLastAddedSubtitles(-1);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.SubtitleOperations#getLastAddedSubtitles(int)
	 */
	public List<Subtitle> getLastAddedSubtitles(int number) {		
		return getLastAddedSubtitles(number, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.SubtitleOperations#getLastAddedSubtitles(int, org.springframework.social.betaseries.api.BSSubtitles)
	 */
	public List<Subtitle> getLastAddedSubtitles(int number, BSSubtitles language) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if(number > 10) 
			params.set("number", String.valueOf(number));
		
		if(language != null) {
			if (language != BSSubtitles.ALL) {
				params.set("language", language.toString().toLowerCase());
			}
		}
		
		return restTemplate.getForObject(buildUri("subtitles/last", params), BetaSeriesSubtitleList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.SubtitleOperations#reportIncorrectSubtitle(int, java.lang.String)
	 */
	public Subtitle reportIncorrectSubtitle(int subtitleId, String reason) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(subtitleId));
		params.set("reason", reason);
		return restTemplate.postForObject(buildUri("subtitles/report"), params, BetaSeriesSubtitleSingleObject.class).getObject();
	}
	
	private MultiValueMap<String, String> buildParams(int elementId, BSSubtitles language) {
		final MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(elementId));
		
		if(language != null) {
			if (language != BSSubtitles.ALL) {
				params.set("language", language.toString().toLowerCase());
			}
		}
		
		return params;
	}
}
