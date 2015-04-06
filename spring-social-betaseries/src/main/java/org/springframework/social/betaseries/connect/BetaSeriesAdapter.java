package org.springframework.social.betaseries.connect;

import org.springframework.social.ApiException;
import org.springframework.social.betaseries.api.BetaSeries;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

public class BetaSeriesAdapter implements ApiAdapter<BetaSeries> {

	public boolean test(BetaSeries betaSeries) {
		try {
			betaSeries.memberOperations().getMemberInfos();
			return true;
		}catch(ApiException e) {
			return false;
		}		
	}

	public void setConnectionValues(BetaSeries betaSeries, ConnectionValues values) {
		Member member = betaSeries.memberOperations().getMemberInfos();
		values.setProviderUserId(member.getMemberId());
		values.setDisplayName(member.getLogin());
		values.setImageUrl(member.getAvatarUrl());
		values.setProfileUrl("http://www.betaseries.com/membre/" + member.getLogin());		
	}

	public UserProfile fetchUserProfile(BetaSeries betaSeries) {
		Member memberInfo = betaSeries.memberOperations().getMemberInfos();
		return new UserProfileBuilder()
		.setUsername(memberInfo.getLogin())		
		.build();
	}

	public void updateStatus(BetaSeries api, String message) {}
}
