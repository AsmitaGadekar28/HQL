package com.MainClass;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Entity.Employee;

public class GetAllRecord {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s= sf.openSession();
		Transaction t =s.beginTransaction();
		
	    String hqlQuery="from Employee";//class name should be enter in hqlquery.hcp is case sensitive.
		Query<Employee> query=s.createQuery(hqlQuery,Employee.class);
		List<Employee> list=query.getResultList();
		 
		for(Employee employee : list)
		 {
			System.out.println( employee);
		   }
			
		 
	}

}
