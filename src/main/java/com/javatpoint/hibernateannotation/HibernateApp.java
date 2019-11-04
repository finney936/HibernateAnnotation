package com.javatpoint.hibernateannotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.javatpoint.hibernateannotation.model.Employee;

public class HibernateApp {
	public static void main(String[] args) throws InterruptedException {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Employee e1 = new Employee(); // transient
		e1.setId(101);
		e1.setFirstName("Gaurav");
		e1.setLastName("Chawla");

		session.save(e1);

		t.commit(); // detached

		System.out.println("Successfully saved");

		session.close();
		factory.close();
	}
}
