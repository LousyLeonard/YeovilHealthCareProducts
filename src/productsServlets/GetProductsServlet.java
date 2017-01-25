package productsServlets;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import core.HTMLProductElement;
import core.HTMLProductFactory;
import core.Product;
import database.AllProductsQuery;
import utilities.HTMLElementList;

public class GetProductsServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    
    ArrayList<Product> products = AllProductsQuery.getAllProducts();
    HTMLElementList<HTMLProductElement> htmlProducts = new HTMLElementList<HTMLProductElement>();

    for (Product product: products) {
    	htmlProducts.add(HTMLProductFactory.getHTMLFromProduct(product));
    }
    
    out.println(htmlProducts);

  }
}