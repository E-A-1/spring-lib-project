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
import com.nttdata.dao.StudentDAO;
import com.nttdata.domain.Student;

public class StudentLogin implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(StudentLogin.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int studentid = Integer.parseInt(request.getParameter("student_id"));
		String password = request.getParameter("password");
		int flag = -1;
		List student = null;
		StudentDAO dao = new StudentDAO();
		try {
			student = dao.validateStudent(studentid);
			log.info(student);
			for (Object object : student) {

				Student studentp = (Student) object;
				if (studentp.getPassword().equals(password)) {
					flag = 0;
					break;
				}
			}
			log.info("Flag in login " + flag);
			if (flag == 0) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("StudentHome.jsp");
				request.setAttribute("Name", studentid);
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("StudentLogin.jsp");
				request.setAttribute("Err",
						"username are password is incorrect");
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