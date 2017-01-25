package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("<div class=\'col-sm-4\'><div class=\'product-image-wrapper\'><div class=\'single-products\'><div class=\'productinfo text-center\'><img src=\'images/home/product1.jpg\' alt=\'\' /><h2>$56</h2><p>FROM SERVLET</p><a href=\'#\' class=\'btn btn-default add-to-cart\'><i class=\'fa fa-shopping-cart\'></i>Add to cart</a></div><div class=\'product-overlay\'><div class=\'overlay-content\'><h2>$56</h2><p>Easy Polo Black Edition</p><a href=\'#\' class=\'btn btn-default add-to-cart\'><i class=\'fa fa-shopping-cart\'></i>Add to cart</a></div></div></div></div></div>");
//   out.println("<p>test<p>");
  }
}