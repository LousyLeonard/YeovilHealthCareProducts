package productsServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.HTMLProductElement;
import core.HTMLElementFactory;
import core.Product;
import database.ProductsQuery;
import utilities.HTMLElementList;

public class GetProductsServlet extends HttpServlet {
	@Override
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response)
					throws ServletException, IOException {
		final PrintWriter out = response.getWriter();

		final String searchField = request.getParameter("search");
		final String pageNoField = request.getParameter("pageNo");

		final ArrayList<Product> products = ProductsQuery.getAllProducts(searchField);
		final HTMLElementList<HTMLProductElement> htmlProducts = new HTMLElementList<HTMLProductElement>();

		for (final Product product: products) {
			htmlProducts.add(HTMLElementFactory.getHTMLFromProduct(product));
		}
		
		out.println(htmlProducts);

	}
}