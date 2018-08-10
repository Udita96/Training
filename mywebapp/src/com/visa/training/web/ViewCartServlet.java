package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/ViewCart")
public class ViewCartServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selected = request.getParameterValues("ProductId");
		Set<String> l = new HashSet<>(Arrays.asList(selected));
		HttpSession session = request.getSession();
		Set<String> pdtList =  (Set<String>) session.getAttribute("list");
		if(pdtList==null)
		{
			pdtList=l;
		}
		else{
			pdtList.addAll(l);
		}
		session.setAttribute("list", pdtList);
		
		PrintWriter out = response.getWriter();
		
			out.println("<a href=home.html>Back to Home</a>");
		
	}

	

}
