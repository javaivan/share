package com.share.utils;

import com.share.service.impl.CategoryServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
	* Hibernate Utility class
	*/
	public class HibernateUtil {

		private static final Logger logger = Logger.getLogger(HibernateUtil.class);

		// SessionFactory of Hibernate
		private static final SessionFactory sessionFactory;
		static {
			try {
				// create new SessionFactory from hibernate.cfg.xml
				sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
			}
			catch (Throwable ex) {
				// If something goes wrong, it will throw an exception
				logger.error("HibernateUtil: Initial SessionFactory creation failed. " + ex);

				throw new ExceptionInInitializerError(ex);
			}
		}

	/**
	 * Get the SessionFacotry of Hibernate
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}