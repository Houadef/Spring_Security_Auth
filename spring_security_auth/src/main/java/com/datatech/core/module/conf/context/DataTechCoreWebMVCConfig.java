package com.datatech.core.module.conf.context;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.datatech.core.appcore.DataTechCoreBaseParameters;
import com.datatech.core.appcore.DataTechCoreObjectName;
import com.datatech.core.module.conf.I18n.DataTechCoreI18nConf;

@EnableWebMvc
@Configuration	
@ComponentScan(basePackages = "com.datatech.core.controller")
public class DataTechCoreWebMVCConfig implements WebMvcConfigurer, DataTechCoreBaseParameters, DataTechCoreObjectName{
	
	
	DataTechCoreI18nConf dataTechCoreI18nConf = new DataTechCoreI18nConf();
	
	/**
	 * <h3> Project Vue Architecture </h3> 
	 * Application resources location config
	 * <b>Resources </b> is the root folder containing all the resources
	 * <b> Lib contain </b> all java script and other vendor JS component
	 * <b> Styles </b> contain all customized sheet file css and owners
	 * <b> vendors </b> contains vendors Style Sheet
	 * <b> Images contain </b> All project Images
	 * <b> Component </b> containt JS customized comopnent and owner
	 */
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
        registry.addResourceHandler("/lib/**").addResourceLocations("/resources/lib/");
        registry.addResourceHandler("/style/**").addResourceLocations("/resources/assets/styles/");
        registry.addResourceHandler("/vednors/**").addResourceLocations("/resources/assets/vendors/");
        registry.addResourceHandler("/component/**").addResourceLocations("/resources/components/");
        registry.addResourceHandler("/image/**").addResourceLocations("/resources/assets/images/");
    }
	
	/**
	 * 	This bean defines a template resolver.
	 *  <p> A template resolver resolves templates into TemplateResolution objects that contain additional 
	 *  information such as template mode, caching, prefix and suffix of templates. </p>
	 *  <p> <b> ClassLoaderTemplateResolver </b> is used for loading templates located on the classpath. </p>
	 */
	@Bean
    @Description("Thymeleaf template resolver serving HTML 5")
    public SpringResourceTemplateResolver templateResolver() {
        var templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix(DEFAULT_TEMPLATE_RESOLVER);
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
	
	@Bean
    @Description("Thymeleaf template engine with Spring integration")
    public SpringTemplateEngine templateEngine() {
        var templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

	@Bean
    @Description("Thymeleaf view resolver")
    public ViewResolver viewResolver() {
        var viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding(DEFAULT_ENCODING);
        return viewResolver;
    }
	
    /**
     * <h3> Resolving local for I18n </h3>
     * SessionLocaleResolver resolves <b> locales </b> by inspecting a predefined attribute in a user’s session. 
     * If the session attribute doesn’t exist, 
     * this locale resolver determines the default locale from the accept-language HTTP header.
     */
    @Bean("localResolver")
    public SessionLocaleResolver localResolver() {
//    	SessionLocaleResolver localResolver = new SessionLocaleResolver();
//    	localResolver.setDefaultLocale(new Locale("en", "EN"));
//    	return localResolver ;
    	return this.dataTechCoreI18nConf.getLocalResolver();
    }
        
    /*
     * I18n language file registration
     */
    @Bean("messageSource")
    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasenames(MESSAGE_SOURCE);
//        messageSource.setDefaultEncoding(DEFAULT_ENCODING);
//        return messageSource;
    	return this.dataTechCoreI18nConf.getMessageSource();
    }
    
    /**
     * LocaleResovler bean that helps to identify which locale is being used
     * We use this CookieLocaleResolver in case the application has to be stateless
     */
    @Bean
    public LocaleResolver localeResolver() {
//        return new CookieLocaleResolver();
    	return this.dataTechCoreI18nConf.getLocaleResolver();
    }
    
    /**
     * Register a LocaleChangeInterceptor to allow specifying the desired locale on every request
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.dataTechCoreI18nConf.getInterceptorRegistery());
    }
    
}
