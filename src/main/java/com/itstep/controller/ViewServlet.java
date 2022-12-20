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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		List<Book> books = BookDao.getAllBooks();
		
		out.append("<html>");
		out.append("<head>");
		out.append("<title>");
		out.append("Book Lising");
		out.append("</title>");
		out.append("<style>");
		out.append("table, th, td {border: 1px solid black;border-collapse: collapse;}");
		out.append("table {width:50%}");
		out.append("</style>");
		out.append("</head>");
		out.append("<body>");
		out.append("<table>");
		
		out.append("<tr>");
		out.append("<th>");
		out.append("ISBN");
		out.append("</th>");
		out.append("<th>");
		out.append("Title");
		out.append("</th>");
		out.append("<th>");
		out.append("Author");
		out.append("</th>");
		out.append("<th>");
		out.append("Publisher");
		out.append("</th>");
		out.append("<th>");
		out.append("Year");
		out.append("</th>");
		out.append("<th>");
		out.append("Price");
		out.append("</th>");
		out.append("<th>");
		out.append("Edit");
		out.append("</th>");
		out.append("<th>");
		out.append("Delete");
		out.append("</th>");
		out.append("</tr>");
		
		for(Book b : books) {
			out.append("<tr>");
			out.append("<td>");
				out.append(b.getISBN());
			out.append("</td>");
			out.append("<td>");
				out.append(b.getTitle());
			out.append("</td>");
			out.append("<td>");
				out.append(b.getAuthor());
			out.append("</td>");
			out.append("<td>");
				out.append(b.getPublisher());
			out.append("</td>");
			out.append("<td>");
				out.print(b.getYear());
			out.append("</td>");
			out.append("<td>");
				out.print(b.getPrice());
			out.append("</td>");
			out.append("<td>");
			out.append("<a href=\"EditServlet?isbn=" + b.getISBN() + "\">Edit</a> ");
			out.append("</td>");
			out.append("<td>");
			out.append("<a href=\"DeleteServlet?isbn=" + b.getISBN() 
			+ "\" onclick=\"return confirm('Are you sure you want to delete this item?');\">Delete</a>");
			
			out.append("</td>");
			out.append("</tr>");
			
			
		}
		out.append("</table>");
		out.append("</body>");
		out.append("</html>");
	}

}
