package com.itstep.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.dao.BookDao;
import com.itstep.model.Book;

/**
 * Servlet implementation class ApplyEditServlet
 */
@WebServlet("/ApplyEditServlet")
public class ApplyEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String ISBN = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		int year = Integer.parseInt(request.getParameter("year"));
		float price = Float.parseFloat(request.getParameter("price"));
		
		Book updateBook = new Book(ISBN, title, author, publisher, year, price);
		
		int status = BookDao.update(updateBook);
		
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.print("Sorry, failed to update.");
		}
	}

}
