package slw03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class StudentTest {
	public static void main(String[] args) {
		// test01();
//		test02Save();
//		test03();
		test06FindAllHQLAndSQL();
	}

	static void test01() {
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
	static void test02Save() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setName("张三");
		student.setAge(20);
		Set<String> set = new HashSet<String>();
		set.add("吃");
		set.add("玩");
		set.add("睡");
		student.setHobby(set);
		session.save(student);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	static void test03() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student)session.get(Student.class, 1);
		System.out.println(student.getAge()+".."+student.getName()+".."+student.getHobby());
		Set<String> set = student.getHobby();
		for (String string : set) {
			System.out.println("爱好："+string);
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	public static void test06FindAllHQLAndSQL() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "from  slw03.Student";
			Query query = session.createQuery(hql);
			
			// 使用SQL来进行查询
//			String sql = "select * from stu_tab";
//			Query query2 = session.createSQLQuery(sql);
			
			@SuppressWarnings("unchecked")
			List<Object> list = query.list();
			for (Object object : list) {
				Student student = (Student)object;
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
