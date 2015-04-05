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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.betaseries.api.impl.BetaSeriesTemplate;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.ResponseActions;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractBetaSeriesApiTest.
 *
 * @author Guillaume Maka
 */
public class AbstractBetaSeriesApiTest {
	
	/** The logger. */
	protected final Logger logger = LoggerFactory
			.getLogger(AbstractBetaSeriesApiTest.class);

	/** The Constant HEADER_API_KEY_PARAMS_NAME. */
	protected static final String HEADER_API_KEY_PARAMS_NAME = "X-BetaSeries-Key";
	
	/** The Constant HEADER_ACCESS_TOKEN_PARAMS_NAME. */
	protected static final String HEADER_ACCESS_TOKEN_PARAMS_NAME = "X-BetaSeries-Token";
	
	/** The Constant HEADER_API_VERSION_PARAMS_NAME. */
	protected static final String HEADER_API_VERSION_PARAMS_NAME = "X-BetaSeries-Version";

	/** The Constant HEADER_ACCEPT_PARAMS_NAME. */
	private static final String HEADER_ACCEPT_PARAMS_NAME = "Accept";

	/** The Constant ACCEPT. */
	private static final String ACCEPT = MediaType.APPLICATION_JSON.toString();

	/** The api version. */
	protected static String API_VERSION = "2.4";
	
	/** The api key. */
	protected static String API_KEY = "1ec6933c0a13";
	
	/** The access token. */
	protected static String ACCESS_TOKEN = "5e021ef6f858";
	
	/** The bad api key. */
	protected static String BAD_API_KEY = "someApiKey";
	
	/** The bad access token. */
	protected static String BAD_ACCESS_TOKEN = "someAccessToken";

	/** The beta series. */
	protected BetaSeriesTemplate betaSeries;
	
	/** The unauthorized beta series. */
	protected BetaSeriesTemplate unauthorizedBetaSeries;

	/** The mock server. */
	protected MockRestServiceServer mockServer;
	
	/** The unauthorized mock server. */
	protected MockRestServiceServer unauthorizedMockServer;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		betaSeries = new BetaSeriesTemplate(ACCESS_TOKEN, API_KEY);
		mockServer = MockRestServiceServer.createServer(betaSeries
				.getRestTemplate());

		unauthorizedBetaSeries = new BetaSeriesTemplate(BAD_ACCESS_TOKEN,
				BAD_API_KEY);
		unauthorizedMockServer = MockRestServiceServer
				.createServer(unauthorizedBetaSeries.getRestTemplate());
	}
	
	/**
	 * Teat down.
	 */
	@After
	public void teatDown() {
		this.betaSeries = null;
		this.mockServer = null;
		this.unauthorizedBetaSeries = null;
		this.unauthorizedMockServer = null;
	}

	/**
	 * Json resource.
	 *
	 * @param filename the filename
	 * @return the resource
	 */
	protected Resource jsonResource(String filename) {
		return new ClassPathResource(filename + ".json", getClass());
	}

	/**
	 * Image resource.
	 *
	 * @param filename the filename
	 * @return the resource
	 */
	protected Resource imageResource(String filename) {
		return new ClassPathResource(filename + ".png", getClass());
	}

	/**
	 * Date from string.
	 *
	 * @param strDate the str date
	 * @return the date
	 */
	protected Date dateFromString(String strDate) {
		return dateFromString(strDate, BS_DATE_FORMAT);
	}

	/**
	 * Date from string.
	 *
	 * @param strDate the str date
	 * @param pattern the pattern
	 * @return the date
	 */
	protected Date dateFromString(String strDate, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,
				Locale.ENGLISH);
		try {
			return formatter.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * To byte.
	 *
	 * @param obj the obj
	 * @return the byte[]
	 */
	@SuppressWarnings("unused")
	private byte[] toByte(Object obj) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		ObjectOutputStream o;
		try {
			o = new ObjectOutputStream(b);
			o.writeObject(obj);
		} catch (IOException e1) {
			return new byte[0];
		}

		return b.toByteArray();
	}

	/**
	 * Configure common request expectation request.
	 *
	 * @param server the server
	 * @param url the url
	 * @return {@link ResponseActions}
	 */
	protected ResponseActions constructGetMockRequest(
			MockRestServiceServer server, String url) {
		return constructRequest(getConfiguredRequest(server, url),
				HttpMethod.GET);
	}

	/**
	 * Construct post mock request.
	 *
	 * @param server the server
	 * @param url the url
	 * @return the response actions
	 */
	protected ResponseActions constructPostMockRequest(
			MockRestServiceServer server, String url) {
		return constructRequest(getConfiguredRequest(server, url),
				HttpMethod.POST);
	}

	/**
	 * Construct delete mock request.
	 *
	 * @param server the server
	 * @param url the url
	 * @return the response actions
	 */
	protected ResponseActions constructDeleteMockRequest(
			MockRestServiceServer server, String url) {
		return constructRequest(getConfiguredRequest(server, url),
				HttpMethod.DELETE);
	}

	/**
	 * Construct unauthorized get mock request.
	 *
	 * @param server the server
	 * @param url the url
	 * @return the response actions
	 */
	protected ResponseActions constructUnauthorizedGetMockRequest(
			MockRestServiceServer server, String url) {
		return constructRequest(getBadConfiguredRequest(server, url),
				HttpMethod.GET);
	}

	/**
	 * Construct request.
	 *
	 * @param action the action
	 * @param method the method
	 * @return the response actions
	 */
	protected ResponseActions constructRequest(ResponseActions action,
			HttpMethod method) {
		return action.andExpect(method(method));
	}

	/**
	 * Gets the configured request.
	 *
	 * @param server the server
	 * @param url the url
	 * @return the configured request
	 */
	protected ResponseActions getConfiguredRequest(
			MockRestServiceServer server, String url) {
		return server
				.expect(requestTo(urlEncode(url)))
				.andExpect(header(HEADER_API_KEY_PARAMS_NAME, API_KEY))
				.andExpect(
						header(HEADER_ACCESS_TOKEN_PARAMS_NAME, ACCESS_TOKEN))
				.andExpect(header(HEADER_API_VERSION_PARAMS_NAME, API_VERSION))
				.andExpect(header(HEADER_ACCEPT_PARAMS_NAME, ACCEPT));
	}

	/**
	 * Gets the bad configured request.
	 *
	 * @param server the server
	 * @param url the url
	 * @return the bad configured request
	 */
	protected ResponseActions getBadConfiguredRequest(
			MockRestServiceServer server, String url) {
		return server
				.expect(requestTo(urlEncode(url)))
				.andExpect(header(HEADER_API_KEY_PARAMS_NAME, BAD_API_KEY))
				.andExpect(
						header(HEADER_ACCESS_TOKEN_PARAMS_NAME,
								BAD_ACCESS_TOKEN))
				.andExpect(header(HEADER_API_VERSION_PARAMS_NAME, API_VERSION));
	}

	/**
	 * Url encode.
	 *
	 * @param url the url
	 * @return the string
	 */
	private String urlEncode(String url) {
		int starPos = url.indexOf("?");
		
		if (starPos == -1) {
			return url;
		}
		
		String queryParameter = url.substring(starPos + 1);
		String uri = url.substring(0, starPos + 1);
		
		String encodedParametersString = buildUrlEncodedQueryString(queryParameter);		

		return uri + encodedParametersString;
	}
	
	/**
	 * Builds the url encoded query string.
	 *
	 * @param queryParametersAsString the query parameters as string
	 * @return the string
	 */
	protected String buildUrlEncodedQueryString(String queryParametersAsString) {
		String[] params = null; 
		
		if (queryParametersAsString.indexOf("&") != -1) {
			params = queryParametersAsString.split("&");
		} else {
			params = new String[] {queryParametersAsString};
		}
				
		StringBuilder encodedParameterBulder = new StringBuilder();

		for (int i = 0; i < params.length; i++) {
			int delemiterPos = params[i].indexOf("=");
			String name = params[i].substring(0, delemiterPos);
			String value = params[i].substring(delemiterPos + 1);
			encodedParameterBulder.append(name).append("=").append(formEncode(value));

			if (i != params.length - 1) {
				encodedParameterBulder.append("&");
			}
		}
		
		return encodedParameterBulder.toString();
	}
	
	/**
	 * Body form encode.
	 *
	 * @param body the body
	 * @return the string
	 */
	protected String bodyFormEncode(String body) {
		return buildUrlEncodedQueryString(body);
	}
	
	/**
	 * Form encode.
	 *
	 * @param value the value
	 * @return the string
	 */
	protected String formEncode(String value) {		
		try {
			return URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	/** The Constant BS_DATE_FORMAT. */
	protected static final String BS_DATE_FORMAT = "yyyy-MM-dd";
	
	/** The Constant BS_DATE_AND_TIME_FORMAT. */
	protected static final String BS_DATE_AND_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
