package productsServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.HTMLPageElement;
import database.ProductsQuery;

/**
 * @author lawrence.coles
 *
 */
public class GetPagesServlet extends HttpServlet {
		
	@Override
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response)
					throws ServletException, IOException {
		final PrintWriter out = response.getWriter();

		final String pageNoField = request.getParameter("pageNo");

		final Integer numberOfPages = ProductsQuery.getNumberOfPages();
		final HTMLPageElement htmlPage = 
				new HTMLPageElement(Integer.parseInt(pageNoField), numberOfPages);
				
		out.println(htmlPage);
	}

}