package com.datatech.core.appcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

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

public class AppStarterController {

	
	//** Startup Controller for lunching Login form */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getHomePage() {
				
		//System.out.println("##########################################  "+dsconf.getDatasource().getConnectionTimeout());
		
		return "redirect:/manage/account/login";
		//return "home";
	}
	
	//** Login form controller. */
	@RequestMapping("/manage/account/login")
	public String getLoginPage() {
		return "modules/manage/account/manage.account.login.form";
	}
	

}
