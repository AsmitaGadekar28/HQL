package com.MainClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Entity.Employee;

public class DeleteRecords {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s= sf.openSession();
		Transaction t =s.beginTransaction();
		
		String hqlQuery="delete from Employee where EmpID = :myid";
		int myid=3;
		Query <Employee>query=s.createQuery(hqlQuery);
		query.setParameter("myid",7);
		query.executeUpdate();
		t.commit();
		s.close();
		System.out.println("Data is deleted Successfully");
	}

}
