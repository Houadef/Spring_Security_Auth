package com.datatech.core.module.conf.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import com.datatech.core.appcore.DataTechCoreBaseParameters;


public class DataTechCoreLoadDataSourceProperties implements DataTechCoreBaseParameters{

	private static Properties properties = null ;
	private static DataTechCoreLoadDataSourceProperties instance ;
	
		
	private DataTechCoreLoadDataSourceProperties() {
		
		properties = getConfigProperties();
	}		

	
	public static DataTechCoreLoadDataSourceProperties getInstance() {
		if (instance == null) {
				instance = new DataTechCoreLoadDataSourceProperties();
			}
		return instance;
	}

	/**
	 * This methode is used to Load the properties file that contains Hikari and Hibernate Configuration
	 * Also the properties File contain DataSorce Location and Database ClassName
	 * 
	 * It return a properties File
	 * @return 
	 * @throws IOException 
	 */
	
	private Properties getConfigProperties() {	
			ClassLoader classLoader = getClass().getClassLoader();
			URL resource = classLoader.getResource(APPLICATION_CONFIG_FILE);
			if (resource == null) {
	           // throw new IllegalArgumentException("ERROR :  file not found! ---- File name :  datasource.properties");
	        }	
			InputStream inputStream;
			try {
				inputStream = resource.openStream();
				Properties props = new Properties();
	            props.load(inputStream);
	            if (isValidDataSourceConfig(props)) {
	            	 properties = props ;
	            	 properties.setProperty("app.datasource.driverClass", DataTechCoreInitDatasourceParams.getDbDriverClassName());
	            	return  props;
	            }
			} catch (IOException e) {
				
				e.printStackTrace();
			}            
			return  null;		
	}
	
	private boolean isValidDataSourceConfig(Properties prop) {
		if (DataTechCoreInitDatasourceParams.checkDbType(prop.getProperty("app.datasource.type"))) {
        	DataTechCoreInitDatasourceParams.setDbLocation(prop.getProperty("app.datasource.location"));
        	DataTechCoreInitDatasourceParams.setDbPortNumber(prop.getProperty("app.datasource.port"));
        	DataTechCoreInitDatasourceParams.setDbName(prop.getProperty("app.datasource.dbname"));
        	DataTechCoreInitDatasourceParams.setSSLUsage(Boolean.parseBoolean(prop.getProperty("app.datasource.useSSL")));
        	DataTechCoreInitDatasourceParams.initDbURL();
        	DataTechCoreInitDatasourceParams.setLoadedParams(true);
        	return true;
        }
		DataTechCoreInitDatasourceParams.setLoadedParams(false);
		return false;
	}


	public Properties getProperties() {
		return properties;
	}


	public static void setProperties(Properties properties) {
		DataTechCoreLoadDataSourceProperties.properties = properties;
	}
	
	

	
}
