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
package org.springframework.social.betaseries.api;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberTemplateTest.
 *
 * @author Guillaume Maka
 */
public class MemberTemplateTest extends AbstractBetaSeriesApiTest {

	/**
	 * Members_get member infos_test.
	 */
	@Test
	public void members_getMemberInfos_test() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/members/infos").andRespond(
				withSuccess().body(jsonResource("members-infos")).contentType(
						MediaType.APPLICATION_JSON));
		// Member assertions
		Member member = betaSeries.memberOperations().getMemberInfos();
		assertMember(member);

		// Stats assertions
		assertMemberStats(member);

		// Show assertions
		Show show = member.getShows().get(0);
		assertShow(show);

		// Movie assertions
		Movie movie = member.getMovies().get(0);
		assertMovie(movie);
	}

	/**
	 * Members_is active success test.
	 */
	@Test
	public void members_isActiveSuccessTest() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/members/is_active").andRespond(
				withSuccess().body(jsonResource("members-is-active-200")).contentType(
						MediaType.APPLICATION_JSON));

		Assert.assertTrue(betaSeries.memberOperations().isActive());
	}
	
	/**
	 * Members_is active fail test.
	 */
	@Test
	public void members_isActiveFailTest() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/members/is_active").andRespond(
				withBadRequest().body(jsonResource("members-is-active-400")).contentType(
						MediaType.APPLICATION_JSON));

		Assert.assertFalse(betaSeries.memberOperations().isActive());
	}
	
	/**
	 * Members_get badges test.
	 */
	@Test
	public void members_getBadgesTest() {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/members/badges?id=130446")
		.andRespond(withSuccess().body(jsonResource("members-badges")).contentType(MediaType.APPLICATION_JSON));
		
		List<Badge> badges = betaSeries.memberOperations().getBadges("130446");
		Badge badge = badges.get(0);
		Assert.assertNotNull(badges);
		Assert.assertEquals(25, badges.size());
		Assert.assertEquals(new Long(148), badge.getId());
		Assert.assertEquals("flashmob", badge.getCode());
		Assert.assertEquals("Flashmob", badge.getName());
		Assert.assertEquals("Vous avez regardé le même épisode que 75 personnes ce jour-là, vous êtes à la mode.", badge.getDescription());
		Assert.assertEquals(dateFromString("2012-04-16 00:26:21", "yyyy-MM-dd HH:mm:ss"), badge.getDate());
	}
	
	
	/**
	 * Members_get notifications test.
	 */
	@Test
	public void members_getNotificationsTest() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/members/notifications").andRespond(
				withSuccess().body(jsonResource("members-notifications"))
						.contentType(MediaType.APPLICATION_JSON));

		List<Notification> notifications = betaSeries.memberOperations()
				.getNotifications();
		Notification notif = notifications.get(0);
		Assert.assertEquals(10, notifications.size());
		Assert.assertEquals(notif.getClass(), Notification.class);
		Assert.assertEquals(new Long(252644325), notif.getId());
		Assert.assertEquals(BSNotificationType.EPISODE, notif.getType());
		Assert.assertEquals("417761", notif.getRefId());
		Assert.assertEquals(
				"Nouvel épisode : Fairy Tail S05E32 - Stand, Hisui",
				notif.getText());
		Assert.assertEquals(
				"Nouvel épisode : <a href=\"/serie/fairytail\">Fairy Tail</a> S05E32 - Stand, Hisui",
				notif.getHtml());
		Assert.assertEquals(
				dateFromString("2014-11-09 00:03:16", "yyyy-MM-dd HH:mm:ss"),
				notif.getDate());
		Assert.assertFalse(notif.isSeen());
	}

//	@Test
//	public void members_getNotificationsSinceId252676676Test() {
//		constructGetMockRequest(mockServer,
//				"https://api.betaseries.com/members/notifications?since_id=252676676")
//				.andRespond(
//						withSuccess()
//								.body(jsonResource("members-notifications-sinceId-252676676"))
//								.contentType(MediaType.APPLICATION_JSON));
//
//		List<Notification> notifications = betaSeries.memberOperations()
//				.getNotifications("252676676");
//		Notification notif = notifications.get(0);
//		Assert.assertEquals(10, notifications.size());
//		Assert.assertEquals(notif.getClass(), Notification.class);
//		Assert.assertEquals(new Long(252784478), notif.getId());
//		Assert.assertEquals(BSNotificationType.EPISODE, notif.getType());
//		Assert.assertEquals("395858", notif.getRefId());
//		Assert.assertEquals(
//				"Nouvel épisode : The Simpsons S26E06 - Simpsorama",
//				notif.getText());
//		Assert.assertEquals(
//				"Nouvel épisode : <a href=\"/serie/simpsons\">The Simpsons</a> S26E06 - Simpsorama",
//				notif.getHtml());
//		Assert.assertEquals(
//				dateFromString("2014-11-10 01:00:53", "yyyy-MM-dd HH:mm:ss"),
//				notif.getDate());
//		Assert.assertFalse(notif.isSeen());
//	}
//
//	@Test
//	public void members_getNotificationsSinceId252676676Number3Test() {
//		constructGetMockRequest(mockServer,
//				"https://api.betaseries.com/members/notifications?since_id=252676676&number=3")
//				.andRespond(
//						withSuccess()
//								.body(jsonResource("members-notifications-sinceId-252676676-3"))
//								.contentType(MediaType.APPLICATION_JSON));
//
//		List<Notification> notifications = betaSeries.memberOperations()
//				.getNotifications("252676676", "3");
//		Notification notif = notifications.get(0);
//		Assert.assertEquals(3, notifications.size());
//		Assert.assertEquals(notif.getClass(), Notification.class);
//		Assert.assertEquals(new Long(252784478), notif.getId());
//		Assert.assertEquals(BSNotificationType.EPISODE, notif.getType());
//		Assert.assertEquals("395858", notif.getRefId());
//		Assert.assertEquals(
//				"Nouvel épisode : The Simpsons S26E06 - Simpsorama",
//				notif.getText());
//		Assert.assertEquals(
//				"Nouvel épisode : <a href=\"/serie/simpsons\">The Simpsons</a> S26E06 - Simpsorama",
//				notif.getHtml());
//		Assert.assertEquals(
//				dateFromString("2014-11-10 01:00:53", BS_DATE_AND_TIME_FORMAT),
//				notif.getDate());
//		Assert.assertFalse(notif.isSeen());
//	}
//
//	@Test
//	public void members_getNotificationsSinceId252676676Number3SortASCTest() {
//		constructGetMockRequest(
//				mockServer,
//				"https://api.betaseries.com/members/notifications?since_id=252676676&number=3&sort=asc")
//				.andRespond(
//						withSuccess()
//								.body(jsonResource("members-notifications-sinceId-252676676-3"))
//								.contentType(MediaType.APPLICATION_JSON));
//
//		List<Notification> notifications = betaSeries.memberOperations()
//				.getNotifications("252676676", "3", BSSortOrder.ASC);
//		Notification notif1 = notifications.get(0);
//		Notification notif2 = notifications.get(1);
//		Assert.assertEquals(3, notifications.size());
//		Assert.assertEquals(notif1.getClass(), Notification.class);
//		Assert.assertEquals(notif2.getClass(), Notification.class);
//
//		Assert.assertEquals(new Long(252784478), notif1.getId());
//		Assert.assertEquals(new Long(252813774), notif2.getId());
//
//		Assert.assertEquals(BSNotificationType.EPISODE, notif1.getType());
//		Assert.assertEquals(BSNotificationType.EPISODE, notif2.getType());
//
//		Assert.assertEquals("395858", notif1.getRefId());
//		Assert.assertEquals("413678", notif2.getRefId());
//
//		Assert.assertEquals(
//				"Nouvel épisode : The Simpsons S26E06 - Simpsorama",
//				notif1.getText());
//		Assert.assertEquals(
//				"Nouvel épisode : Family Guy S13E04 - Brian the Closer",
//				notif2.getText());
//
//		Assert.assertEquals(
//				"Nouvel épisode : <a href=\"/serie/simpsons\">The Simpsons</a> S26E06 - Simpsorama",
//				notif1.getHtml());
//		Assert.assertEquals(
//				"Nouvel épisode : <a href=\"/serie/familyguy\">Family Guy</a> S13E04 - Brian the Closer",
//				notif2.getHtml());
//
//		Assert.assertEquals(
//				dateFromString("2014-11-10 01:00:53", BS_DATE_AND_TIME_FORMAT),
//				notif1.getDate());
//
//		Assert.assertEquals(
//				dateFromString("2014-11-10 01:23:00", BS_DATE_AND_TIME_FORMAT),
//				notif2.getDate());
//
//		Assert.assertTrue(notif2.getDate().after(notif1.getDate()));
//
//		Assert.assertFalse(notif1.isSeen());
//		Assert.assertFalse(notif2.isSeen());
//	}

	/**
 * Members_get options test.
 */
@Test
	public void members_getOptionsTest() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/members/options").andRespond(
				withSuccess().body(jsonResource("members-options"))
						.contentType(MediaType.APPLICATION_JSON));

		BSOptions options = betaSeries.memberOperations().getMemberOptions();

		Assert.assertEquals(5, options.getSources().size());
		Assert.assertTrue(options.isDownloadedEnabled());
		Assert.assertTrue(options.isNotationEnabled());
		Assert.assertFalse(options.isGlobalEnabled());
		Assert.assertFalse(options.isFriendshipEnabled());

		SubtitleSource source = options.getSources().get(0);
		Assert.assertEquals("addic7ed", source.getName());
		Assert.assertTrue(source.isEnabled());
	}

	/**
	 * Members_search raise3002 exception.
	 */
	@Test(expected = MalfornedTermException.class)
	public void members_searchRaise3002Exception() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/members/search?login=b")
				.andRespond(
						withBadRequest().body(
								jsonResource("error-3002-variables"))
								.contentType(MediaType.APPLICATION_JSON));

		betaSeries.memberOperations().search("b");
	}

	/**
	 * Members_search test.
	 */
	@Test
	public void members_searchTest() {
		constructGetMockRequest(mockServer,
				"https://api.betaseries.com/members/search?login=b%")
				.andRespond(
						withSuccess().body(jsonResource("members-search"))
								.contentType(MediaType.APPLICATION_JSON));

		List<BSUser> result = betaSeries.memberOperations().search(
				"b%");
		BSUser user = result.get(0);

		Assert.assertEquals(10, result.size());
		Assert.assertEquals(new Integer(257344), user.getId());
		Assert.assertEquals("BL", user.getLogin());
		Assert.assertFalse(user.isInAccount());
	}

	/**
	 * Members_simple authentication test.
	 */
	@Test
	public void members_simpleAuthenticationTest() {
		constructPostMockRequest(mockServer,
				"https://api.betaseries.com/members/auth").andRespond(
				withSuccess().body(jsonResource("members-auth")).contentType(
						MediaType.APPLICATION_JSON));

		BSAuthObject auth = betaSeries.memberOperations().simpleAuthentication(
				"Dev040", "developer");
		Assert.assertNotNull(auth);
		Assert.assertEquals("Dev040", auth.getLogin());
		Assert.assertEquals("26978", auth.getUserId());
		Assert.assertFalse(auth.isInAccount());
		Assert.assertEquals("2d6ede7f318c", auth.getToken());
		Assert.assertEquals("5e8edd851d2fdfbd7415232c67367cc3", auth.getHash());
	}

	/**
	 * Members_upload avatar test.
	 */
	@Test
	public void members_uploadAvatarTest() {
		Resource avatar = new ClassPathResource("avatar.png", getClass());

		constructPostMockRequest(mockServer,
				"https://api.betaseries.com/members/avatar").andRespond(
				withSuccess().body(jsonResource("members-upload-avatar"))
						.contentType(MediaType.APPLICATION_JSON));

		betaSeries.memberOperations().uploadAvatar(avatar);				
	}
	
	/**
	 * Members_delete avatar test.
	 */
	@Test
	public void members_deleteAvatarTest() {
		constructDeleteMockRequest(mockServer, "https://api.betaseries.com/members/avatar")
		.andRespond(withSuccess().body(jsonResource("members-upload-avatar")).contentType(MediaType.APPLICATION_JSON));
		
		Member member = betaSeries.memberOperations().deleteAvatar();
		
		Assert.assertNotNull(member);
		Assert.assertEquals("Dev040", member.getLogin());
	}
	
	/**
	 * Members_sign up test.
	 */
	@Test
	public void members_signUpTest() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/members/signup")
		.andRespond(withSuccess().body(jsonResource("members-signup")).contentType(MediaType.APPLICATION_JSON));
		
		BSAuthObject newUser = betaSeries.memberOperations().signUp("blackstones1", "134508@supinfo.com");
		
		Assert.assertNotNull(newUser);
		Assert.assertEquals("blackstones1", newUser.getLogin());
		Assert.assertEquals("496919", newUser.getUserId());
		Assert.assertFalse(newUser.isInAccount());
		Assert.assertEquals("ae56ec6a5d4c", newUser.getToken());
		Assert.assertEquals("da664dbd14838cb385e5ef7cad8858ef", newUser.getHash());
	}
	
	/**
	 * Members_sync test.
	 */
	@Test
	public void members_syncTest() {
		constructPostMockRequest(mockServer, "https://api.betaseries.com/members/sync")
		.andRespond(withSuccess().body(jsonResource("members-sync")).contentType(MediaType.APPLICATION_JSON));
		
		List<BSUser> users = betaSeries.memberOperations().sync(new String[] {"user@example.com"});
		BSUser user = users.get(0);
		
		Assert.assertEquals(new Integer(130446), user.getId());	
		Assert.assertEquals("blackstones", user.getLogin());
		Assert.assertTrue(user.isInAccount());//		
	}	

	/**
	 * Assert member stats.
	 *
	 * @param member the member
	 */
	private void assertMemberStats(Member member) {
		Assert.assertEquals(2, member.getStats().getNumberOfFriends());
		Assert.assertEquals(2, member.getStats().getNumberOfFriends());
		Assert.assertEquals(334, member.getStats().getNumberOfShows());
		Assert.assertEquals(403, member.getStats().getNumberOfSeasons());
		Assert.assertEquals(9362, member.getStats().getNumberOfEpisodes());
		Assert.assertEquals(91.34, member.getStats().getProgress(), 91.34);
		Assert.assertEquals(888, member.getStats().getEpisodesToWatch());
		Assert.assertEquals(321055, member.getStats().getTimeOnTv());
		Assert.assertEquals(28885, member.getStats().getTimeToSpend());
		Assert.assertEquals(25, member.getStats().getBadges());
	}

	/**
	 * Assert member.
	 *
	 * @param member the member
	 */
	private void assertMember(Member member) {
		Assert.assertNotNull("member should not be null", member);
		Assert.assertEquals("130446", member.getMemberId());
		Assert.assertEquals("blackstones", member.getLogin());
		Assert.assertEquals(1140, member.getXp());
		Assert.assertEquals(1419548928, member.getCached());
		Assert.assertEquals(
				"http://www.betaseries.com/data/avatars/6d/6d28adb9cb5bcc5caf7a287db71c02f6.png",
				member.getAvatarUrl());
		Assert.assertTrue(member.getShows().size() > 0);
		Assert.assertEquals(334, member.getShows().size());
		Assert.assertEquals(45, member.getMovies().size());
		Assert.assertTrue(member.getMovies().size() > 0);
		Assert.assertFalse(member.getOptions().isDownloadedEnabled());
		Assert.assertFalse(member.getOptions().isNotationEnabled());
		Assert.assertFalse(member.getOptions().isGlobalEnabled());
		Assert.assertEquals(BSMemberOptionValue.OPEN, member.getOptions()
				.getFriendshipStatus());
	}

	/**
	 * Assert show.
	 *
	 * @param show the show
	 */
	private void assertShow(Show show) {
		Assert.assertEquals(9, show.getId());
		Assert.assertEquals(76290, show.getTheTvDbId());
		Assert.assertEquals("tt0285331", show.getImDbId());
		Assert.assertEquals("24", show.getTitle());
		Assert.assertEquals("9", show.getNumberOfSeasons());
		Assert.assertEquals(9, show.getSeasonsDetails().size());
		Assert.assertEquals("205", show.getNumberOfEpisodes());
		Assert.assertEquals("20289", show.getNumberOfFollowers());
		Assert.assertEquals("150", show.getNumberOfComments());
		Assert.assertEquals("23", show.getSimilars());
		Assert.assertEquals("3", show.getCharacters());
		Assert.assertEquals("2001", show.getYearsOfProduction());
		Assert.assertArrayEquals(new String[] { "Action", "Adventure", "Drama",
				"Thriller" }, show.getGenres());
		Assert.assertEquals("60", show.getEpisodeLength());
		Assert.assertEquals("FOX", show.getNetwork());
		Assert.assertEquals("TV-14", show.getRating());
		Assert.assertEquals("", show.getStatus());
		Assert.assertEquals("en", show.getLanguage());
		Assert.assertNotNull(show.getNote());
		Assert.assertEquals(741, show.getNote().getTotal(), 741);
		Assert.assertEquals(4.3684, show.getNote().getAverage(), 4.3684);
		Assert.assertEquals(0, show.getNote().getUserNote(), 0);
		Assert.assertEquals(4.3684, show.getNote().getAverage(), 4.3684);
	}

	/**
	 * Assert movie.
	 *
	 * @param movie the movie
	 */
	private void assertMovie(Movie movie) {
		Assert.assertEquals(new Integer(409), movie.getId());
		Assert.assertEquals("Very Bad Trip 2", movie.getTitlw());
		Assert.assertEquals("The Hangover Part II", movie.getOriginalTitlw());
		Assert.assertEquals(45243, movie.getTheMovieDbId());
		Assert.assertEquals("tt1411697", movie.getImDbId());
		Assert.assertEquals("very-bad-trip-2", movie.getUrl());
		Assert.assertEquals(
				"http://www.betaseries.com/images/affiches/409.jpg",
				movie.getPosterUrl());
		Assert.assertEquals("2011", movie.getProductionYear());
		Assert.assertEquals(dateFromString("2011-05-25"),
				movie.getReleaseDate());
		Assert.assertEquals(dateFromString("0000-00-00"), movie.getSaleDate());
		Assert.assertEquals("2011", movie.getProductionYear());
		Assert.assertEquals("Todd Phillips", movie.getDirector());
		Assert.assertEquals("6120", movie.getLength());
		Assert.assertArrayEquals(new String[] { "Comédie" }, movie.getGenres());
		Assert.assertEquals(
				"Phil, Stu, Alan et Doug s’offrent un voyage exotique en Thaïlande, à l’occasion du mariage de Stu. Après l’inoubliable soirée d’enterrement de sa vie de garçon à Las Vegas, Stu ne veut rien laisser au hasard et opte pour un brunch léger, sans risque, avant la cérémonie. Mais les choses ne se passent pas toujours comme prévu. Ce qui s'est passé à Las Vegas est imaginable à Las Vegas, mais ce qui se passe à Bangkok dépasse l’imagination...",
				movie.getSynopsis());
		Assert.assertEquals("Anglais", movie.getLanguage());
		Assert.assertEquals(1367, movie.getNote().getTotal(), 1367);
		Assert.assertEquals(3.3358, movie.getNote().getAverage(), 3.3358);
		Assert.assertEquals(0, movie.getNote().getUserNote(), 0);
		Assert.assertEquals(0, movie.getFollowers());
		Assert.assertTrue(movie.getUserDetail().isInAccount());
		Assert.assertEquals(BSMovieUserState.SEEN, movie.getUserDetail().getStatus());
	}
}
