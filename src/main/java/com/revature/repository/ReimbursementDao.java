package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Reimbursements;
import com.revature.util.HibernateUtil;

public class ReimbursementDao {
	public List<Reimbursements> getReimbursements() {
		List<Reimbursements> list = new ArrayList<>();
		return list;
	}
	
	public void saveReimbursement(Reimbursements reimbursement) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(reimbursement);
		tx.commit();
	}
}
