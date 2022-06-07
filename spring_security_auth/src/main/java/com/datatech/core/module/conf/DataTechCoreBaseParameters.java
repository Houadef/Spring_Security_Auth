package com.datatech.core.module.conf;

import java.util.Locale;

public interface DataTechCoreBaseParameters {
	
	// Exception message set up For I18n Messaging
	final String URL_SEPARATOR = "/";
		
	// Exception message set up For I18n Messaging
	final String MESSAGES_KEY = "messages";
	
	// Application default Local
	final Locale DEFAULT_LOCAL = new Locale("en", "EN");
	
	final String APPLICATION_CONFIG_FILE = "application.properties";
	enum dataBaseType{postgresql,mysql,sqlserver,oracle,sqlite};
	
	// Application Default Ecnoding
	final String DEFAULT_ENCODING = "UTF-8";
	
	 // This field is used to Thymeleaf template Folder
	final String DEFAULT_TEMPLATE_RESOLVER = "/WEB-INF/pages/";
	
	// Field used to set source message folder dedicated for Web vue I18n User Message
	final String MESSAGE_SOURCE = "language/lang";

	Locale default_local = Locale.getDefault();

	
}
