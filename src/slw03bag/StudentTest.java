package slw03bag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class StudentTest {
	public static void main(String[] args) {
		// test01Init();
		// test02Save();
//		test03Update();
//		test04Delete();
//		test05LazyUsingGet();
//		test05LazyUsingLoad();
		test06FindAllHQLAndSQL();
	}
	public static void test01Init() {
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	public static void test02Save() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setName("bag02");
		Collection<String> hobby = new ArrayList<String>();
		hobby.add("写字");
		hobby.add("写字");
		hobby.add("吃饭");
		student.setHobby(hobby);
		session.save(student);
		transaction.commit();
		session.clear();
		sessionFactory.close();
	}
	public static void test03Update() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student)session.get(Student.class, 2);
		Collection<String> hobby = student.getHobby();
		hobby.add("新的爱好");
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	public static void test04Delete() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Student student = (Student)session.get(Student.class, 3);
			session.delete(student);
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	public static void test05LazyUsingGet() {
		//　使用session.get方法不会lazy
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Student student = (Student)session.get(Student.class, 2);
			System.out.println(student.getId());
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	public static void test05LazyUsingLoad() {
		//　使用session.load方法会lazy
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Student student = (Student)session.load(Student.class, 2);
			System.out.println(student.getId());
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	public static void test06FindAllHQLAndSQL() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "from slw03bag.Student";
			Query query = session.createQuery(hql);
			
			// 使用SQL来进行查询
//			String sql = "select * from stubag_tab";
//			Query query2 = session.createSQLQuery(sql);
			
			@SuppressWarnings("unchecked")
			List<Student> list = (List<Student>) query.list();
			for (Student student : list) {
				System.out.println(student.getId() +"..."+student.getName());
				System.out.print("hobbies : ");
				for (String string : student.getHobby()) {
					System.out.print(string+" ");
				}
				System.out.println();
			}
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
}