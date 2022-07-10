package com.sandywoods.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sandywoods.hibernate.entity.Employee;

public class CreateEmployee {
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating employee");
			Employee model1 = new Employee("Sandy", "Woods", "Technology");
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the employee...");
			session.save(model1);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
