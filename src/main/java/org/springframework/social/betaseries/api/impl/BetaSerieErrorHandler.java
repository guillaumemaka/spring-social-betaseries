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

package org.springframework.social.betaseries.api.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.ApiException;
import org.springframework.social.InvalidAuthorizationException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.betaseries.api.DuplicateResourceException;
import org.springframework.social.betaseries.api.InvalidCharacterVariableException;
import org.springframework.social.betaseries.api.InvalidEmailAddressVariableException;
import org.springframework.social.betaseries.api.InvalidTypeVariableException;
import org.springframework.social.betaseries.api.InvalidValueVariableException;
import org.springframework.social.betaseries.api.MalfornedTermException;
import org.springframework.social.betaseries.api.MissingVariableException;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSerieErrorHandler.
 * 
 * @author Guillaume Maka
 */
public class BetaSerieErrorHandler extends DefaultResponseErrorHandler {

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory
			.getLogger(BetaSerieErrorHandler.class);

	/** The Constant BETA_SERIE. */
	private final static String BETA_SERIE = "betaserie";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.client.DefaultResponseErrorHandler#handleError
	 * (org.springframework.http.client.ClientHttpResponse)
	 */
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		Map<String, Object> errorDetails = extractErrorDetailsFromResponse(response);
		if (errorDetails == null) {
			handleUncategorizedError(response, errorDetails);
		}

		handleBetaSeriesError(errorDetails);

		// otherwise handle uncategorized exceptions
		handleUncategorizedError(response, errorDetails);

	}

	/**
	 * Handle beta series error.
	 * 
	 * @param errorDetails
	 *            the error details
	 */
	private void handleBetaSeriesError(Map<String, Object> errorDetails) {
		int code = Integer.valueOf(errorDetails.get("code").toString());
		String message = (String) errorDetails.get("text");

		if (code < 2000) {
			throw new ApiException(BETA_SERIE, message);
		} else if (code < 3000) {
			handleUserError(code, message);
		} else if (code < 4000) {
			handleVariableError(code, message);
		} else if (code < 5000) {
			handleBaseError(code, message);
		}
	}

	/**
	 * Handle base error.
	 * 
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 */
	private void handleBaseError(int code, String message) {
		switch (code) {
		case 4001:
			throw new ResourceNotFoundException(BETA_SERIE, message);
		case 4002:
			throw new ResourceNotFoundException(BETA_SERIE, message);
		case 4003:
			throw new InvalidAuthorizationException(BETA_SERIE, message);
		case 4004:
			throw new DuplicateResourceException(BETA_SERIE, message);
		}
	}

	/**
	 * Handle variable error.
	 * 
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 */
	private void handleVariableError(int code, String message) {
		switch (code) {
		case 3001:
			throw new MissingVariableException(BETA_SERIE, message);
		case 3002:
			throw new MalfornedTermException(BETA_SERIE, message);
		case 3003:
			throw new InvalidTypeVariableException(BETA_SERIE, message);
		case 3004:
			throw new InvalidValueVariableException(BETA_SERIE, message);
		case 3005:
			throw new InvalidCharacterVariableException(BETA_SERIE, message);
		case 3006:
			throw new InvalidEmailAddressVariableException(BETA_SERIE, message);
		}
	}

	/**
	 * Handle user error.
	 * 
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 */
	private void handleUserError(int code, String message) {
		switch (code) {
		case 2001:
			throw new MissingAuthorizationException(BETA_SERIE);
		}
	}

	/**
	 * Handle uncategorized error.
	 * 
	 * @param response
	 *            the response
	 * @param errorDetails
	 *            the error details
	 */
	private void handleUncategorizedError(ClientHttpResponse response,
			Map<String, Object> errorDetails) {
		try {
			super.handleError(response);
		} catch (Exception e) {
			if (errorDetails != null) {
				throw new UncategorizedApiException("facebook",
						(String) errorDetails.get("message"), e);
			} else {
				throw new UncategorizedApiException(BETA_SERIE,
						"No error details from betaseries", e);
			}
		}
	}

	/*
	 * Attempts to extract Facebook error details from the response. Returns
	 * null if the response doesn't match the expected JSON error response.
	 */
	/**
	 * Extract error details from response.
	 * 
	 * @param response
	 *            the response
	 * @return the map
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> extractErrorDetailsFromResponse(
			ClientHttpResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		String json = readFully(response.getBody());

		System.out.println(json);

		if (logger.isDebugEnabled()) {
			logger.debug("Error from BetaSeries: " + json);
		}

		try {
			Map<String, Object> responseMap = mapper
					.<Map<String, Object>> readValue(json,
							new TypeReference<Map<String, Object>>() {
							});

			// all beta series response contain a json errors object, even if
			// there are no error,
			// only checking if the object contain an "errors" key is not enough
			// to consider an error occur
			if (responseMap.containsKey("errors")) {
				Object errorMap = responseMap.get("errors");
				Map<String, Object> errors = new HashMap<String, Object>();

				if (errorMap instanceof List) {
					List<Map<String, Object>> list = (List<Map<String, Object>>) errorMap;
					if (list.size() > 0) {
						errors = list.get(0);
					}
				} else if (errorMap instanceof Map) {
					errors = (Map<String, Object>) errorMap;
				}

				// checking if the errors Map size is not empty its the best
				// way to make sure an error occur
				if (errors != null) {
					return errors;
				}
			}
		} catch (JsonParseException e) {
			return null;
		}

		return null;
	}

	/**
	 * Read fully.
	 * 
	 * @param in
	 *            the in
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private String readFully(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		while (reader.ready()) {
			sb.append(reader.readLine());
		}
		return sb.toString();
	}
}
