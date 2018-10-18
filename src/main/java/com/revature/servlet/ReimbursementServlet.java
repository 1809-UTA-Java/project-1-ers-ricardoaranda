package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.model.Reimbursements;
import com.revature.repository.EmployeeDao;
import com.revature.repository.ReimbursementDao;

@WebServlet("/submit-form")
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		ReimbursementDao rdao = new ReimbursementDao();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String reimbursementId = UUID.randomUUID().toString();
		//
//		HttpSession session = request.getSession();
//		request.getRequestDispatcher("employee-homepage.html").forward(request, response);
		
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
//		Employee employee = (Employee) request.getAttribute("user");
		EmployeeDao edao = new EmployeeDao();
		Employee employee = (Employee) edao.getEmployeesByName("caco");
		
		Reimbursements newReimbursement = new Reimbursements(reimbursementId, Integer.parseInt(amount), description, time, employee, "travel", "pending");
		
		rdao.saveReimbursement(newReimbursement);
		
		pw.println("Amount: " + amount + ".");
		pw.println("Despription: " + description + ".");
	}

}
