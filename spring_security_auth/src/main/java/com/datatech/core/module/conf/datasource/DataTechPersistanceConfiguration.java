package com.datatech.core.module.conf.datasource;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.stereotype.Component;

import com.datatech.core.appcore.DataTechCoreBaseParameters;

/**
 * 
 * @author a.houadef
 * @version 1.0
 * @since 20 May 2022
 * 
 */

@Component
public class DataTechPersistanceConfiguration implements DataTechCoreBaseParameters{
   
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    @SuppressWarnings("static-access")
	public static SessionFactory getSessionFactory(Object obj) {
        if (sessionFactory == null) {
           try {
              StandardServiceRegistryBuilder registryBuilder = 
                    new StandardServiceRegistryBuilder();

              Map<String, Object> settings = new HashMap<>();
              settings.put(Environment.DRIVER, DataTechCoreInitDatasourceParams.getDbDriverClassName());
              settings.put(Environment.URL, DataTechCoreInitDatasourceParams.getDbURL());
              settings.put(Environment.USER, DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.dbusername") );
			  settings.put(Environment.PASS, DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.dbpassword"));             
              settings.put(Environment.HBM2DDL_AUTO, "update");
              settings.put(Environment.SHOW_SQL, true);
              settings.put(Environment.DIALECT, DataTechCoreInitDatasourceParams.getDialect());
              settings.put(Environment.SHOW_SQL, DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.orm.show_sql"));
              
              // HikariCP settings
              
              // Maximum waiting time for a connection from the pool
              settings.put("hibernate.hikari.connectiontimeout", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.connectiontimeout"));
              // Minimum number of ideal connections in the pool
              settings.put("hibernate.hikari.minimumIdle", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.minimumIdle"));
              // Maximum number of actual connection in the pool
              settings.put("hibernate.hikari.maximumPoolSize", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.maxPoolSize"));
              // Maximum time that a connection is allowed to sit ideal in the pool
              settings.put("hibernate.hikari.idleTimeout", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.idleTimeout"));
              //Max Life Time
              settings.put("hibernate.hikari.maxLifetime", DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.maxLifetime"));
              //Min Idle Time
              settings.put("hibernate.hikari.minIdle",DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.minIdle"));
              //PoolName
              settings.put("hibernate.hikari.poolname",DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.poolname"));
              // Connection TestQuerry
              settings.put("hibernate.hikari.connectionTestQuery",DataTechCoreLoadDataSourceProperties.getInstance().getProperties().getProperty("app.datasource.connectionTestQuery"));
              
              
              
              registryBuilder.applySettings(settings);

              registry = registryBuilder.build();
              
//              Metadata metadata = sources.getMetadataBuilder().build();
//              sessionFactory = metadata.getSessionFactoryBuilder().build();
           } catch (Exception e) {
              if (registry != null) {
                 StandardServiceRegistryBuilder.destroy(registry);
              }
              e.printStackTrace();
           }
        }
        return sessionFactory;
     }

 
}
