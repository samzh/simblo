package net.simblo.base.util;

import net.simblo.core.user.vo.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateTool {

	private static Log log = LogFactory.getLog(HibernateTool.class);

	private static final SessionFactory sessionFactory;

	static {
		log.info("Initializing Hibernate SesstionFactory.");
		try {
			sessionFactory = new AnnotationConfiguration()
			.addAnnotatedClass(User.class)
//			.addAnnotatedClass(BaseUser.class)
			.buildSessionFactory();
			log.info("SessionFactory Initialization Succeed");
		} catch (Throwable ex) {
			log.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@SuppressWarnings("rawtypes")
	public static final ThreadLocal session = new ThreadLocal();

	/**
	 * 获取Hibernate Session
	 * 
	 * @return session Hibernate 当前线程
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static Session getSession() throws HibernateException {
		Session s = (Session) session.get();
		// Open a new Session, if this Thread has none yet
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	/**
	 * 关闭Hibernate Session
	 * 
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null)
			s.close();
	}

}