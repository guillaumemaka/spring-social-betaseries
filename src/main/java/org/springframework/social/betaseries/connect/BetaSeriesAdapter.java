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
package org.springframework.social.betaseries.connect;

import org.springframework.social.ApiException;
import org.springframework.social.betaseries.api.BetaSeries;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesAdapter.
 *
 * @author Guillaume Maka
 */
public class BetaSeriesAdapter implements ApiAdapter<BetaSeries> {

	/* (non-Javadoc)
	 * @see org.springframework.social.connect.ApiAdapter#test(java.lang.Object)
	 */
	public boolean test(BetaSeries betaSeries) {
		try {
			betaSeries.memberOperations().getMemberInfos();
			return true;
		}catch(ApiException e) {
			return false;
		}		
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.connect.ApiAdapter#setConnectionValues(java.lang.Object, org.springframework.social.connect.ConnectionValues)
	 */
	public void setConnectionValues(BetaSeries betaSeries, ConnectionValues values) {
		Member member = betaSeries.memberOperations().getMemberInfos();
		values.setProviderUserId(member.getMemberId());
		values.setDisplayName(member.getLogin());
		values.setImageUrl(member.getAvatarUrl());
		values.setProfileUrl("http://www.betaseries.com/membre/" + member.getLogin());		
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.connect.ApiAdapter#fetchUserProfile(java.lang.Object)
	 */
	public UserProfile fetchUserProfile(BetaSeries betaSeries) {
		Member memberInfo = betaSeries.memberOperations().getMemberInfos();
		return new UserProfileBuilder()
		.setUsername(memberInfo.getLogin())		
		.build();
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.connect.ApiAdapter#updateStatus(java.lang.Object, java.lang.String)
	 */
	public void updateStatus(BetaSeries api, String message) {}
}
