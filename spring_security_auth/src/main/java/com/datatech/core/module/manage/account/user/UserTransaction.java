package com.datatech.core.module.manage.account.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.datatech.core.appcore.session.DataTechDAOTransactionManager;

public class UserTransaction   extends DataTechDAOTransactionManager{
	
	private UserEntity userInfo ;
	
	public boolean createUser() {
		System.out.println("Create new User Object");
		
		userInfo = new UserEntity();
		userInfo.setUser_email("test_email@test.com");
		userInfo.setUser_first_name("first Name test user 01");
		userInfo.setUser_last_name("Last Name User 01");
		userInfo.setUser_password("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		userInfo.setUser_phone("0123132123132131");
		userInfo.setUser_id("USR_0000112");
		userInfo.setUser_photo_url("url://0213133331313");
		
		System.out.println("Save object To DataBase");
		
		this.save(userInfo);
		
		return true;
	}
	
	@Autowired
	public void testTransaction() {
		System.out.println("Check Session");
		
	}

	public UserEntity getUser() {
		return userInfo;
	}

	public void setUser(UserEntity user) {
		this.userInfo = user;
	}
	
	

}







