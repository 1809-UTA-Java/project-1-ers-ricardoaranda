package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Reimbursements;
import com.revature.model.User;
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
	
	public List<Reimbursements> getReimbursementsByAuthor(User author) {
		Session session = HibernateUtil.getSession();
		List<Reimbursements> list = new ArrayList<>();
		String hql = "from Reimbursements where author = :author_id";
		Query query = session.createQuery(hql);
		
		query.setParameter("author_id", author);
		list = query.list();
		
		return list;
	}
	
	public List<Reimbursements> getPendingReimbursements() {
		Session session = HibernateUtil.getSession();
		List<Reimbursements> list = new ArrayList<>();
		String hql = "from Reimbursements where status = :pending";
		Query query = session.createQuery(hql);
		
		query.setParameter("pending", "pending");
		list = query.list();
		
		return list;
	}
}
