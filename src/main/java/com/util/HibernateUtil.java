package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionfactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		try {
			if (sessionfactory == null) {

				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate-cfg.xml")
						.build();

				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

				sessionfactory = metadata.getSessionFactoryBuilder().build();

			}
			return sessionfactory;
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static SessionFactory getSessionFactory() {

		return sessionfactory;
	}

	public void shutdown() {
		sessionfactory.close();
	}

}
