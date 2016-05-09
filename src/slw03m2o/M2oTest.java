package slw03m2o;

import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class M2oTest {
	public static void main(String[] arg) {
//		test01Init();
//		test02Add();
		test03Query();
	}
	static void test03Query() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = (Employee)session.get(Employee.class, 3);
		// 起到立马加载的作用
		Hibernate.initialize(employee.getDept());
//		System.out.println(employee.getDept().getDeptName() + employee.getEmpName());
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	static void test02Add() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		// 在单向多对一中，要先添加少的一端
		Dept dept = new Dept();
		dept.setDeptName("综合");
		
		Employee employee = new Employee();
		employee.setDept(dept);
		employee.setHireDate(new Date());
		employee.setEmpName("emp1");
		session.save(dept);
		session.save(employee);
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
