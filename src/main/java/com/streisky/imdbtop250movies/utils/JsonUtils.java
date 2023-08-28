package com.streisky.imdbtop250movies.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.streisky.imdbtop250movies.model.Content;

public class JsonUtils {

	public static <T> Object convertJsonToObject(Class<? extends Content> c, String json) {
		return new Gson().fromJson(json, c);
	}
	
	public static <T> List<? extends Content> convertJsonToList(Class<? extends Content> c, String json) {
		return new Gson().fromJson(json, new TypeToken<ArrayList<T>>(){}.getType());
	}
}
