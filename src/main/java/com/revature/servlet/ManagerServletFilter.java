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

import com.revature.model.Manager;
import com.revature.model.User;
import com.revature.repository.UserDao;

@WebFilter("/manager")
public class ManagerServletFilter implements Filter {
    public ManagerServletFilter() {
    }
    
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		PrintWriter pw = response.getWriter();
		
		String username = req.getParameter("name");
		String password = req.getParameter("password");
		
		User user = new Manager();
		UserDao udao = new UserDao();
		user = udao.getUserByName(username);
		
		if (user == null) {
			resp.setContentType("text/html");
			
			req.getRequestDispatcher("manager-login.html").include(req, resp);
			pw.println("<font color='red'><b>That user does not exist.</b></font>");
		} 
		else {
			if (!password.equals(user.getPassword()) || !user.getRole().equals("manager")) {
				resp.setContentType("text/html");
				
				req.getRequestDispatcher("manager-login.html").include(req, resp);
				pw.println("<font color='red'><b>The credentials don't match.</b></font>");
			} 
			else {
				req.getSession().setAttribute("user", user);
				chain.doFilter(req, resp);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
