package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

/**
 * Servlet implementation class ViewProducts
 */
@WebServlet("/productView")
public class ViewProducts extends HttpServlet {
	ProductDAO dao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> all = dao.findAll();
		request.setAttribute("listOfProducts", all);
		RequestDispatcher rd = request.getRequestDispatcher("productlist2.jsp");
		
		rd.forward(request,response);
		
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html >");
		out.println("<body>");
		out.println("<h3> Product Details </h3>");
		out.println();
		out.println("<form method=\"get\" action=\"ViewCart\">");
		out.println("<table border=1>");
		out.println("<tr><th>Id</th><th>Company</th><th>Price</th><th>Qoh</th><th>Select</th></tr>");
		
		for(Product pro:all){
			out.println("<tr><td>"+pro.getId()+"</td><td>"+pro.getName()+"</td><td>"+pro.getPrice()+"</td><td>"+pro.getQoh()+
					"</td><td><input type=\"checkbox\" name=\"ProductId\" value=\""+pro.getId()+"\"></td></tr>");
		}
		out.println("</table>");
		out.println("<br>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"Add To Cart\">");
		out.println("</form>");
		out.println("<a href=home.html> Back to Home Page</a>");
		out.println("</body></html>");*/
		
		
	}

	

}
