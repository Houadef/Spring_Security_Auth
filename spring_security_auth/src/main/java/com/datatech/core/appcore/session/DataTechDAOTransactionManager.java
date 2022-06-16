package com.datatech.core.appcore.session;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Environment;

import com.datatech.core.appcore.DataTechCodeBase;
import com.datatech.core.module.conf.datasource.DataTechPersistanceUtil;

public class DataTechDAOTransactionManager extends DataTechCodeBase {
		
	private Session session;
	
	public boolean save(Object obj) {
		try {
			System.out.println(DataTechPersistanceUtil.buildConfiguration().getProperties().getProperty(Environment.URL));
			log.trace("Opening session");			
			session = DataTechPersistanceUtil.getSessionFactory().openSession();
			log.trace("Begin Transaction");
			this.session.beginTransaction();
			log.trace("Persist Object Save : "+obj.getClass().toString());
			this.session.persist(obj);
			log.info("Starting Commiting Object"+obj.getClass().toString() );
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

	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}
	
	
	
}
