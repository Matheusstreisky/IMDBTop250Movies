package com.streisky.imdbtop250movies;

import java.io.PrintWriter;
import java.util.Collections;

import com.streisky.imdbtop250movies.apiclient.ImdbApiClient;
import com.streisky.imdbtop250movies.model.Top250Data;
import com.streisky.imdbtop250movies.utils.JsonUtils;

public class App {

	public static void main(String[] args) {
		try {
			String json = ImdbApiClient.sendRequestTop250Movies();
			Top250Data top250Data = (Top250Data) JsonUtils.convertJsonToObject(Top250Data.class, json);
			Collections.sort(top250Data.getItems());
			System.out.println(top250Data);

			PrintWriter writer = new PrintWriter("Top250Movies.html");
			HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
			htmlGenerator.generate(top250Data);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
