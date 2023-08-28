package com.streisky.imdbtop250movies.model;

import java.util.List;

public interface Content {

	public List<? extends Object> getItems();
	
	public String getMessageError();
}
