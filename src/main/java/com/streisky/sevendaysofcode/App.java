package com.streisky.sevendaysofcode;

import java.net.http.HttpResponse;

public class App 
{
	public static void main(String[] args) {
		Imdb imdb = new Imdb();
		try {
			HttpResponse<String> response = imdb.sendRequestTop250Movies();
			System.out.println(response.body());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
