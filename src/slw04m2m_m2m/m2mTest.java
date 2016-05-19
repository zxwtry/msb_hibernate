package slw04m2m_m2m;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class m2mTest {
	public static void main(String[] args) {
//		test01Init();
//		test02Add();
//		test03Query();
		
	}
	static void test04AddInverse() {
		// add inverse="true"  in　Food.hbm.xml
	}
	static void test03Query() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Custom custom = (Custom)session.get(Custom.class, 1);
		for (Food food : custom.getFoods())
			System.out.println("custom : " + food.getFoodName());
		Food  food = (Food)session.get(Food.class, 2);
		for (Custom custom2 : food.getCustoms())
			System.out.println("food : " + custom2.getCustomName());
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
		Food food0 = new Food();
		food0.setFoodName("food0Name");
		food0.setPrice(1.11f);
		Food food1 = new Food();
		food1.setFoodName("food1Name");
		food1.setPrice(2.22f);
		Food food2 = new Food();
		food2.setFoodName("food2Name");
		food2.setPrice(3.33f);
		Food food3 = new Food();
		food3.setFoodName("food3Name");
		food3.setPrice(4.44f);
		session.save(food0);
		session.save(food1);
		session.save(food2);
		session.save(food3);
		Custom custom0 = new Custom();
		Set<Food> setCustom0 = new HashSet<Food>();
		setCustom0.add(food0);
		setCustom0.add(food1);
		custom0.setFoods(setCustom0);
		custom0.setCustomName("custom0");
		Custom custom1 = new Custom();
		Set<Food> setCustom1 = new HashSet<Food>();
		setCustom1.add(food1);
		setCustom1.add(food2);
		custom1.setFoods(setCustom1);
		custom1.setCustomName("custom1");
		Custom custom2 = new Custom();
		Set<Food> setCustom2 = new HashSet<Food>();
		setCustom2.add(food2);
		setCustom2.add(food3);
		custom2.setFoods(setCustom2);
		custom2.setCustomName("custom2");
		session.save(custom0);
		session.save(custom1);
		session.save(custom2);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
