package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Reimbursements;
import com.revature.model.User;
import com.revature.repository.ReimbursementDao;

@WebServlet("/ViewReimbursementsServlet")
public class ViewReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewReimbursementsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDao rdao = new ReimbursementDao();
		User author = (User) request.getSession().getAttribute("user");
		System.out.println(author);
		List<Reimbursements> list = rdao.getReimbursementsByAuthor(author); 
		
		for (Reimbursements r : list) {
			System.out.println(r.getDescription());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
