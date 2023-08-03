package com.nttdata.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.nttdata.dao.BookRegisterDAO;
import com.nttdata.dao.DAOAppException;
import com.nttdata.domain.BookDetails;
import com.nttdata.mvc.HttpRequestHandler;


public class RegisterBook implements HttpRequestHandler {
	static Logger log = Logger.getLogger(RegisterBook.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookRegisterDAO dao = new BookRegisterDAO();
		BookDetails book = new BookDetails();

		book.setBookname(request.getParameter("bookname"));
		book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		book.setAuthor(request.getParameter("author"));
		book.setPublisher(request.getParameter("publisher"));
		book.setEdtion(request.getParameter("edition"));
		book.setPrice(Integer.parseInt(request.getParameter("price")));
		book.setQuantity(Integer.parseInt(request.getParameter("quantity")));


		boolean isExists;
		try {
			isExists = dao.validateUser(book.getIsbn());

			if (isExists) {
				log.info("Book already registered");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\Pages\\BookRegister.jsp");
				request.setAttribute("Err",
						"Book already registered with the system");
				dispatcher.forward(request, response);
			} else {
//				user.setPassword(Integer.toString(book.getPortalID()));
				int finalRes = dao.registerBook(book);
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

