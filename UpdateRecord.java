package com.MainClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Entity.Employee;

public class UpdateRecord {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s= sf.openSession();
		Transaction t=s.beginTransaction();
		
		String hqlQuery="update Employee set name=:myname,Salary=:mySalary where EmpID=:myid";
		MutationQuery query =s.createMutationQuery(hqlQuery);
		query.setParameter("myname", "Anil");
		query.setParameter("mySalary", 40000);
		query.setParameter("myid", 4);
		query.executeUpdate();
		System.out.println("Data is updated..........");
		t.commit();
		s.close();
		
	}

}
