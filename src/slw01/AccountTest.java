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
		// testHibernateUtilsAdd();
		// test07UseFlush();
		// test07UseFlush2();
		// test10GetAndLoad();
		// test10GetTwoObject();
		// test11TestUpdate();
		// test13FindAll();
		// test13FindAllOnlyOneUnique();
		// test14();
		// test14Account();
		// test15Fuction02();
		// test15BindArgs2();
		// test15BindArgs3();
		// test16Page();
		// test17Update();
		test18Query();
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
	
	public static void test07UseFlush() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		Account account = (Account) session.get(Account.class, 5);
		account.setName("王武2");
		System.out.println(account);
		transaction.commit();
	}
	
	public static void test07UseFlush2() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		Account account = (Account) session.get(Account.class, 5);
		account.setName("王武3");
		session.flush();
		account.setName("王武4");
		transaction.commit();
	}
	
	public static void testHibernateUtilsAdd() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		try {
			Account account = new Account();
			account.setName("张一");
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
	
	public static void test09State() {
		// 瞬时状态的对象 begin
		Account account = new Account();
		account.setName("瞬时状态");
		account.setAge(100);
		account.setScore(98);
		account.setBirthday(new Date());
		// 瞬时状态的对象 end
		
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		session.save(account);
		transaction.commit();
		
		// 关闭session
		HibernateUtils.closeSession(session);
		
		System.out.println(account);	// account是脱管对象
										/*
										 * 	曾经和session发生过关联
										 * 	session已经被关闭
										 * 	现在account就是脱管对象
										 */
		
	}
	
	public static void test10GetAndLoad() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
//		Account account1 = (Account)session.get(Account.class, 2);
//		System.out.println(account1.getName());
		Account account2 = (Account)session.load(Account.class, 3);
		System.out.println(account2.getId());
		transaction.commit();
	}
	
	public static void test10GetTwoObject() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		Account account1 = (Account)session.get(Account.class, 3);
		Account account2 = (Account)session.get(Account.class, 3);
		System.out.println(account1);
		System.out.println(account2);
		transaction.commit();
	}
	
	public static void test11TestUpdate() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		Account account = (Account)session.get(Account.class, 3);
		transaction.commit();
		HibernateUtils.closeSession(session);
		
		// 脱管对象
		account.setAge(99);
		account.setAge(64);
		account.setName("使用Update2");
		Session session2 = HibernateUtils.getSesssion();
		Transaction transaction2 = session2.beginTransaction();
		session2.update(account);
		transaction2.commit();
		HibernateUtils.closeSession(session2);
	}
	
	public static void test12TestMerge() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		Account account = (Account)session.get(Account.class, 3);
		transaction.commit();
		HibernateUtils.closeSession(session);
		
		// 脱管对象
		account.setAge(99);
		account.setAge(64);
		account.setName("使用Update2");
		Session session2 = HibernateUtils.getSesssion();
		Transaction transaction2 = session2.beginTransaction();
		session2.merge(account);
		transaction2.commit();
		HibernateUtils.closeSession(session2);
	}
	
	public static void test13FindAll() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String sql = "from Account";
		Query query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Account> list = (List<Account>)query.list();
		for (Account account : list) {
			System.out.println(account);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	public static void test13FindAllOnlyOneUnique() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String sql = "from Account";
		Query query = session.createQuery(sql);
		Account account = (Account) query.setMaxResults(1).uniqueResult();
		System.out.println(account);
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 投影查询
	public static void test14() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String sql = "select name,age from Account";
		Query query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> objectList = query.list();
		for (int index = 0; index < objectList.size(); index ++) {
			Object[] objects = (Object[]) objectList.get(index);
			System.out.println(objects[0] +"..."+objects[1]);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 投影查询，实例化投影查询结果
	public static void test14Account() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String sql = "select new Account(name,age) from Account";
		Query query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Account> objectList = query.list();
		for (int index = 0; index < objectList.size(); index ++) {
			Account account = objectList.get(index);
			System.out.println(account);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 调用标准函数upper()
	public static void test15Fuction01() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String sql = "select upper(name) from Account";
		@SuppressWarnings("unchecked")
		List<String> list = session.createQuery(sql).list();
		for (String string : list) {
			System.out.println("name : " + string);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 调用标准函数current_date()
	public static void test15Fuction02() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String hql = "select current_date() from Account";
		@SuppressWarnings("unchecked")
		List<Date> list = session.createQuery(hql).list();
		for (Date date : list) {
			System.out.println(date);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 参数绑定
	static void test15BindArgs1() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String hql = "from Account where score>:minScore";
		@SuppressWarnings("unchecked")
		List<Account> list = session.createQuery(hql)
							.setParameter("minScore", 76.0)
							.list();
		for (Account account : list) {
			System.out.println(account);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 参数绑定
	static void test15BindArgs2() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String hql = "from Account where score>:minScore";
		@SuppressWarnings("unchecked")
		List<Account> list = session.createQuery(hql)
							.setDouble("minScore", 76.0)
							.list();
		for (Account account : list) {
			System.out.println(account);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 参数绑定
	static void test15BindArgs3() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String hql = "from Account where score>?";
		@SuppressWarnings("unchecked")
		List<Account> list = session.createQuery(hql)
							.setDouble(0, 76.0)
							.list();
		for (Account account : list) {
			System.out.println(account);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 分页查询
	static void test16Page() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String hql = "from Account";
		@SuppressWarnings("unchecked")
		List<Account> list = session.createQuery(hql)
							.setFirstResult(1)
							.setMaxResults(4)
							.list();
		for (Account account : list) {
			System.out.println(account);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 批量update和delete
	static void test17Update() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		String hql = "delete from Account where name like :name";
		Query query = session.createQuery(hql);
		query.setString("name", "%用%");
		System.out.println(query.executeUpdate());
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	// 命名查询
	static void test18Query() {
		Session session = HibernateUtils.getSesssion();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("queryByMinAge");
		query.setInteger("minAge", 25);
		@SuppressWarnings("unchecked")
		List<Account> list = query.list();
		for (int index = 0; index < list.size(); index ++) {
			Account account = list.get(index);
			System.out.println(account);
		}
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
}