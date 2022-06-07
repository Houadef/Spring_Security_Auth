package com.datatech.core.appcore.session;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.datatech.core.module.conf.datasource.DataTechPersistanceUtil;

public class DataTechDAOTransactionManager {

	
	private SessionFactory sessionFactory = DataTechPersistanceUtil.buildSessionFactory();
	
	private Session session;
	
	public boolean save(Object obj) {
		try {
			System.out.println("Open Session");
			session = this.sessionFactory.openSession();
			System.out.println("Begin Transaction");
			this.session.beginTransaction();
			System.out.println("Persist Object Save");
			this.session.persist(obj);
			System.out.println("Commit Object");
			session.getTransaction().commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			if ( session != null)
				session.close();
		}
		return true;
	}
}
