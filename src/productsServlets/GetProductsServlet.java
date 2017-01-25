package productsServlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import core.Product;
import utilities.HTMLElementList;

public class GetProductsServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    HTMLElementList<Product> products = new HTMLElementList<Product>();
    
    products.add(new Product());
    products.add(new Product());
    products.add(new Product());

    
    out.println(products);

  }
}