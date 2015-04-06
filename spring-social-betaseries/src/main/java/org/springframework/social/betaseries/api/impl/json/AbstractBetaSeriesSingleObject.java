package org.springframework.social.betaseries.api.impl.json;

public class AbstractBetaSeriesSingleObject<T>{
	private final T object;
	
	public AbstractBetaSeriesSingleObject(T object) {
		this.object = object;
	}
	
	public T getObject() {
		return object;
	}
}
