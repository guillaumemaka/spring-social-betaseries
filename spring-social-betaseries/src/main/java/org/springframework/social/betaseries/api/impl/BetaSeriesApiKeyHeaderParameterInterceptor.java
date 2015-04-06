/**
 * Copyright 2014 the original author or authors
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
 * The Class BetaSeriesApiKeyParameterInterceptor.
 * 
 * @author Guillaume Maka
 */
public class BetaSeriesApiKeyHeaderParameterInterceptor implements
		ClientHttpRequestInterceptor {
	
	/** The api key. */
	private String apiKey;
	
	/** The parameter name. */
	private String parameterName;
	
	/**
	 * Instantiates a new beta series api key parameter interceptor.
	 * 
	 * @param apiKey
	 *            the api key
	 */
	public BetaSeriesApiKeyHeaderParameterInterceptor(String apiKey) {
		this(apiKey, "X-BetaSeries-Key");
	}
	
	/**
	 * Instantiates a new beta series api key parameter interceptor.
	 * 
	 * @param apiKey
	 *            the api key
	 * @param parameterName
	 *            the parameter name
	 */
	public BetaSeriesApiKeyHeaderParameterInterceptor(String apiKey, String parameterName) {
		this.apiKey = apiKey;
		this.parameterName = parameterName;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.http.client.ClientHttpRequestInterceptor#intercept(org.springframework.http.HttpRequest, byte[], org.springframework.http.client.ClientHttpRequestExecution)
	 */
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		HttpRequestDecorator protectedResourceRequest = new HttpRequestDecorator(request);
		protectedResourceRequest.getHeaders().set(parameterName, apiKey);
		return execution.execute(protectedResourceRequest, body);		
	}

}
