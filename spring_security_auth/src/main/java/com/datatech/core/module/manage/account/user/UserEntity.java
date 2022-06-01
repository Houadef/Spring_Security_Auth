package com.datatech.core.module.manage.account.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="manage_account_user")
public class UserEntity {

	private int id ;
	
	private String user_id;
	
	private String user_first_name ;
	
	private String user_last_name ;
	
	private String user_password ;
	
	private String user_phone ;
	
	private String user_photo_url ;
	
	private String user_email ;

	public int getId() {
		return id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_photo_url() {
		return user_photo_url;
	}

	public void setUser_photo_url(String user_photo_url) {
		this.user_photo_url = user_photo_url;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	
}
