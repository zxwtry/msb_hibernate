package slw032o2m;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class O2mTest {
	public static void main(String[] args) {
//		test01Init();
//		test02Add();
		test02AddFirstManyThenOne();
//		test03Query();
	}
	static void test03Query() {
		
	}
	static void test02AddFirstManyThenOne() {
		// 这样添加更加合理
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Account account = new Account();
		account.setAccName("acc2");
		
		session.save(account);
		
		Orders orders1 = new Orders();
		orders1.setOrderNum("1003");
		orders1.setOrderTime(new Date());
		orders1.setAccount(account);
		Orders orders2 = new Orders();
		orders2.setOrderNum("1004");
		orders2.setOrderTime(new Date());
		orders2.setAccount(account);
		
		session.save(orders1);
		session.save(orders2);
		
		Set<Orders> set = new HashSet<Orders>();
		set.add(orders1);
		set.add(orders2);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	static void test02Add() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Orders orders1 = new Orders();
		orders1.setOrderNum("1001");
		orders1.setOrderTime(new Date());
		Orders orders2 = new Orders();
		orders2.setOrderNum("1002");
		orders2.setOrderTime(new Date());
		
		session.save(orders1);
		session.save(orders2);
		
		Set<Orders> set = new HashSet<Orders>();
		set.add(orders1);
		set.add(orders2);
		
		Account account = new Account();
		account.setAccName("acc1");
		account.setSetOrders(set);
		
		session.save(account);
		
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
