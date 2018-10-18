package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Reimbursements;
import com.revature.model.User;

public class HibernateUtil {
	private static SessionFactory sf = sessionFactory("hibernate.cfg.xml");
	
	private static SessionFactory sessionFactory(String filename) {
		Configuration config = new Configuration().configure(filename);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Employee.class);
		config.addAnnotatedClass(Manager.class);
		config.addAnnotatedClass(Reimbursements.class);
		
		ServiceRegistry serviceR = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		
		return config.buildSessionFactory(serviceR);
	}
	
	public static Session getSession() {
		return sf.openSession();
	}
	
	public static void shutdown() {
		sf.close();
	}
}
