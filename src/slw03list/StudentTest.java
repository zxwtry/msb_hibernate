package slw03list;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class StudentTest {
	public static void main(String[] args) {
//		test01Init();
		test02Add();
	}
	public static void test01Init() {
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	public static void test02Add() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setName("name02");
		List<String> hobby = new ArrayList<String>();
		hobby.add("吃");
		hobby.add("喝");
		hobby.add("睡");
		student.setHobby(hobby);
		session.save(student);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}