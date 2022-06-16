package com.datatech.core.module.manage.account.user;

import com.datatech.core.DataTechCoreEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="frm_manage_account_user", schema = "public")
public class UserEntity extends DataTechCoreEntity {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="user_seq", sequenceName="seq_manage_account_user_seq", initialValue = 10, allocationSize =100)
	@NotNull
	protected Long id ;
	
	@Column(name="user_id", length=128, nullable = false, unique = true)
	private String user_id;
	
	@Column(name="user_first_name", length=128, nullable = false, unique = false )
	@NotNull
	private String user_first_name ;
	
	@Column(name="user_last_name", length=128, nullable = false, unique = false )
	@NotNull
	private String user_last_name ;
	
	@Column(name="user_username", length=128, nullable = false, unique = true )
	@NotNull
	private String user_username ;
	
	@Column(name="user_password", length=128, nullable = false, unique = false )
	private String user_password ;
	
	@Column(name="user_phone", length=128, unique = false )
	private String user_phone ;
	
	@Column(name="user_photo_url", length=128, unique = false)
	private String user_photo_url ;
	
	@Column(name="user_email", length=256, nullable = false, unique = true )
	private String user_email ;

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

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	
	
}
