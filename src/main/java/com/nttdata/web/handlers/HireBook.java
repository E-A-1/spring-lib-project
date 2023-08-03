package com.nttdata.web.handlers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.nttdata.dao.BookHireDao;

import com.nttdata.dao.DAOAppException;
import com.nttdata.domain.BookDetails;
import com.nttdata.domain.BookHireList;
import com.nttdata.mvc.HttpRequestHandler;


public class HireBook implements HttpRequestHandler {
	static Logger log = Logger.getLogger(HireBook.class);
	

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookHireDao dao = new BookHireDao();
		BookHireList book = new BookHireList();
		
		book.setHireid(Integer.parseInt(request.getParameter("hireid")));
		book.setBookid(Integer.parseInt(request.getParameter("bookid")));
		book.setStudentid(Integer.parseInt(request.getParameter("studentid")));
		book.setBookname(request.getParameter("bookname"));
		book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		book.setAuthor(request.getParameter("author"));
		book.setPublisher(request.getParameter("publisher"));
		book.setEdition(request.getParameter("edition"));
		book.setPrice(Integer.parseInt(request.getParameter("price")));
		book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		book.setHireDate(request.getParameter("hiredate"));
		book.setReturnDate(request.getParameter("returndate"));


		boolean isExists;
		try {
			isExists = dao.validateUser(book.getStudentid(), book.getHireid());

			if (isExists) {
				log.info("Book already registered");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\Pages\\BookRegister.jsp");
				request.setAttribute("Err",
						"Book already registered with the system");
				dispatcher.forward(request, response);
			} else {
//				user.setPassword(Integer.toString(book.getPortalID()));
				int finalRes = dao.hireBook(book);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\Pages\\successbook.jsp");
					request.setAttribute("success",
							"Book succesfully registered with the system");
					request.setAttribute("details", book);
					dispatcher.forward(request, response);
				}
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}

