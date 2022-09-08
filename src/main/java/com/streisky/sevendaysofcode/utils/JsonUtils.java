package com.streisky.sevendaysofcode.utils;

import com.google.gson.Gson;

public class JsonUtils {

	public static <T> Object convertStringToObject(Class<T> c, String json) {
		return new Gson().fromJson(json, c);
	}
}
