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

import com.revature.model.Employee;
import com.revature.model.User;

@WebFilter("/employee")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		User dummy = new Employee("0", "caco", "asdf", "Ricardo", "Aranda", "email@gmail.com", "employee");
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		
		if (!username.equals(dummy.getUsername()) || !password.equals(dummy.getPassword())) {
			response.setContentType("text/html");
			
			request.getRequestDispatcher("employee-login.html").include(request, response);
			pw.println("<font color='red'><b>Wrong user name or password.</b></font>");
		}
		else {
			request.setAttribute("user", dummy);
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
