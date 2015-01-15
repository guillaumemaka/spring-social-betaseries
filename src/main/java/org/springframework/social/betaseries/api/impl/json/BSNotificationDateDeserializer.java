package org.springframework.social.betaseries.api.impl.json;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BSNotificationDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		try {
			return new SimpleDateFormat(BS_NOTIFICATION_DATE_FORMAT, Locale.ENGLISH).parse(jp.getText());
		} catch (ParseException e) {
			return null;
		}
	}
	
	private final String BS_NOTIFICATION_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
