package org.springframework.social.betaseries.api.impl;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.social.betaseries.api.BSSearchOrder;
import org.springframework.social.betaseries.api.BSShowOrder;
import org.springframework.social.betaseries.api.Character;
import org.springframework.social.betaseries.api.Episode;
import org.springframework.social.betaseries.api.Picture;
import org.springframework.social.betaseries.api.Recommendation;
import org.springframework.social.betaseries.api.Show;
import org.springframework.social.betaseries.api.ShowOperations;
import org.springframework.social.betaseries.api.SimilarShow;
import org.springframework.social.betaseries.api.Video;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesCharacterList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesEpisodeList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesPictureList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesRatedShowList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesRecommendationList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesRecommendationSingleObject;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesShowList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesShowSingleObject;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesSimilarShowList;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesVideoList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class ShowTemplate extends AbstractBetaSeriesOperations implements
		ShowOperations {
	private final RestTemplate restTemplate;
	
	public ShowTemplate(RestTemplate restTemplate, boolean isUserAuthorized, boolean isAppAuthorized) {
		super(isUserAuthorized, isAppAuthorized);
		this.restTemplate = restTemplate;
	}

	public Show archive(int showId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.postForObject(buildUri("shows/archive"), params, BetaSeriesShowSingleObject.class).getObject();
	}

	public Show unarchive(int showId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.exchange(buildUri("shows/archive", params), HttpMethod.DELETE, null, BetaSeriesShowSingleObject.class).getBody().getObject();
	}

	public List<Character> getCharacters(int showId) {
		requireAppAuthorization();		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.getForObject(buildUri("shows/characters", params), BetaSeriesCharacterList.class).getList();
	}

	public Show getShow(int showId) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.getForObject(buildUri("shows/display", params), BetaSeriesShowSingleObject.class).getObject();
	}

	public List<Show> getShows(String... showIds) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", StringUtils.arrayToCommaDelimitedString(showIds));
		return restTemplate.getForObject(buildUri("shows/display", params), BetaSeriesShowList.class).getList();
	}

	public List<Episode> getShowEpisodes(int showId) {		
		return getShowEpisodes(showId, 0);
	}

	public List<Episode> getShowEpisodes(int showId, int seasonNumber) {		
		return getShowEpisodes(showId, seasonNumber, 0);
	}

	public List<Episode> getShowEpisodes(int showId, int seasonNumber,
			int episodeNumber) {		
		return getShowEpisodes(showId, seasonNumber, episodeNumber, false);
	}

	public List<Episode> getShowEpisodes(int showId, int seasonNumber,
			int episodeNumber, boolean includeSubtitles) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		
		if (seasonNumber > 0) {
			params.set("season", String.valueOf(seasonNumber));
		}
		
		if (episodeNumber > 0) {
			params.set("episode", String.valueOf(episodeNumber));
		}
		
		if(includeSubtitles) {
			params.set("subtitles", String.valueOf(includeSubtitles ? 1 : 0));
		}
		
		return restTemplate.getForObject(buildUri("shows/episodes", params), BetaSeriesEpisodeList.class).getList();
	}

	public Show addToFavorite(int showId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.postForObject(buildUri("shows/favorite"), params, BetaSeriesShowSingleObject.class).getObject();
	}

	public Show removeFromFavorite(int showId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.exchange(buildUri("shows/favorite", params), HttpMethod.DELETE, null, BetaSeriesShowSingleObject.class).getBody().getObject();
	}

	public List<Show> getFavoritesShow() {		
		return getFavoritesShow(null);
	}

	public List<Show> getFavoritesShow(Long memberId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if(memberId != null) {
			params.set("id", String.valueOf(memberId));
		}
		
		return restTemplate.getForObject(buildUri("shows/favorites", params), BetaSeriesShowList.class).getList();
	}

	public List<Show> list() {
		return list(null);
	}

	public List<Show> list(BSShowOrder order) {		
		return list(order, null);
	}

	public List<Show> list(BSShowOrder order, Date sinceDate) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if (order != null) {
			params.set("order", order.toString().toLowerCase());
		}
		
		if(sinceDate != null) {			
			params.set("since", String.valueOf(sinceDate.getTime()));
		}
		
		return restTemplate.getForObject(buildUri("shows/list", params), BetaSeriesShowList.class).getList();
	}

	public List<Show> rateShow(int showId, int note) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		params.set("note", String.valueOf(note));
		return restTemplate.postForObject(buildUri("shows/note"), params, BetaSeriesRatedShowList.class).getList();
	}

	public List<Show> unRateShow(int showId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.exchange(buildUri("shows/note", params), HttpMethod.DELETE, null, BetaSeriesRatedShowList.class).getBody().getList();
	}

	public List<Picture> getShowPictures(int showId) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.getForObject(buildUri("shows/pictures", params), BetaSeriesPictureList.class).getList();
	}

	public List<Show> getRandomShow() {		
		return getRandomShow(1);
	}

	public List<Show> getRandomShow(int limit) {		
		return getRandomShow(limit, false);
	}

	public List<Show> getRandomShow(int limit, boolean summary) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		if(limit > 1) {
			params.set("nb", String.valueOf(limit));
		}
		
		if(summary) {
			params.set("summary", String.valueOf(summary ? 1 : 0));
		}
		
		return restTemplate.getForObject(buildUri("shows/random", params), BetaSeriesShowList.class).getList();
	}

	public Recommendation sendRecommendation(int showId, int toMemberId) {		
		return sendRecommendation(showId, toMemberId, null);
	}

	public Recommendation sendRecommendation(int showId, int toMemberId, String comments) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		params.set("to", String.valueOf(toMemberId));
		
		if(comments != null) {
			if(!comments.isEmpty()) {
				params.set("comments", comments);
			}
		}
		
		return restTemplate.postForObject(buildUri("shows/recommendation"), params, BetaSeriesRecommendationSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#getRecommendations()
	 */
	public List<Recommendation> getRecommendations() {
		requireEitherUserOrAppAuthorization();		
		return restTemplate.getForObject(buildUri("shows/recommendations"), BetaSeriesRecommendationList.class).getList();
	}

	public Recommendation deleteRecomendation(int recomendationId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(recomendationId));
		return restTemplate.exchange(buildUri("shows/recommendation", params), HttpMethod.DELETE, null, BetaSeriesRecommendationSingleObject.class).getBody().getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#search(java.lang.String)
	 */
	public List<Show> search(String title) {		
		return search(title, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#search(java.lang.String, org.springframework.social.betaseries.api.BSShowSearchOrder)
	 */
	public List<Show> search(String title, BSSearchOrder order) {		
		return search(title, order, 5);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#search(java.lang.String, org.springframework.social.betaseries.api.BSShowSearchOrder, int)
	 */
	public List<Show> search(String title, BSSearchOrder order, int nbpp) {		
		return search(title, order, nbpp, 1);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#search(java.lang.String, org.springframework.social.betaseries.api.BSShowSearchOrder, int, int)
	 */
	public List<Show> search(String title, BSSearchOrder order, int nbpp,
			int page) {		
		return search(title, order, nbpp, page, false);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#search(java.lang.String, org.springframework.social.betaseries.api.BSShowSearchOrder, int, int, boolean)
	 */
	public List<Show> search(String title, BSSearchOrder order, int nbpp,
			int page, boolean summary) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("title", title);
		
		if (order != null) {
			if (order != BSSearchOrder.TITLE) {
				params.set("order", order.toString().toLowerCase());
			}
		}
		
		if (nbpp > 5 && nbpp <= 100) {
			params.set("nbpp", String.valueOf(nbpp));
		}
		
		if (page > 1) {
			params.set("page", String.valueOf(page));
		}
		
		if(summary) {
			params.set("summary", "1");
		}
		
		return restTemplate.getForObject(buildUri("shows/search", params), BetaSeriesShowList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#getSimilarsShow(int)
	 */
	public List<SimilarShow> getSimilarsShow(int showId) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		return restTemplate.getForObject(buildUri("shows/similars", params)	, BetaSeriesSimilarShowList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#addShowTagsShow(int, java.lang.String[])
	 */
	public Show addShowTagsShow(int showId, String... tags) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		params.set("id", String.valueOf(showId));
		params.set("tags", StringUtils.arrayToCommaDelimitedString(tags));
		return restTemplate.postForObject(buildUri("shows/tags"), params, BetaSeriesShowSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#getShowVideos(int)
	 */
	public List<Video> getShowVideos(int showId) {
		requireAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));		
		return restTemplate.getForObject(buildUri("shows/videos", params), BetaSeriesVideoList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#addShow(int)
	 */
	public Show addShow(int showId) {		
		return addShow(showId, -1);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#addShow(int, int)
	 */
	public Show addShow(int showId, int lastSeenEpisodeId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		
		if (lastSeenEpisodeId != -1) {
			params.set("episode_id", String.valueOf(lastSeenEpisodeId));
		}
		
		return restTemplate.postForObject(buildUri("shows/show"), params, BetaSeriesShowSingleObject.class).getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#addShows(int[])
	 */
	public List<Show> addShows(String[] showIds) {		
		return addShows(showIds, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#addShows(int[], int[])
	 */
	public List<Show> addShows(String[] showIds, String[] lastSeenEpisodeIds) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("id", StringUtils.arrayToCommaDelimitedString(showIds));
		
		if (lastSeenEpisodeIds != null) {
			params.set("episode_id", StringUtils.arrayToCommaDelimitedString(lastSeenEpisodeIds));
		}
		
		return restTemplate.postForObject(buildUri("shows/show"), params, BetaSeriesShowList.class).getList();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#removeShow(int)
	 */
	public Show removeShow(int showId) {		
		return removeShow(showId, -1);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#removeShow(int, int)
	 */
	public Show removeShow(int showId, int lastSeenEpisodeId) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", String.valueOf(showId));
		
		if (lastSeenEpisodeId != -1) {
			params.set("episode_id", String.valueOf(lastSeenEpisodeId));
		}
		
		return restTemplate.exchange(buildUri("shows/show", params), HttpMethod.DELETE, null, BetaSeriesShowSingleObject.class).getBody().getObject();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#removeShows(java.lang.String[])
	 */
	public List<Show> removeShows(String[] showIds) {		
		return removeShows(showIds, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.betaseries.api.ShowOperations#removeShows(java.lang.String[], java.lang.String[])
	 */
	public List<Show> removeShows(String[] showIds, String[] lastSeenEpisodeIds) {
		requireEitherUserOrAppAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.set("id", StringUtils.arrayToCommaDelimitedString(showIds));
		
		if (lastSeenEpisodeIds != null) {
			params.set("episode_id", StringUtils.arrayToCommaDelimitedString(lastSeenEpisodeIds));
		}
		
		return restTemplate.exchange(buildUri("shows/show", params), HttpMethod.DELETE, null, BetaSeriesShowList.class).getBody().getList();
	}	
}
