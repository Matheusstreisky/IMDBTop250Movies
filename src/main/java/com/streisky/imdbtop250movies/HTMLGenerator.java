package com.streisky.imdbtop250movies;

import java.io.PrintWriter;

import com.streisky.imdbtop250movies.model.Top250Data;
import com.streisky.imdbtop250movies.model.Top250DataDetail;

public class HTMLGenerator {
	
	private PrintWriter writer;

	public HTMLGenerator(PrintWriter writer) {
		super();
		this.writer = writer;
	}

	public void generate(Top250Data data) {
		writer.println("<html>");
		writer.println(generateHead());
		writer.println(generateBody(data));
		writer.println("</html>");
	}
	
	private String generateHead() {
		return ""
				+ "<head>"
				+ "<meta charset=\"utf-8\">"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
				+ "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\""
					+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">"
				+ "</head>";
	}
	
	private String generateBody(Top250Data data) {
		StringBuilder body = new StringBuilder();
		
		body.append("<body>");
		body.append("<h2>Top 250 Movies ImDb</h2>");
		body.append("<br/>");
		body.append("<br/>");
		
		for (Top250DataDetail dataDetail : data.getItems()) {
			body.append("<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">");
			body.append("  <h4 class=\"card-header\">" + dataDetail.getFullTitle() + "</h4>");
			body.append("  <div class=\"card-body\">");
			body.append("    <img class=\"card-img\" src=\"" + dataDetail.getImage() + "\" alt=\"" + dataDetail.getTitle() + "\">");
			body.append("    <p class=\"card-text mt-2\">");
			body.append("      Crew: " + dataDetail.getCrew());
			body.append("      <br/>");
			body.append("      Nota: " + dataDetail.getImDbRating() + " - Ano: " + dataDetail.getYear());
			body.append("    </p>");
			body.append("  </div>");
			body.append("</div>");
		}
		
		body.append("</body>");
		
		return body.toString();
	}
}
