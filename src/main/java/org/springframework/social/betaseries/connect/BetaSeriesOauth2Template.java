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

import org.springframework.social.oauth2.OAuth2Template;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesOauth2Template.
 *
 * @author Guillaume Maka
 */
public class BetaSeriesOauth2Template extends OAuth2Template {		
	
	/**
	 * Instantiates a new beta series oauth2 template.
	 *
	 * @param clientId
	 *            the client id
	 * @param clientSecret
	 *            the client secret
	 */
	public BetaSeriesOauth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, "https://www.betaseries.com/authorize", "https://api.betaseries.com/members/access_token");
		setUseParametersForClientAuthentication(true);
	}	
}
