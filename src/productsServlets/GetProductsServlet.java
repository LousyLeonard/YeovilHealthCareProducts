package productsServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.HTMLElementFactory;
import core.HTMLPageElement;
import core.HTMLProductElement;
import core.Product;
import database.ProductsQuery;
import utilities.OuterBracketlessList;
import utilities.StringUtils;

public class GetProductsServlet extends HttpServlet {
	@Override
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response)
					throws ServletException, IOException {
		final PrintWriter out = response.getWriter();

		final String searchField = request.getParameter("search");
		final String pageNoField = request.getParameter("pageNo");
		final Integer pageNo = Integer.parseInt(pageNoField);

		final OuterBracketlessList<String> searchterms = 
				new OuterBracketlessList<String>(StringUtils.getWordsInField(searchField));
		
		final ArrayList<Product> products = 
				ProductsQuery.getAllProducts(searchterms, pageNo);
		final OuterBracketlessList<HTMLProductElement> htmlProducts = 
				new OuterBracketlessList<HTMLProductElement>();
		
		final HTMLPageElement htmlPage = 
				new HTMLPageElement(Integer.parseInt(pageNoField),
						ProductsQuery.getTotalProducts(searchterms) / 20);

		for (final Product product: products) {
			htmlProducts.add(HTMLElementFactory.getHTMLFromProduct(product));
		}

		out.println(htmlProducts);
		out.println(htmlPage);
	}
}