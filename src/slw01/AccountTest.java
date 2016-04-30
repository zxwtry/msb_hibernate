package slw01;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class AccountTest {
	public static void main(String[] args) {
		// test01Add();
		// test02Add2();
		// test03Update();
		// test04Delete();
		// test05Care();
		// test06FindAll();
		testHibernateUtilsAdd();
	}
	
	@Test
	public static void test01Create() {
		/*
		 * 	创建表
		 *  Configuration config = new Configuration().configure(cfg);
		 *  SchemaExport se = new SchemaExport(config);
		 *  se.create(ture,true);
		 */
		//默认去找hibernate.cfg.xml文件，并解析
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		//对生成DDL语句进行格式化
//		schemaExport.setFormat(true);
//		schemaExport.setDelimiter(" ");
//		schemaExport.setOutputFile("account.sql");
		//第一个说明导出的时候采用默认的格式
		schemaExport.create(true, true);
	}
	
	public static void test01Add() {
		//加载并解析hibernate.cfg.xml文件
		Configuration configuration = new Configuration().configure();
		//创建SessionFactory对象
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//创建Session接口负责CRUD
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		Account account = new Account();
		account.setName("李四");
		account.setAge(30);
		account.setScore(20.16);
		account.setBirthday(new Date());
		
		session.save(account);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public static void test02Add2() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Account account = new Account();
		account.setName("Wangwu");
		account.setAge(100);
		account.setScore(76.10);
		account.setBirthday(new Date());
		session.save(account);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public static void test03Update() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//所有的操作都必须放在事物里面，如果发生异常，需要rollback
		try {
			Account account = (Account)session.get(Account.class, 1);
			System.out.println(account);
			account.setName("NewNewName");
			session.update(account);
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	
	public static void test04Delete() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//所有的操作都必须放在事物里面，如果发生异常，需要rollback
		try {
			Account account = (Account)session.get(Account.class, 1);
			session.delete(account);
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	
	public static void test05Care() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//所有的操作都必须放在事物里面，如果发生异常，需要rollback
		try {
			Account account = (Account)session.get(Account.class, 1999);
			System.out.println(account.getId());
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test06FindAll() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//所有的操作都必须放在事物里面，如果发生异常，需要rollback
		try {
//			String sql = "from Account";
//			Query query = session.createQuery(sql);
			String sql = "select * from acc_tab";
			Query query = session.createSQLQuery(sql);
			@SuppressWarnings("unchecked")
			List<Account> list = (List<Account>) query.list();
			for (Account account : list) {
				System.out.println(account);
			}
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testHibernateUtilsAdd() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		try {
			Account account = new Account();
			account.setName("王武");
			account.setScore(99);
			account.setBirthday(new Date());
			account.setAge(23);
			session.save(account);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}
	
	
}
