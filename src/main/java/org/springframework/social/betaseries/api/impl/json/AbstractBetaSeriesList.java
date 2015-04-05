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
package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractBetaSeriesList.
 *
 * @author Guillaume Maka
 * @param <T> the generic type
 */
public abstract class AbstractBetaSeriesList<T> {
	
	/** The list. */
	private final List<T> list;
	
	/**
	 * Instantiates a new abstract beta series list.
	 *
	 * @param list the list
	 */
	public AbstractBetaSeriesList(List<T> list){
		this.list = list;
	}
	
	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public List<T> getList(){
		return list;
	}
}
