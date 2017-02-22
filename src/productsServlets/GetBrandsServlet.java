package productsServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Brand;
import core.HTMLBrandElement;
import core.HTMLElementFactory;
import database.BrandsQuery;
import utilities.OuterBracketlessList;

/**
 * @author lawrence.coles
 *
 */
public class GetBrandsServlet extends HttpServlet {
		
	@Override
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response)
					throws ServletException, IOException {
		final PrintWriter out = response.getWriter();

		final ArrayList<Brand> brands = BrandsQuery.getTopTenBrands();
		final OuterBracketlessList<HTMLBrandElement> htmlProducts = new OuterBracketlessList<HTMLBrandElement>();

		for (final Brand brand : brands) {
			htmlProducts.add(HTMLElementFactory.getHTMLFromBrand(brand));
		}
				
		out.println(htmlProducts);
	}

}