package com.datatech.core.module.manage.security.transaction;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class DataTechCoreTransaction {

	private  Session session = null;

	@Autowired
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
	
}
