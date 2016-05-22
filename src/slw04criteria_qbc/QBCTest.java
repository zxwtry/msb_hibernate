package slw04criteria_qbc;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class QBCTest {
	public static void main(String[] args) {
//		test01Init();
//		test02Add();
//		test03Query();
//		test04_QBC_Select1();
		test05_QBC_Select2();
	}
	static void test05_QBC_Select2() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Book> list = session.createCriteria(Book.class)
							.add(Restrictions.like("bookName", "book%"))
							.addOrder(Order.asc("bookId"))
							.list();
		Iterator<Book> iterator = list.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			System.out.printf("BookName: %s  \r\nStudentName: %s\r\n", book.getBookName(), book.getStudent().getStudentName());
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	static void test04_QBC_Select1() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Book.class);
		Criterion criterion1 = Restrictions.like("bookName", "book%");
		criteria.add(criterion1);
		criteria.addOrder(Order.desc("bookId"));
		@SuppressWarnings("unchecked")
		List<Book> list = criteria.list();
		Iterator<Book> iterator = list.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			System.out.printf("BookName: %s  \r\nStudentName: %s\r\n", book.getBookName(), book.getStudent().getStudentName());
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	static void test03Query() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Book book = (Book) session.load(Book.class, 8);
		System.out.println();
		System.out.println("book.student : "+book.getStudent().getStudentName());
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
 	static void test02Add() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setStudentName("stu2");
		session.save(student);
		
		Book book1 = new Book();
		book1.setBookName("book5");
		book1.setStudent(student);
		Book book2 = new Book();
		book2.setBookName("book6");
		book2.setStudent(student);
		Book book3 = new Book();
		book3.setBookName("book7");
		book3.setStudent(student);
		Book book4 = new Book();
		book4.setBookName("book8");
		book4.setStudent(student);
		session.save(book1);
		session.save(book2);
		session.save(book3);
		session.save(book4);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
	static void test01Init() {
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);	
	}
}
