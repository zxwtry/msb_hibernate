package slw03cascade;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

@SuppressWarnings("deprecation")
public class CascadeTest {
	public static void main(String[] args) {
//		test01Init();
//		test02Add();
		test03Query();
	}
	static void test03Query() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Category c1 = (Category)session.get(Category.class, 2);
		
		System.out.println(c1.getId()+"..."+c1.getName());
		
		Set<Category> set = c1.getSons();
		
		System.out.println(set.size());
		
		for (Category c2 : set) {
			System.out.println(c2.getName());
		}
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	static void test02Add() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Category c1 = new Category();
		c1.setName("手机");
		
		Category c2 = new Category();
		c2.setName("小米");
		Category c3 = new Category();
		c3.setName("魅族");
		
		Set<Category> set = new HashSet<Category>();
		set.add(c2);
		set.add(c3);
		c1.setSons(set);
		
		session.save(c1);
		
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
