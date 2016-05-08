package slw03map;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class StudentTest {
	public static void main(String[] args) {
//		test01Init();
//		test02Add();
//		test03Query();
	}
	
	static void test03Query() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student)session.get(Student.class, 1);
		System.out.println(student.getName());
		student.setName("stu1Changess");
		session.save(student);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public static void test01Init() {
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
	static void test02Add() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Map<String, String> map = new HashMap<String,String>();
		map.put("吃", "只要能吃的都吃");
		map.put("喝", "只要能喝的都喝");
		map.put("睡", "只要能睡都睡");
		Student student = new Student("stu1",map);
		session.save(student);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}