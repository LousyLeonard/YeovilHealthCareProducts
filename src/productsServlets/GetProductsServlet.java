package productsServlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import utilities.DemoHTMLElement;
import utilities.HTMLElementList;
import utilities.HTMLProductElement;

public class GetProductsServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    HTMLElementList<HTMLProductElement> products = new HTMLElementList<HTMLProductElement>();
    
    products.add(DemoHTMLElement.getDemoHTMLElement());
    products.add(DemoHTMLElement.getDemoHTMLElement());
    products.add(DemoHTMLElement.getDemoHTMLElement());
    
    out.println(products);

  }
}