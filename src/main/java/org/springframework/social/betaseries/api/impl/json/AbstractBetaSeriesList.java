package org.springframework.social.betaseries.api.impl.json;

import java.util.List;

public abstract class AbstractBetaSeriesList<T> {
	private final List<T> list;
	
	public AbstractBetaSeriesList(List<T> list){
		this.list = list;
	}
	
	public List<T> getList(){
		return list;
	}
}
