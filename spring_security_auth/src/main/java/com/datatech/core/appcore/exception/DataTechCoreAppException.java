package com.datatech.core.appcore.exception;

import com.datatech.core.module.conf.DataTechCoreBaseParameters;

/**
 * The DataSourceBadParameterException wraps all checked standard Java exception and enriches them with 
 * a custom error code.
 * You can use this code to verify if database parametres on datasource properties file are correct.
 * 
 * @author TJanssen
 */

public class DataTechCoreAppException extends Exception implements DataTechCoreBaseParameters{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 93486403569511925L;

	public DataTechCoreAppException(String errormessage) {
		super(errormessage);
	}

}
