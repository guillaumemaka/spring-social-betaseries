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
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.support.HttpRequestDecorator;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesAcceptHeaderParameterInterceptor.
 *
 * @author Guillaume Maka
 */
public class BetaSeriesAcceptHeaderParameterInterceptor implements
		ClientHttpRequestInterceptor {
	
	/** The accepted media type. */
	private String acceptedMediaType;
	
	/**
	 * Instantiates a new beta series accept header parameter interceptor.
	 */
	public BetaSeriesAcceptHeaderParameterInterceptor() {
		this(MediaType.APPLICATION_JSON);
	}
	
	/**
	 * Instantiates a new beta series accept header parameter interceptor.
	 *
	 * @param acceptedMediaType
	 *            the accepted media type
	 */
	public BetaSeriesAcceptHeaderParameterInterceptor(String acceptedMediaType) {
		this(MediaType.parseMediaType(acceptedMediaType));
	}
	
	/**
	 * Instantiates a new beta series accept header parameter interceptor.
	 *
	 * @param mediaType
	 *            the media type
	 */
	public BetaSeriesAcceptHeaderParameterInterceptor(MediaType mediaType) {
		if(mediaType.includes(MediaType.APPLICATION_JSON) || mediaType.includes(MediaType.APPLICATION_XML)) {
			this.acceptedMediaType = mediaType.toString();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.http.client.ClientHttpRequestInterceptor#intercept(org.springframework.http.HttpRequest, byte[], org.springframework.http.client.ClientHttpRequestExecution)
	 */
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		HttpRequestDecorator protectedResourceRequest = new HttpRequestDecorator(request);
		protectedResourceRequest.getHeaders().setAccept(MediaType.parseMediaTypes(acceptedMediaType));
		return execution.execute(protectedResourceRequest, body);		
	}

}
