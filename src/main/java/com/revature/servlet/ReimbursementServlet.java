package com.revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.revature.model.Employee;
import com.revature.model.Reimbursements;
import com.revature.repository.ReimbursementDao;

@MultipartConfig
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
		
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		Part filePart = request.getPart("receipt");
		byte[] image = null;
		
		InputStream inputStream = filePart.getInputStream();
		
		Employee employee = (Employee) request.getSession().getAttribute("user");
		
		Reimbursements newReimbursement = new Reimbursements(reimbursementId, Integer.parseInt(amount), description, time, employee, "travel", "pending");
		
		if (filePart != null) {
			image = IOUtils.toByteArray(inputStream);
			newReimbursement.setReceipt(image);
		}
		
		rdao.saveReimbursement(newReimbursement);
		
		request.getRequestDispatcher("employee-homepage.html").include(request, response);
		pw.println("Your request was submitted");
	}

}
