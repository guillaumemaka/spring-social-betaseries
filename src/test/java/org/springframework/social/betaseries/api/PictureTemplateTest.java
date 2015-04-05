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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Test;
import org.springframework.http.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class PictureTemplateTest.
 *
 * @author Guillaume Maka
 */
public class PictureTemplateTest extends AbstractBetaSeriesApiTest {
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 * @throws Exception the exception
	 */
	@Test
	public void getImage() throws Exception {
		constructGetMockRequest(mockServer, "https://api.betaseries.com/pictures/badges?id=248")
		.andRespond(withSuccess().body(imageResource("badge-248")).contentType(MediaType.IMAGE_PNG));
		
		byte[] actual = betaSeries.pictureOperations().getBadgePicture(248);
		assertNotNull(actual);
		assertTrue(actual.length > 0);
	}
}
