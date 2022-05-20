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

	private AnnotationConfigWebApplicationContext dispatcherServletContext ;
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		Locale.setDefault(Locale.US);
		
		System.out.println("<----------- Initializing Web APP config -------->");
		
		// Create the 'root' Spring application context
		this.dispatcherServletContext = new AnnotationConfigWebApplicationContext();
		
		this.dispatcherServletContext.register(DataTechCoreWebMVCConfig.class);
		
		this.dispatcherServletContext.setServletContext(servletContext);
		this.dispatcherServletContext.refresh();
		
		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(this.dispatcherServletContext));       
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(this.dispatcherServletContext);
		
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
	}

	
	public AnnotationConfigWebApplicationContext getDispatcherServletContext() {
		return dispatcherServletContext;
	}
	

}
