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

import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.social.MissingAuthorizationException;


// TODO: Auto-generated Javadoc
/**
 * The Class ErrorHandlingTest.
 *
 * @author Guillaume Maka
 */
public class ErrorHandlingTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Unauthorized access token test.
	 */
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
