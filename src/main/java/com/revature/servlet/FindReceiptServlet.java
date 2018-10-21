package com.revature.servlet;

import java.io.File;
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
import com.revature.repository.ReimbursementDao;

@WebServlet("/FindReceiptServlet")
public class FindReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindReceiptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDao rdao = new ReimbursementDao();
		Reimbursements reim = (Reimbursements) request.getSession().getAttribute("receipt"); 
		
		PrintWriter pw = response.getWriter();
		String filePath = "/home/developer/Workspace/project-1-ers-ricardoaranda/src/main/webapp/receipt.jpg";
		File file = new File(filePath);
		response.setContentType("text/html");
		
		rdao.findReceipt(reim, file);
		
		pw.println( "<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
					"<meta charset=\"UTF-8\">\n" +
					"<title>Reimbursements</title>\n" +
				"</head>\n" + 
				"<body>\n" +
					"<img src=\"receipt.jpg\" style=\"width:500px;height:600px;\">" +
				"</body>\n" +
				"</html>\n"
		);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
