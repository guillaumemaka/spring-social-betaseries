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
package org.springframework.social.betaseries.connect;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.betaseries.api.BetaSeries;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.betaseries.api.MemberOperations;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesAdapterTest.
 *
 * @author Guillaume Maka
 */
public class BetaSeriesAdapterTest {
	
	/** The api adapter. */
	private BetaSeriesAdapter apiAdapter = new BetaSeriesAdapter();
	
	/** The beta series. */
	private BetaSeries betaSeries = Mockito.mock(BetaSeries.class);

	/**
	 * Fetch profile.
	 */
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
	
	/**
	 * Sets the connection values.
	 */
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

	/**
	 * The Class TestConnectionValues.
	 *
	 * @author Guillaume Maka
	 */
	private static class TestConnectionValues implements ConnectionValues {
		
		/** The display name. */
		private String displayName;
		
		/** The image url. */
		private String imageUrl;
		
		/** The profile url. */
		private String profileUrl;
		
		/** The provider user id. */
		private String providerUserId;

		/**
		 * Gets the display name.
		 *
		 * @return the display name
		 */
		public String getDisplayName() {
			return displayName;
		}

		/* (non-Javadoc)
		 * @see org.springframework.social.connect.ConnectionValues#setDisplayName(java.lang.String)
		 */
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		/**
		 * Gets the image url.
		 *
		 * @return the image url
		 */
		public String getImageUrl() {
			return imageUrl;
		}

		/* (non-Javadoc)
		 * @see org.springframework.social.connect.ConnectionValues#setImageUrl(java.lang.String)
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		/**
		 * Gets the profile url.
		 *
		 * @return the profile url
		 */
		public String getProfileUrl() {
			return profileUrl;
		}

		/* (non-Javadoc)
		 * @see org.springframework.social.connect.ConnectionValues#setProfileUrl(java.lang.String)
		 */
		public void setProfileUrl(String profileUrl) {
			this.profileUrl = profileUrl;
		}

		/**
		 * Gets the provider user id.
		 *
		 * @return the provider user id
		 */
		public String getProviderUserId() {
			return providerUserId;
		}

		/* (non-Javadoc)
		 * @see org.springframework.social.connect.ConnectionValues#setProviderUserId(java.lang.String)
		 */
		public void setProviderUserId(String providerUserId) {
			this.providerUserId = providerUserId;
		}
	}
}
