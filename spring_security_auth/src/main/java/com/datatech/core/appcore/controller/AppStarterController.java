package com.datatech.core.appcore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datatech.core.module.manage.account.user.UserTransaction;



/**
 * 
 * @author a.houadef
 * @version 0.0.1
 * 
 * Program Luncher controller
 * 
 * <p>
 * This is the main controller for lunching the program on Login form
 * 
 */
@Controller
public class AppStarterController {


	
	//** Startup Controller for lunching Login form */
	@RequestMapping(value="/")
	public String getHomePage() {
		
		UserTransaction userTranac = new UserTransaction();
		
		userTranac.createUser();
		return "redirect:/manage/account/login";
		//return "home";
	}
	
	//** Login form controller. */
	@RequestMapping("/manage/account/login")
	public String getLoginPage() {
		
		return "modules/manage/account/manage.account.login.form";
	}
	

}
