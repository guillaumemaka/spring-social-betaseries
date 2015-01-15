package org.springframework.social.betaseries.api;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.social.MissingAuthorizationException;


public class ErrorHandlingTest extends AbstractBetaSeriesApiTest {
	@Test(expected=MissingAuthorizationException.class)
	public void unauthorizedAccessTokenTest() {
		unauthorizedMockServer.expect(requestTo("https://api.betaseries.com/members/infos"))
		.andExpect(header(HEADER_API_KEY_PARAMS_NAME, "someApiKey"))
		.andExpect(header(HEADER_ACCESS_TOKEN_PARAMS_NAME, "someAccessToken"))
		.andExpect(header(HEADER_API_VERSION_PARAMS_NAME, API_VERSION))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withBadRequest().body(jsonResource("error-2001-invalid-user-token")));
		
		unauthorizedBetaSeries.memberOperations().getMemberInfos();
	}
}
