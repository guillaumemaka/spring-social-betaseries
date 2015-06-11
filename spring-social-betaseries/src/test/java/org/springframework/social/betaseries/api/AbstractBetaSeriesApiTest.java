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

public class AbstractBetaSeriesApiTest {
	protected final Logger logger = LoggerFactory
			.getLogger(AbstractBetaSeriesApiTest.class);

	protected static final String HEADER_API_KEY_PARAMS_NAME = "X-BetaSeries-Key";
	protected static final String HEADER_ACCESS_TOKEN_PARAMS_NAME = "X-BetaSeries-Token";
	protected static final String HEADER_API_VERSION_PARAMS_NAME = "X-BetaSeries-Version";

	private static final String HEADER_ACCEPT_PARAMS_NAME = "Accept";

	private static final String ACCEPT = MediaType.APPLICATION_JSON.toString();

	protected static String API_VERSION = "2.4";
	protected static String API_KEY = "1ec6933c0a13";
	protected static String ACCESS_TOKEN = "5e021ef6f858";
	protected static String BAD_API_KEY = "someApiKey";
	protected static String BAD_ACCESS_TOKEN = "someAccessToken";

	protected BetaSeriesTemplate betaSeries;
	protected BetaSeriesTemplate unauthorizedBetaSeries;

	protected MockRestServiceServer mockServer;
	protected MockRestServiceServer unauthorizedMockServer;

	private ClassPathResource resource;

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
	
	@After
	public void tearDown() {		
		this.betaSeries = null;		
		this.mockServer = null;		
		this.unauthorizedBetaSeries = null;
		this.unauthorizedMockServer = null;
		resource = null;				
	}

	protected Resource jsonResource(String filename) {
		resource = new ClassPathResource(filename + ".json", getClass());
		return resource;
	}

	protected Resource imageResource(String filename) {
		resource = new ClassPathResource(filename + ".png", getClass());
		return resource;
	}

	protected Date dateFromString(String strDate) {
		return dateFromString(strDate, BS_DATE_FORMAT);
	}

	protected Date dateFromString(String strDate, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,
				Locale.ENGLISH);
		try {
			return formatter.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}

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
	 * Configure common request expectation request
	 * 
	 * @param server
	 * @param url
	 * @return {@link ResponseActions}
	 */
	protected ResponseActions constructGetMockRequest(
			MockRestServiceServer server, String url) {
		return constructRequest(getConfiguredRequest(server, url),
				HttpMethod.GET);
	}

	protected ResponseActions constructPostMockRequest(
			MockRestServiceServer server, String url) {
		return constructRequest(getConfiguredRequest(server, url),
				HttpMethod.POST);
	}

	protected ResponseActions constructDeleteMockRequest(
			MockRestServiceServer server, String url) {
		return constructRequest(getConfiguredRequest(server, url),
				HttpMethod.DELETE);
	}

	protected ResponseActions constructUnauthorizedGetMockRequest(
			MockRestServiceServer server, String url) {
		return constructRequest(getBadConfiguredRequest(server, url),
				HttpMethod.GET);
	}

	protected ResponseActions constructRequest(ResponseActions action,
			HttpMethod method) {
		return action.andExpect(method(method));
	}

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
	
	protected String bodyFormEncode(String body) {
		return buildUrlEncodedQueryString(body);
	}
	
	protected String formEncode(String value) {		
		try {
			return URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	protected static final String BS_DATE_FORMAT = "yyyy-MM-dd";
	protected static final String BS_DATE_AND_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
