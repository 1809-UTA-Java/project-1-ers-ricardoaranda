package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Manager;
import com.revature.model.Reimbursements;
import com.revature.model.User;
import com.revature.repository.ReimbursementDao;
import com.revature.repository.UserDao;

@WebServlet("/ApproveReimbursement")
public class ApproveReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApproveReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reimId = request.getParameter("reimId");
//		EmployeeDao edao = new EmployeeDao();
		ReimbursementDao rdao = new ReimbursementDao();
//		User user = edao.getEmployeesByName(author);
		PrintWriter pw = response.getWriter();
//		UserDao udao = new UserDao();
		Manager resolver = (Manager) request.getSession().getAttribute("user");
		
		Reimbursements reim = rdao.getRimbursementById(reimId);
		reim.setResolver(resolver);
		reim.setStatus("approved");
		rdao.setReimbursement(reim);
		
		request.getRequestDispatcher("manager-homepage.html").include(request, response);
		pw.println("<h4>The request was approved.</h4>");
	}

}
