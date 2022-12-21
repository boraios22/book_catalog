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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String isbn = request.getParameter("isbn");
		Book book = BookDao.getBookByIsbn(isbn);
		
		out.print("<form action='ApplyEditServlet' method='post'>");
		out.print("ISBN: <input readonly type='text' name='isbn' value='" + book.getISBN() + "'>");
		out.print("<br/>");
		out.print("Title: <input type='text' name='title' value='" + book.getTitle() + "'>");
		out.print("<br/>");
		out.print("Author: <input type='text' name='author' value='" + book.getAuthor() + "'>");
		out.print("<br/>");
		out.print("Publisher: <input type='text' name='publisher' value='" + book.getPublisher() + "'>");
		out.print("<br/>");
		out.print("Year: <input type='text' name='year' value='" + book.getYear() + "'>");
		out.print("<br/>");
		out.print("Price: <input type='text' name='price' value='" + book.getPrice() + "'>");
		out.print("<br/>");
		out.print("<input type='submit' value='Update'>");
		out.print("</form>");
		
	}

}
