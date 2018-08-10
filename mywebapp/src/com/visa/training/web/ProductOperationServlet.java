package com.visa.training.web;

import java.io.IOException;
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
 * Servlet implementation class ProductOperationServlet
 */
@WebServlet("/pdtOperation")
public class ProductOperationServlet extends HttpServlet {
	ProductDAO dao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> all = dao.findAll();
		request.setAttribute("listOfProducts", all);
		RequestDispatcher rd = request.getRequestDispatcher("productOperationsPage.jsp");
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}

}
