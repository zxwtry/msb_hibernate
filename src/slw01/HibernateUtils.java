package slw01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	static Session getSesssion() {
		Session session = sessionFactory.openSession();
		return session;
	}
	static void closeSession(Session session) {
		if (null == session || null == sessionFactory) {
			return;
		}
		session.close();
	}
}
