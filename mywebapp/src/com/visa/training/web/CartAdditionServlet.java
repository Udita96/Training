package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

/**
 * Servlet implementation class CartAdditionServlet
 */
@WebServlet("/CartAdditionServlet")
public class CartAdditionServlet extends HttpServlet {
	
	ProductDAO dao = new ProductDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selected = request.getParameterValues("ProductId");
		
		Map<Product,Integer> cartItems = new LinkedHashMap<>();
		//LinkedHashMap<Product,Integer> aux = (LinkedHashMap<Product,Integer>) request.getAttribute("CartList");
		
		
		HttpSession session = request.getSession();
		LinkedHashMap<Product,Integer> aux= (LinkedHashMap<Product, Integer>) session.getAttribute("CartList");
		Float total = (Float)session.getAttribute("total");
		//Set<String> pdtList =  (Set<String>) session.getAttribute("list");
		int id;
		Product pdt;
		if(selected.length>0){
			if(aux!=null){
				cartItems.putAll(aux);
			}
		for(String str : selected){
			id = Integer.parseInt(str);
			pdt = dao.findOne(id);
			cartItems.put(pdt,1);
			if(total == null){
				total = pdt.getPrice();
			}
			else{
				total+=pdt.getPrice();
			}
		}
		}
		
		session.setAttribute("CartList", cartItems);
		session.setAttribute("total", total);
		RequestDispatcher rd = request.getRequestDispatcher("pdtOperation");
		rd.forward(request,response);
		
		
	}

}
