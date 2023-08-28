package com.streisky.imdbtop250movies.apiclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public abstract class ApiClient {

	private static final HttpClient httpClient;
	
	static {
		httpClient = HttpClient.newBuilder()
				.version(Version.HTTP_2)
				.followRedirects(Redirect.NORMAL)
				.connectTimeout(Duration.ofSeconds(30))
				.build();
	}

	protected static String sendRequest(String uri) throws Exception {
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.timeout(Duration.ofSeconds(30))
				.GET()
				.build();
		
		HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());
		
		return response.body();
	}
}
