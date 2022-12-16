package com.itstep.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.dao.BookDao;
import com.itstep.model.Book;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		List<Book> books = BookDao.getAllBooks();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("Book Lising");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		
		out.print("<tr>");
		out.print("<th>");
		out.print("ISBN");
		out.print("</th>");
		out.print("<th>");
		out.print("Title");
		out.print("</th>");
		out.print("</tr>");
		
		for(Book b : books) {
			out.print("<tr>");
			out.print("<td>");
				out.print(b.getISBN());
			out.print("</td>");
			out.print("<td>");
				out.print(b.getTitle());
			out.print("</td>");
			out.print("</tr>");
			
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
