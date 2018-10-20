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
import com.revature.repository.ReimbursementDao;

@WebServlet("/ViewAllResolvedServlet")
public class ViewAllResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllResolvedServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDao rdao = new ReimbursementDao();
		List<Reimbursements> list = rdao.getResolvedReimbursements();
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		for (int i = 0; i < list.size(); i++) {
			pw.println( "<!DOCTYPE html>\n" +
					"<html>\n" +
					"<head>\n" +
						"<meta charset=\"UTF-8\">\n" +
						"<title>Reimbursements</title>\n" +
					"</head>\n" + 
					"<body>\n" +
						"<ul><b>Transaction number " + (i+1) + "</b>\n" +
							"<li><b>ID: </b>" + list.get(i).getId() + "</li>\n" +
							"<li><b>Description: </b>" + list.get(i).getDescription() +"</li>" +
							"<li><b>Amount: </b>" + list.get(i).getAmmount() + "</li>" +
							"<li><b>Timestamp: </b>" + list.get(i).getSubmitted() + "</li>" +
							"<li><b>Status: </b>" + list.get(i).getStatus() + "</li>" +
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
