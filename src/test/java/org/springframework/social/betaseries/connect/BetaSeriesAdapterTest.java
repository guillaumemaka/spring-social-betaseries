package org.springframework.social.betaseries.connect;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.betaseries.api.BetaSeries;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.betaseries.api.MemberOperations;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class BetaSeriesAdapterTest {
	private BetaSeriesAdapter apiAdapter = new BetaSeriesAdapter();
	private BetaSeries betaSeries = Mockito.mock(BetaSeries.class);

	@Test
	public void fetchProfile() {
		MemberOperations memberOperations = Mockito
				.mock(MemberOperations.class);
		Mockito.when(betaSeries.memberOperations())
				.thenReturn(memberOperations);

		Member member = new Member();
		member.setMemberId("130446");
		member.setLogin("Dev040");

		Mockito.when(memberOperations.getMemberInfos()).thenReturn(member);

		UserProfile profile = apiAdapter.fetchUserProfile(betaSeries);

		Assert.assertEquals("Dev040", profile.getUsername());
	}
	
	@Test
	public void setConnectionValues()  {
		Member member = new Member();
		member.setMemberId("130446");
		member.setLogin("Dev040");
		member.setAvatarUrl("http://www.betaseries.com/data/avatars/6d/6d28adb9cb5bcc5caf7a287db71c02f6.png");
		
		MemberOperations memberOperations = Mockito
				.mock(MemberOperations.class);
		Mockito.when(betaSeries.memberOperations())
				.thenReturn(memberOperations);
		Mockito.when(memberOperations.getMemberInfos())
		.thenReturn(member);
		
		TestConnectionValues connectionValues = new TestConnectionValues();
		apiAdapter.setConnectionValues(betaSeries, connectionValues);
		
		Assert.assertEquals("Dev040", connectionValues.getDisplayName());
		Assert.assertEquals("http://www.betaseries.com/data/avatars/6d/6d28adb9cb5bcc5caf7a287db71c02f6.png", connectionValues.getImageUrl());
		Assert.assertEquals("http://www.betaseries.com/membre/Dev040", connectionValues.getProfileUrl());
		Assert.assertEquals("130446", connectionValues.getProviderUserId());
	}

	private static class TestConnectionValues implements ConnectionValues {
		private String displayName;
		private String imageUrl;
		private String profileUrl;
		private String providerUserId;

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getProfileUrl() {
			return profileUrl;
		}

		public void setProfileUrl(String profileUrl) {
			this.profileUrl = profileUrl;
		}

		public String getProviderUserId() {
			return providerUserId;
		}

		public void setProviderUserId(String providerUserId) {
			this.providerUserId = providerUserId;
		}
	}
}
