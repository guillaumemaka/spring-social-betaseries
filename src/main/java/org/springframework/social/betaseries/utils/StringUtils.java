package org.springframework.social.betaseries.utils;

public class StringUtils {
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
