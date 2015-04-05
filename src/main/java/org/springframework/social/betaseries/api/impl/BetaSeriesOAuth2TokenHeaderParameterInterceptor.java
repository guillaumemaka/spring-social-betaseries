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
package org.springframework.social.betaseries.api.impl;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.support.HttpRequestDecorator;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesOAuth2TokenHeaderParameterInterceptor.
 *
 * @author Guillaume Maka
 */
public class BetaSeriesOAuth2TokenHeaderParameterInterceptor implements
		ClientHttpRequestInterceptor {
	
	/** The access token. */
	private String accessToken;	
	
	/** The parameter name. */
	private final String parameterName;
	
	/**
	 * Instantiates a new beta series o auth2 token header parameter
	 * interceptor.
	 *
	 * @param accessToken
	 *            the access token
	 */
	public BetaSeriesOAuth2TokenHeaderParameterInterceptor(String accessToken) {
		this(accessToken, "X-BetaSeries-Token");
	}
	
	/**
	 * Instantiates a new beta series o auth2 token header parameter
	 * interceptor.
	 *
	 * @param accessToken
	 *            the access token
	 * @param parameterName
	 *            the parameter name
	 */
	public BetaSeriesOAuth2TokenHeaderParameterInterceptor(String accessToken, String parameterName) {
		this.accessToken = accessToken;
		this.parameterName = parameterName;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.http.client.ClientHttpRequestInterceptor#intercept(org.springframework.http.HttpRequest, byte[], org.springframework.http.client.ClientHttpRequestExecution)
	 */
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		HttpRequestDecorator protectedResourceRequest = new HttpRequestDecorator(request);
		protectedResourceRequest.getHeaders().set(parameterName, accessToken);
		return execution.execute(protectedResourceRequest, body);
	}

}
