package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Reimbursements;
import com.revature.model.User;
import com.revature.repository.EmployeeDao;
import com.revature.repository.ReimbursementDao;

@WebServlet("/ViewReimbursementByEmployee")
public class ViewReimbursementByEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewReimbursementByEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDao rdao = new ReimbursementDao();
		List<Reimbursements> list = rdao.getPendingReimbursements();
		PrintWriter pw = response.getWriter();
		
		String author = request.getParameter("author");
		EmployeeDao edao = new EmployeeDao();
		User user = edao.getEmployeesByName(author);
		List<Reimbursements> reim = (List<Reimbursements>) rdao.getReimbursementsByAuthor(user);
		
//		User user = edao.getEmployeesByName(author);
		
		response.setContentType("text/html");
		
		for (int i = 0; i < reim.size(); i++) {
			pw.println( "<!DOCTYPE html>\n" +
					"<html>\n" +
					"<head>\n" +
						"<meta charset=\"UTF-8\">\n" +
						"<title>Reimbursements</title>\n" +
					"</head>\n" + 
					"<body>\n" +
						"<ul>\n" +
							"<li><b>Description: </b>" + reim.get(i).getDescription() +"</li>" +
							"<li><b>Amount: </b>" + reim.get(i).getAmmount() + "</li>" +
							"<li><b>Timestamp: </b>" + reim.get(i).getSubmitted() + "</li>" +
							"<li><b>Status: </b>" + reim.get(i).getStatus() + "</li>" +
						"</ul>\n" +
					"</body>\n" +
					"</html>\n"
			);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
