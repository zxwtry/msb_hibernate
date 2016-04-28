package stage02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TeacherTest {
	@Test
	public void teacherTest01() {
		
		Teacher teacher01 = new Teacher();
		teacher01.setId(1);
		teacher01.setName("teacher01Name");
		teacher01.setTitle("teacher01Title");
		
		Configuration configuration = new Configuration();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction();
		session.save(teacher01);
		session.getTransaction().commit();
		session.clear();
		sessionFactory.close();
		
	}
}
