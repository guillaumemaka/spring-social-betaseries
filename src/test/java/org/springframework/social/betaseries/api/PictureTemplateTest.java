package org.springframework.social.betaseries.api;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import org.junit.Test;
import org.springframework.http.MediaType;

public class PictureTemplateTest extends AbstractBetaSeriesApiTest {
	@Test
	public void getImage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/pictures/badges?id=248")
		.andRespond(withSuccess().body(imageResource("badge-248")).contentType(MediaType.IMAGE_PNG));
		
		byte[] actual = betaSeries.pictureOperations().getBadgePicture(248);
		assertNotNull(actual);
		assertTrue(actual.length > 0);
	}
}
