package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

/**
 * Servlet implementation class DisplayProductId
 */
@WebServlet("/DisplayProductId")
public class DisplayProductId extends HttpServlet {
	
	ProductDAO pd = new ProductDAO(); //ProductDAO is thread-safe as for each method a local EntityManager was created.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String stringPrice = request.getParameter("Price");
		float price = Float.parseFloat(stringPrice);
		String stringQoh = request.getParameter("Qoh");
		int qoh = Integer.parseInt(stringQoh);
		Product p = new Product(name,price,qoh);
		pd.addNew(p);
		RequestDispatcher rd = request.getRequestDispatcher("pdtOperation");
		rd.forward(request,response);
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html >");
		out.println("<body>");
		out.println("<h3> Product with Id "+p.getId()+" created!! </h3>");
		out.println("</body></html>");*/
	}

}
