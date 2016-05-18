package slw042o2o_o2o_o2o;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class o2oTest {
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
		
		Citizen c1 = (Citizen)session.get(Citizen.class, 2);
		System.out.println(c1.getIdCard().getName());
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	static void test01Init() {
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
		
		Citizen c1 = new Citizen();
		c1.setName("name1");
		
		IDCard idCard = new IDCard();
		idCard.setName("card1");
		idCard.setCitizen(c1);
		
		c1.setIdCard(idCard);
		
		session.save(c1);
		session.save(idCard);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
