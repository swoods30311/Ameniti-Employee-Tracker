package com.sandywoods.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sandywoods.hibernate.entity.Employee;

public class QueryForEmployee {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// query employees
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			
			// display the employees
			displayEmployees(theEmployees);
			
			// query students: lastName='Travers'
			theEmployees = session.createQuery("from Employee e where e.lastName='Travers'").getResultList();
			
			// display the employees
			System.out.println("\n\nEmployees who have last name of Travers");
			displayEmployees(theEmployees);
			
			// query students: lastName='Travers' OR firstName='Trenton'
			theEmployees =
					session.createQuery("from Employee e where"
							+ " e.lastName='Travers' OR e.firstName='Trenton'").getResultList();
			
			System.out.println("\n\nEmployees who have last name of Travers OR first name Trenton");
			displayEmployees(theEmployees);
			
			// query employees where dept LIKE 'CEO'
			theEmployees = session.createQuery("from Employee e where"
					+ " e.department LIKE '%CEO'").getResultList();

			System.out.println("\n\nEmployees whose dept ends with nology");			
			displayEmployees(theEmployees);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}





