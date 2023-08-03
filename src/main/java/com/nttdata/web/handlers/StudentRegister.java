package com.nttdata.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.dao.DAOAppException;
import com.nttdata.dao.StudentRegisterDAO;
import com.nttdata.domain.Student;

public class StudentRegister implements HttpRequestHandler {
	static Logger log = Logger.getLogger(StudentRegister.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentRegisterDAO dao = new StudentRegisterDAO();
		Student student = new Student();
		student.setStudentid(Integer.parseInt(request.getParameter("student_id")));
		student.setStudentNo(Integer.parseInt(request.getParameter("student_no")));
		student.setName(request.getParameter("student_name"));
		//password
		student.setPassword(request.getParameter("password"));
		student.setEmail(request.getParameter("email"));
		student.setContact(Integer.parseInt(request.getParameter("phno")));

		boolean isExists;
		try {
			isExists = dao.validateStudent(student.getStudentid());

			if (isExists) {
				log.info("User already registered");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\StudentLogin.jsp");
				request.setAttribute("Err",
						"User already registered with the system");
				dispatcher.forward(request, response);
			} /*else {
				student.setPassword("nttdata@"
						+ Integer.toString(student.getStudentid()));*/
				int finalRes = dao.registerStudent(student);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\Pages\\success.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", student);
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