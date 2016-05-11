package slw032o2m_self;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class O2mSelfTest {
	public static void main(String[] args) {
//		test01Init();
//		test02Add();
		test03Query();
	}
	static void test03Query() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Category category = (Category) session.get(Category.class, 1);
		System.out.println(category.getName());
		for (Category thisCategory : category.getSons()) {
			System.out.println(thisCategory.getName());
		}
		
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
		
		// 添加一级分类
		Category category1 = new Category();
		category1.setName("name1");
		session.save(category1);
		
		// 添加二级分类
		Category category2 = new Category();
		category2.setName("name2");
		category2.setParent(category1);
		session.save(category2);
		Category category3 = new Category();
		category3.setName("name3");
		category3.setParent(category1);
		session.save(category3);
		Category category5 = new Category();
		category5.setName("name5");
		category5.setParent(category1);
		session.save(category5);
		
		// 添加了 inverse="true" 之后，能够先添加少的，后添加多的
		//　这样在执行的过程中，能够减少部分语句
		
		
		
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
