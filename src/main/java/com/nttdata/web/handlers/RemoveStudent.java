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
import com.nttdata.dao.DAOAppException;
import com.nttdata.dao.DeleteBookDao;
import com.nttdata.dao.RemoveStudentDao;
import com.nttdata.domain.BookDetails;

public class RemoveStudent implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(RemoveStudent.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
		
		RemoveStudentDao dao = new RemoveStudentDao();
		
		int studentid=Integer.parseInt(request.getParameter("studentid"));
		
			try {
				if(RemoveStudentDao.Deletestu(studentid)!=0) {
							RequestDispatcher dispatcher=request.getRequestDispatcher("..\\Pages\\RemoveSuccess.jsp");
							request.setAttribute("success", "Remove Success");
							dispatcher.forward(request, response);

				}
				else {
					System.out.println("not Removed");
				}
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (DAOAppException e) {
					e.printStackTrace();
			}
		
	}
}