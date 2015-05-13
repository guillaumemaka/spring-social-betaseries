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
package org.springframework.social.betaseries.api;


/**
 * The Enum BSTimelineEventType.
 * <p>
 * Represents the type of an event
 * </p>
 * 
 * @author Guillaume Maka
 */
public enum BSTimelineEventType {
	
	/** Event friend add. */
	FRIEND_ADD, 
	
	/** Event friend delete. */
	FRIEND_DELETE, 
 	
	/** Event mark as. */
 	MARKAS, 
 	
 	/** Event serie added. */
 	ADD_SERIE, 
 	
 	/** Event serie deleted. */
 	DEL_SERIE, 
 	
 	/** Event elemnt archived. */
 	ARCHIVE,
    
    /** Event element unarchived. */
    UNARCHIVE, 
    
    /** Event element recommandation. */
    RECOMMANDATION,
    
    /** Event recommandation declined. */
    RECOMMANDATION_DECLINE,
    
    /** Event recommandation accepted. */
    RECOMMANDATION_ACCEPT,
        
    /** Event inscription. */
    INSCRIPTION, 
    
    /** Event update. */
    UPDATE, 
    
    /** Event subtitles. */
    SUBTITLES, 
    
    /** Event comment. */
    COMMENT, 
    
    /** Event badge. */
    BADGE, 
    
    /** Event forum. */
    FORUM, 
    
    /** Event wiki. */
    WIKI, 
    
    /** Event film added. */
    FILM_ADD, 
    
    /** Event film deleleted. */
    FILM_DEL,
    
    /** Event banner. */
    BANNER, 
    
    /** Event suggestion. */
    SUGGEST
}
