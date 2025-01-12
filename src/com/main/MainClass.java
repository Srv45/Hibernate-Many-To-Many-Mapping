package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Course;
import com.entities.Student;

public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Course.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Student s1 = new Student();
		s1.setName("Shubham");

		Student s2 = new Student();
		s2.setName("Vishal");

		Student s3 = new Student();
		s3.setName("Ayra");

		Course c1 = new Course();
		c1.setC_Id(101);
		c1.setTitle("Java Fullstack");

		Course c2 = new Course();
		c2.setC_Id(102);
		c2.setTitle("Python");

		Course c3 = new Course();
		c3.setC_Id(103);
		c3.setTitle("Cloud & DevOps");

		Course c4 = new Course();
		c4.setC_Id(104);
		c4.setTitle("Machine Learning");

		s1.getCourses().add(c1);
		s1.getCourses().add(c4);

		s2.getCourses().add(c3);
		s2.getCourses().add(c2);

		s3.getCourses().add(c1);
		s3.getCourses().add(c3);

		ss.persist(s1);
		ss.persist(s2);
		ss.persist(s3);
		
		ss.persist(c1);
		ss.persist(c2);
		ss.persist(c3);
		ss.persist(c4);

		tr.commit();
		ss.close();

		System.out.println("Data inserted successfully");
	}

}
