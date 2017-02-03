package core;

import java.util.ArrayList;
import java.util.List;

public class HTMLBrandElement {

	private static final String CONTAINER_START = "<div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'>";		
	private static final String HEADING_END = "</h4></div>";		
	private static final String CONTAINER_END = "</div>";		

	private StringBuilder body;

	public HTMLBrandElement(String heading) {
		body = new StringBuilder();
		
		body.append(CONTAINER_START);
		body.append(getHTMLHeading(heading));
		body.append(HEADING_END);
		body.append(CONTAINER_END);
	}
	
	public HTMLBrandElement(String heading, ArrayList<String> entries) {
		body = new StringBuilder();
		
		body.append(CONTAINER_START);
		body.append(getHTMLAccordianHeading(heading));
		body.append(HEADING_END);
		body.append(getHTMLAccordianBody(heading, entries));
		body.append(CONTAINER_END);
	}
	
	private String getHTMLHeading(String heading) {
		return "<a href='#''>" + heading + "</a>";
	}
	
	private String getHTMLAccordianHeading(String heading) {
		return "<a data-toggle='collapse' data-parent='#accordian' href='#"
				+ heading + "'><span class='badge pull-right'><i class='fa fa-plus'></i></span>"
				+ heading + "</a>";
	}
	
	private String getHTMLAccordianBody(String heading, List<String> entries) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("<div id='" + heading + "' class='panel-collapse collapse'><div class='panel-body'><ul>");

		for (String entry : entries) {
			builder.append("<li><a href='#'>" + entry + "</a></li>");
		}
		
		builder.append("</ul></div></div>");

		return builder.toString();
	}
	
	public String toString() {
		return body.toString();
	}
}
