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
 * The Class BetaSeriesApiVersionParameterInterceptor.
 * 
 * @author Guillaume Maka
 */
public class BetaSeriesApiVersionHeaderParameterInterceptor implements
		ClientHttpRequestInterceptor {

	/** The api version. */
	private String apiVersion;	
	
	/** The parameter name. */
	private final String parameterName;
	
	/**
	 * Instantiates a new beta series api version parameter interceptor.
	 * 
	 * @param apiVersion
	 *            the api version
	 */
	public BetaSeriesApiVersionHeaderParameterInterceptor(String apiVersion) {
		this(apiVersion, "X-BetaSeries-Version");
	}
	
	/**
	 * Instantiates a new beta series api version parameter interceptor.
	 * 
	 * @param apiVersion
	 *            the api version
	 * @param parameterName
	 *            the parameter name
	 */
	public BetaSeriesApiVersionHeaderParameterInterceptor(String apiVersion, String parameterName) {
		this.apiVersion = apiVersion;
		this.parameterName = parameterName;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.http.client.ClientHttpRequestInterceptor#intercept(org.springframework.http.HttpRequest, byte[], org.springframework.http.client.ClientHttpRequestExecution)
	 */
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		HttpRequestDecorator protectedResourceRequest = new HttpRequestDecorator(request);
		protectedResourceRequest.getHeaders().set(parameterName, apiVersion);
		return execution.execute(protectedResourceRequest, body);
	}

}
