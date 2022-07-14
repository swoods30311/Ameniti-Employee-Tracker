package com.sandywoods.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sandywoods.hibernate.entity.Employee;



public class DeleteEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {								
			int employeeId = 3;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting student with id: " + employeeId);
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			// delete employee id=1 the HQL way
			System.out.println("Deleting employee id=3");
			session.createQuery("delete from Employee where id=3").executeUpdate();
				
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
