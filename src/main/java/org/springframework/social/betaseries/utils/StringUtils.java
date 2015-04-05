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
package org.springframework.social.betaseries.utils;

// TODO: Auto-generated Javadoc
/**
 * The Class StringUtils.
 *
 * @author Guillaume Maka
 */
public class StringUtils {
	
	/**
	 * Tokenize.
	 *
	 * @param stringArray the string array
	 * @param delimiter the delimiter
	 * @return the string
	 */
	public static String tokenize(String[] stringArray, String delimiter) {
		StringBuffer bufferedString = new StringBuffer();
		
		for(int idx = 0; idx < stringArray.length; idx++) {
			if((idx + 1) != stringArray.length) {
				bufferedString.append(stringArray[idx]).append(delimiter);
			}else {
				bufferedString.append(stringArray[idx]);
			}
		}
		
		return bufferedString.toString();
	}
	
	/**
	 * Tokenize.
	 *
	 * @param enumArray the enum array
	 * @param delimiter the delimiter
	 * @return the string
	 */
	@SuppressWarnings("rawtypes")
	public static String tokenize(Enum[] enumArray, String delimiter) {
		StringBuffer bufferedString = new StringBuffer();
		
		for(int idx = 0; idx < enumArray.length; idx++) {
			if((idx + 1) != enumArray.length) {
				bufferedString.append(enumArray[idx].toString().toLowerCase()).append(delimiter);
			}else {
				bufferedString.append(enumArray[idx]);
			}
		}
		
		return bufferedString.toString();
	}
}
