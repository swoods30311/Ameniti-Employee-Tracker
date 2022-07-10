package com.sandywoods.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sandywoods.hibernate.entity.Employee;

public class CreateEmployeeAutoGenId {

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
			// create 3 student objects
			System.out.println("Creating employee objects...");
			Employee model1 = new Employee("Sandy","Woods","Technology");
			Employee model2 = new Employee("Trevor","Travers","Technology");
			Employee model3 = new Employee("Chris","Sarpong","Design");
			Employee model4 = new Employee("Trenton","Travers","Fitness");
			
			
			
			//Start Txn
			session.beginTransaction();
			
			//save employees to db server
			System.out.println("Saving the employees...");
			session.save(model1);
			session.save(model2);
			session.save(model3);
			session.save(model4);

			
			//commit txn
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}

}
