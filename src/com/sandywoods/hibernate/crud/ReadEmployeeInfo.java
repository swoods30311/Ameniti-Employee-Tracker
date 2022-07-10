package com.sandywoods.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sandywoods.hibernate.entity.Employee;

public class ReadEmployeeInfo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a employee object
			System.out.println("Creating employee");
			Employee tempEmployee = new Employee("Daffy", "Duck", "Comedy");
			
			// start a transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("Saving employee");
			System.out.println(tempEmployee);
			session.save(tempEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			
			// find out the employees id: primary key
			System.out.println("Saved employee. Generated EmployeeId: " + tempEmployee.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting employee with id: " + tempEmployee.getId());
			
			Employee emp1 = session.get(Employee.class, tempEmployee.getId());
			
			System.out.println("Get complete: " + emp1);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





