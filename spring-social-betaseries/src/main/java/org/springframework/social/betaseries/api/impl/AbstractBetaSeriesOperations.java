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

import java.net.URI;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractBetaSeriesOperations.
 * 
 * @author Guillaume Maka
 */
public class AbstractBetaSeriesOperations {
	
	/** The is user authorized. */
	private final boolean isUserAuthorized;

	/** The is app authorized. */
	private boolean isAppAuthorized;

	/**
	 * Instantiates a new abstract beta series operations.
	 * 
	 * @param isUserAuthorized
	 *            the is user authorized
	 * @param isAppAuthorized
	 *            the is app authorized
	 */
	public AbstractBetaSeriesOperations(boolean isUserAuthorized, boolean isAppAuthorized) {
		this.isUserAuthorized = isUserAuthorized;
		this.isAppAuthorized = isAppAuthorized;
	}
	
	/**
	 * Require user authorization.
	 */
	protected void requireUserAuthorization() {
		if (!isUserAuthorized) {
			throw new MissingAuthorizationException("betaseries");
		}
	}

	/**
	 * Require app authorization.
	 */
	protected void requireAppAuthorization() {
		if (!isAppAuthorized) {
			throw new MissingAuthorizationException("betaseries");
		}
	}
	
	/**
	 * Require either user or app authorization.
	 */
	protected void requireEitherUserOrAppAuthorization() {
		if (!isUserAuthorized && !isAppAuthorized) {
			throw new MissingAuthorizationException("betaseries");
		}
	}
	
	/**
	 * Builds the uri.
	 * 
	 * @param path
	 *            the path
	 * @return the uri
	 */
	protected URI buildUri(String path) {
		return buildUri(path, EMPTY_PARAMETERS);
	}
	
	/**
	 * Builds the uri.
	 * 
	 * @param path
	 *            the path
	 * @param parameterName
	 *            the parameter name
	 * @param parameterValue
	 *            the parameter value
	 * @return the uri
	 */
	protected URI buildUri(String path, String parameterName, String parameterValue) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set(parameterName, parameterValue);
		return buildUri(path, parameters);
	}
	
	/**
	 * Builds the uri.
	 * 
	 * @param path
	 *            the path
	 * @param parameters
	 *            the parameters
	 * @return the uri
	 */
	protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
		return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
	}
	
	/** The Constant API_URL_BASE. */
	private static final String API_URL_BASE = "https://api.betaseries.com/";

	/** The Constant EMPTY_PARAMETERS. */
	private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();
}
