package com.nttdata.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.dao.AdminDao;
import com.nttdata.dao.DAOAppException;
import com.nttdata.dao.DeleteBookDao;
import com.nttdata.dao.UpdatePriceDao;
import com.nttdata.dao.UpdateQuantityDao;
import com.nttdata.domain.Admin;
import com.nttdata.domain.BookDetails;

public class UpdateQuantity implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(UpdateQuantity.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {			
		PrintWriter out = response.getWriter();
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));		
		
			try {
				if(UpdateQuantityDao.UpdateP(isbn, quantity)!=0) {
							RequestDispatcher dispatcher=request.getRequestDispatcher("..\\Pages\\UpdateQuantitySuccess.jsp");
							request.setAttribute("success", "Update Quantity Success");
							dispatcher.forward(request, response);

				}
				else {
					System.out.println("not Updated");
				}
			} catch (ServletException | IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			catch (DAOAppException e) {
				System.out.println(e);
					e.printStackTrace();
			}
		
	}
}