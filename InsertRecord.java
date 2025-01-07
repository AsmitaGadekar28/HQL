package com.MainClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Entity.Employee;

public class InsertRecord {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s= sf.openSession();
		Transaction t=s.beginTransaction();
		
		String hqlQuery ="insert into Employee(Salary,name,Domain)values(:mySalary,:myname,:myDomain)";
		MutationQuery query =s.createMutationQuery(hqlQuery);
		query.setParameter("myname", "Rohit");
		query.setParameter("mySalary",41000);
		query.setParameter("myDomain", "Project Manager");
		query.executeUpdate();
		t.commit();
		s.close();
		System.out.println("Data is inserted.......");
	}

}
