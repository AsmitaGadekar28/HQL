package com.MainClass;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Entity.Employee;

public class GetSingleRecord {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s= sf.openSession();
		Transaction t =s.beginTransaction();
		
	    String hqlQuery="from Employee where EmpID =:EmpID";
		Query query=s.createQuery(hqlQuery);
		query.setParameter("EmpID",1);
		Employee e=(Employee) query.getSingleResult();  //get single record=select * from employee where EmpID=5;
		System.out.println(e);
		

	}

}
