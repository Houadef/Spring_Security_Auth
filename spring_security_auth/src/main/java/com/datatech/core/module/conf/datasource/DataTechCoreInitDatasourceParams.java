package com.datatech.core.module.conf.datasource;

import com.datatech.core.appcore.DataTechCoreUtils;
import com.datatech.core.appcore.DataTechKernelObject;

/**
 * @author a.houadef
 * @version 1.0
 * Is used to set static parameters for the app and also to check datasource parameters 
 * @param DBType
 * @return
 */
public class DataTechCoreInitDatasourceParams implements DataTechKernelObject {
	
	private static String dbLocation ;
	private static String dbPortNumber ;
	private static String dbName ;
	private static String dbURL;
	private static  String dbDriverClassName ;
	private static String dbType ;
	private static boolean isSSLUsage ;
	private static boolean isLoadedParams;
	private static String dialect;
		
	
	public static boolean checkDbType(String dbTypeParam) {
		String dbTypeToLlwerCase = dbTypeParam.toLowerCase();
		for (dataBaseType c : dataBaseType.values()) {
			if (c.name().contentEquals(dbTypeParam)) {
				dbTypeParam=dbTypeToLlwerCase;
				setDbType(dbTypeParam);
				switch (c) {
					case postgresql 	: 	{
												setDbDriverClassName("org.postgresql.Driver");
												setDialect("org.hibernate.dialect.PostgreSQLDialect");
											}
					case sqlserver 		: 	{
												setDbDriverClassName("com.microsoft.sqlserver.jdbc.SQLServer");
												setDialect("org.hibernate.dialect.SQLServerDialect");
											}
					case mysql 			:	{
												setDbDriverClassName("com.mysql.jdbc.Driver");
												setDialect("org.hibernate.dialect.MySQLDialect");
											}
					case oracle 		:	{
												setDbDriverClassName("oracle.jdbc.driver.OracleDriver");
												setDialect("org.hibernate.dialect.OracleDialect");
											}
				default:
					dbDriverClassName = "org.postgresql.Driver";
				}
				return true ;
			} 
		}		
		
		return false;
	}
	
	
	/**
	 * This class is used to return a valid Driver String to connecting to the database 
	 * using parameters
	 * @param dbLocationParam
	 * @param dbNameParam
	 * @param isSSLActive
	 * @return
	 */
	public static String setDbURL(String dbLocationParam, String dbNameParam, boolean isSSLActive) {
		if (DataTechCoreUtils.isEmptyOrNullOrBlanc(dbLocation)) {
			return null;
		}else {
			if (DataTechCoreUtils.isEmptyOrNullOrBlanc(dbName))	
				return null;
		}
		dbName = dbNameParam;
		dbLocation = dbLocationParam;
		dbURL=dbURL+dbType+"//"+dbLocation+":"+dbPortNumber+"/"+dbName+"?ssl="+isSSLActive;		
		return dbURL;
	}



	public static String getDbLocation() {
		return dbLocation;
	}



	public static String getDbPortNumber() {
		return dbPortNumber;
	}



	public static String getDbName() {
		return dbName;
	}



	public static String getDbURL() {
		return dbURL;
	}



	public static String getDbDriverClassName() {
		return dbDriverClassName;
	}



	public static String getDbType() {
		return dbType;
	}



	public static void setDbLocation(String dbLocation) {
		DataTechCoreInitDatasourceParams.dbLocation = dbLocation;
	}



	public static void setDbPortNumber(String dbPortNumber) {
		DataTechCoreInitDatasourceParams.dbPortNumber = dbPortNumber;
	}



	public static void setDbName(String dbName) {
		DataTechCoreInitDatasourceParams.dbName = dbName;
	}



	public static void setDbType(String dbType) {
		DataTechCoreInitDatasourceParams.dbType = dbType;
	}

	/**
	 * This class is used to initiate URL using class attribute
	 * This class must be used after initiating class attribute parameters
	 * @param isSSLUsage
	 */
	public static void initDbURL() {
		dbURL="jdbc:"+dbType+"://"+dbLocation+":"+dbPortNumber+dbName+"?ssl="+isSSLUsage;		
		
	}


	public static boolean isSSLUsage() {
		return isSSLUsage;
	}


	public static void setSSLUsage(boolean isSSLUsage) {
		DataTechCoreInitDatasourceParams.isSSLUsage = isSSLUsage;
	}


	public static boolean isLoadedParams() {
		return isLoadedParams;
	}


	public static void setLoadedParams(boolean isLoadedParams) {
		DataTechCoreInitDatasourceParams.isLoadedParams = isLoadedParams;
	}


	public static String getDialect() {
		return dialect;
	}


	public static void setDialect(String dialect) {
		DataTechCoreInitDatasourceParams.dialect = dialect;
	}


	public static void setDbURL(String dbURL) {
		DataTechCoreInitDatasourceParams.dbURL = dbURL;
	}


	public static void setDbDriverClassName(String dbDriverClassName) {
		DataTechCoreInitDatasourceParams.dbDriverClassName = dbDriverClassName;
	}
	
	
		
}
