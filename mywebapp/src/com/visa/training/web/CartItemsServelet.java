package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

/**
 * Servlet implementation class CartItemsServelet
 */
@WebServlet("/CartItems")
public class CartItemsServelet extends HttpServlet {
	ProductDAO dao = new ProductDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		HttpSession session = request.getSession();
		Set<String> ids_aux = (Set<String>) session.getAttribute("list");
		Set<Integer> ids = ids_aux.stream().map(Integer::parseInt).collect(Collectors.toSet());
		if(ids==null){
			out.println("<h3>Cart is empty1</h3>");
		}
		else{
			List<Product> all = ids.stream().map(dao::findOne).collect(Collectors.toList());
			out.println("<table border=1>");
			out.println("<tr><th>Id</th><th>Company</th><th>Price</th><th>Qoh</th><th>Select</th></tr>");
			for(Product pro:all){
				out.println("<tr><td>"+pro.getId()+"</td><td>"+pro.getName()+"</td><td>"+pro.getPrice()+"</td><td>"+pro.getQoh()+
						"</td></tr>");
			}
			out.println("</table>");
			out.println("<a href=home.html> Back to Home Page</a>");
			out.println("</body></html>");
		}
		
	}

	

}
