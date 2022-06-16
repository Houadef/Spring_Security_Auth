package com.datatech.core.module.conf.datasource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;

import com.datatech.core.appcore.DataTechCodeBase;
import com.datatech.core.module.conf.DataTechCoreBaseParameters;

/**
 * 
 * @author a.houadef
 * @version 1.0
 * @since 20 May 2022
 * 
 */
@org.springframework.context.annotation.Configuration
public class DataTechPersistanceUtil extends DataTechCodeBase implements DataTechCoreBaseParameters{
   
    private static ServiceRegistry serviceRegistry = null;
    private static SessionFactory sessionFactory = null;
    private static Configuration configuration = null;
    private static Properties settings = new Properties();

    @Bean(name = "getPersistanceConfig")
	public static synchronized Configuration buildConfiguration() {	
    	Map<String, Object> mapSettings =null ;    	
    	if (configuration == null) {
        	try { 
        		  mapSettings = new HashMap<>();
	        	  mapSettings.put(Environment.USER, DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.dbusername") );
				  mapSettings.put(Environment.PASS, DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.dbpassword"));           
	              mapSettings.put(Environment.DRIVER, DataTechCoreInitDatasourceParams.getDbDriverClassName());
	              mapSettings.put(Environment.URL, DataTechCoreInitDatasourceParams.getDbURL());
	              mapSettings.put(Environment.HBM2DDL_AUTO, "update");
	              mapSettings.put(Environment.DIALECT, DataTechCoreInitDatasourceParams.getDialect());
	              mapSettings.put(Environment.SHOW_SQL, DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.orm.show_sql"));
	              mapSettings.put(Environment.FORMAT_SQL, DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.orm.format_sql"));
	              mapSettings.put("hibernate.jdbc.lob.non_contextual_creation", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("hibernate.jdbc.lob.non_contextual_creation"));
	              
	              // HikariCP settings
	              
	              // Maximum waiting time for a connection from the pool
	              //settings.put("hibernate.hikari.connectiontimeout", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.connectiontimeout"));
	              // Minimum number of ideal connections in the pool
	              mapSettings.put("hibernate.hikari.minimumIdle", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.minimumIdle"));
	              // Maximum number of actual connection in the pool
	              mapSettings.put("hibernate.hikari.maximumPoolSize", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.maxPoolSize"));
	              // Maximum time that a connection is allowed to sit ideal in the pool
	              mapSettings.put("hibernate.hikari.idleTimeout", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.idleTimeout"));
	              //Max Life Time
	              mapSettings.put("hibernate.hikari.maxLifetime", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.maxLifetime"));
	              //Min Idle Time
	              //settings.put("hibernate.hikari.minIdle",DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.minIdle"));
	              //PoolName
	              //settings.put("hibernate.hikari.poolname",DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.poolname"));
	              // Connection TestQuerry
	              mapSettings.put("hibernate.hikari.connectionTestQuery",DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.connectionTestQuery"));
	              settings.putAll(mapSettings);
	             
	              configuration = new Configuration();
	              configuration.setProperties(settings);           
	              
	              return configuration;
	              
        	} catch (Exception e) {
        		if (registry != null) {
        			StandardServiceRegistryBuilder.destroy(registry);
        		}
              e.printStackTrace();
              return null;
           }
        }
        return configuration;
     }
	
    /**
     * Is used on loading Entity Mapping on Bean named loadEntityPersistanceMapping
     * Used static on class DataTechEntityClassList. Entity mapping have to be added Manually on this class
     * @param cls
     * @return
     */
    public static boolean addAnnotatedClass(Class<?> cls) {
    	if (configuration == null) {
    		return false;
    	}
    	configuration.addAnnotatedClass(cls);
   	System.out.println("After annotated class "+ cls.getName() +" "+ Environment.DIALECT +" "+ configuration.getProperty(APPLICATION_CONFIG_FILE));
    	return true;
    }   
    

	public static SessionFactory getSessionFactory() {
		if (sessionFactory==null ) {
			if (serviceRegistry == null)
					serviceRegistry = new StandardServiceRegistryBuilder().applySettings(buildConfiguration().getProperties()).build();
        
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory ;
	}
    
	
}
