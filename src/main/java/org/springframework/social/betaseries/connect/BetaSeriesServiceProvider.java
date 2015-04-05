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

import org.springframework.social.betaseries.api.BetaSeries;
import org.springframework.social.betaseries.api.impl.BetaSeriesTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesServiceProvider.
 *
 * @author Guillaume Maka
 */
public class BetaSeriesServiceProvider extends AbstractOAuth2ServiceProvider<BetaSeries> {
	
	/** The api key. */
	private String apiKey;
	
	/**
	 * Instantiates a new beta series service provider.
	 *
	 * @param apiKey
	 *            the api key
	 * @param clientSecret
	 *            the client secret
	 */
	public BetaSeriesServiceProvider(String apiKey, String clientSecret) {
		super(new BetaSeriesOauth2Template(apiKey, clientSecret));
		this.apiKey = apiKey;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.oauth2.AbstractOAuth2ServiceProvider#getApi(java.lang.String)
	 */
	@Override
	public BetaSeries getApi(String accessToken) {
		return new BetaSeriesTemplate(accessToken, apiKey);
	}

}
