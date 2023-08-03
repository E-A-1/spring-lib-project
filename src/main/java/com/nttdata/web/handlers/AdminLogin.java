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
import com.nttdata.domain.Admin;

public class AdminLogin implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(AdminLogin.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int adminid = Integer.parseInt(request.getParameter("admin_id"));
		String password = request.getParameter("password");
		int flag = -1;
		List admin = null;
		AdminDao dao = new AdminDao();
		try {
			admin = dao.validateUser(adminid);
			log.info(admin);
			for (Object object : admin) {

				Admin user = (Admin) object;
				if (user.getPassword().equals(password)) {
					flag = 0;
					break;
				}
			}
			log.info("Flag in login " + flag);
			if (flag == 0) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AdminHome.jsp");
				request.setAttribute("Name", adminid);
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AdminLogin.jsp");
				request.setAttribute("Err",
						"username and password is incorrect");
				dispatcher.forward(request, response);
			}

		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

		}

	}
}
