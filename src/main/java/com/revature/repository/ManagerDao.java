package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class ManagerDao {
	public User getUserByName(String aName) {
		Session session = HibernateUtil.getSession();
		User found = null;
		List<User> users = new ArrayList<>();
		
		users = (List<User>) session.createQuery(
				"from Manager where username = :nameVar")
				.setString("nameVar", aName).list();
		if(!users.isEmpty()) {
			found = users.get(0);
		}
		
		//session.getTransaction().commit();
		return found;
	}
}
