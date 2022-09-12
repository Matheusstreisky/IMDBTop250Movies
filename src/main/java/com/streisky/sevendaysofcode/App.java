package com.streisky.sevendaysofcode;

import java.io.PrintWriter;

import com.streisky.sevendaysofcode.model.Top250Data;
import com.streisky.sevendaysofcode.utils.JsonUtils;

public class App 
{
	public static void main(String[] args) {
		try {
			String json = ImdbApiClient.sendRequestTop250Movies();
			Top250Data top250Data = (Top250Data) JsonUtils.convertJsonToObject(Top250Data.class, json);
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
