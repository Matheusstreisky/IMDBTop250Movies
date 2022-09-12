package com.streisky.sevendaysofcode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class ImdbApiClient {

	private static final String API_KEY = "k_k9anhy4s";
	private static final HttpClient httpClient;
	
	static {
		httpClient = HttpClient.newBuilder()
				.version(Version.HTTP_2)
				.followRedirects(Redirect.NORMAL)
				.connectTimeout(Duration.ofSeconds(30))
				.build();
	}
	
	private static String sendRequest(String uri) throws Exception {
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.timeout(Duration.ofSeconds(30))
				.GET()
				.build();
		
		HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());
		
		return response.body();
	}
	
	public static String sendRequestTop250Movies() throws Exception {
		return sendRequest("https://imdb-api.com/en/API/Top250Movies/" + API_KEY);
	}
}
