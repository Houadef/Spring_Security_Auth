package com.datatech.core.module.manage.account.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.datatech.core.appcore.session.DataTechDAOTransactionManager;

public class UserTransaction   extends DataTechDAOTransactionManager{
	
	private UserEntity userEntity ;
		
	public boolean createUser() {
		
		userEntity = new UserEntity();
		log.info("User Entity created"+ userEntity.toString());
		userEntity.setUser_email("test_email@test.com");
		userEntity.setUser_first_name("first Name test user 01");
		userEntity.setUser_last_name("Last Name User 01");
		userEntity.setUser_username("USERNAME_TEST");
		userEntity.setUser_password("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		userEntity.setUser_phone("0123132123132131");
		userEntity.setUser_id("USR_0000112");
		userEntity.setUser_photo_url("url://0213133331313");		
		log.info("Starting to Save object To DataBase : " + userEntity.toString());		
		this.save(userEntity);		
		return true;
	}
	
	@Autowired
	public void testTransaction() {
		System.out.println("Check Session");
		
	}

	public UserEntity getUser() {
		return userEntity;
	}

	public void setUser(UserEntity user) {
		this.userEntity = user;
	}
	
	

}







