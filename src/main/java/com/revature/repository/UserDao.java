package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDao {
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Employee").list();
	}
	
	public User getUserByName(String aName) {
		Session session = HibernateUtil.getSession();
		User found = null;
		List<User> users = new ArrayList<>();
		
		users = session.createQuery(
				"from Employee where username = :nameVar")
				.setString("nameVar", aName).list();
		if(!users.isEmpty()) {
			found = users.get(0);
		}
		
		//session.getTransaction().commit();
		return found;
	}
	
	public void saveUser(User newUser) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(newUser);
		tx.commit();
	}
}
