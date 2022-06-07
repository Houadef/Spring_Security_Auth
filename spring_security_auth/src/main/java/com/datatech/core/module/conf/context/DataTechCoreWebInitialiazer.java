package com.datatech.core.module.conf.context;

import java.util.Locale;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


@Configuration
public class DataTechCoreWebInitialiazer implements WebApplicationInitializer {

	private static AnnotationConfigWebApplicationContext  dispatcherServletContext ;
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		Locale.setDefault(Locale.US);
		
		System.out.println("<----------- START Initializing Web APP config -------->");
		
		// Create the 'root' Spring application context
		dispatcherServletContext = new AnnotationConfigWebApplicationContext();
		
		dispatcherServletContext.register(DataTechCoreWebMVCConfig.class);
		
		dispatcherServletContext.setServletContext(servletContext);
		dispatcherServletContext.refresh();
		
		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(dispatcherServletContext));       
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletContext);
		
		//Create Dispatcher Servlet with servlet context Object
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");		
		dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", "true");		
		
		 // UTF8 Charactor Filter.
        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);

        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
                
    	System.out.println("<----------- END Initializing Web APP config -------->");
	}

	
	public AnnotationConfigWebApplicationContext getDispatcherServletContext() {
		System.out.println("<----------- Get Context -------->");
		return dispatcherServletContext;
	}
	

}
