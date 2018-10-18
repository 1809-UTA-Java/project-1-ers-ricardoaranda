package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.model.User;
import com.revature.repository.EmployeeDao;

@WebFilter("/employee")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		PrintWriter pw = response.getWriter();
//		boolean userFound = true;
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = new Employee();
		EmployeeDao edao = new EmployeeDao();
		user = edao.getEmployeesByName(username);
		
		if (user == null) {
			response.setContentType("text/html");
			
			request.getRequestDispatcher("employee-login.html").include(request, response);
			pw.println("<font color='red'><b>That user does not exist.</b></font>");
//			userFound = false;
		}
		else //if (userFound)
		{
			if (!username.equals(user.getUsername()) || !password.equals(user.getPassword())
					|| !user.getRole().equals("employee")) {
				response.setContentType("text/html");
				
				request.getRequestDispatcher("employee-login.html").include(request, response);
				pw.println("<font color='red'><b>The credentials don't match.</b></font>");
			}
			else {
				req.getSession().setAttribute("user", user);
				chain.doFilter(req, resp);
			}
		}
	}

	@Override
	public void destroy() {
		
	}

}
