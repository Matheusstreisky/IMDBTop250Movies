package com.streisky.imdbtop250movies.apiclient;

public class ImdbApiClient extends ApiClient {

	private static final String API_KEY = "XXXXXX";

	public static String sendRequestTop250Movies() throws Exception {
		return sendRequest("https://imdb-api.com/en/API/Top250Movies/" + API_KEY);
	}
}
