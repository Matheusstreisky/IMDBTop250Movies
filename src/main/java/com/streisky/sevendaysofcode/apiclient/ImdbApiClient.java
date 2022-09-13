package com.streisky.sevendaysofcode.apiclient;

public class ImdbApiClient extends ApiClient {

	private static final String API_KEY = "k_k9anhy4s";

	public static String sendRequestTop250Movies() throws Exception {
		return sendRequest("https://imdb-api.com/en/API/Top250Movies/" + API_KEY);
	}
}
