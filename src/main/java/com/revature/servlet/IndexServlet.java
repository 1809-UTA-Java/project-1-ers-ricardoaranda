package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.User;
import com.revature.repository.EmployeeDao;
import com.revature.repository.UserDao;

@WebServlet("/home")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("employee-homepage.html");
//		request.getRequestDispatcher("submit-form").forward(request, response);
		PrintWriter pw = response.getWriter();
		User user = (User) request.getAttribute("user");
		
		rd.include(request, response);
		
//		UserDao udao = new UserDao();
		EmployeeDao edao = new EmployeeDao();
		
		// TEST
//		udao.saveUser(user);
		
//		List<User> list = udao.getUsers();
//		pw.println("Email : " + list.get(0).getEmail());
		
//		user = udao.getUserByName("caco");
//		pw.println("From DB : " + user.getEmail());
		
		user = edao.getEmployeesByName("caco");
		pw.println("Email: " + user.getEmail());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
