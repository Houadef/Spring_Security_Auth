package com.datatech.core.module.conf.I18n;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.datatech.core.appcore.DataTechCoreBaseParameters;

public class DataTechCoreI18nConf implements DataTechCoreBaseParameters{

	
	private MessageSource messageSource ;
	private LocaleResolver localeResolver;
	
	/*
     * I18n language file registration
     */

    public MessageSource getMessageSource() {
    	ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames(MESSAGE_SOURCE);
        resourceBundleMessageSource.setDefaultEncoding(DEFAULT_ENCODING);
        this.messageSource = resourceBundleMessageSource;
        return this.messageSource;
    }
    
    /**
     * LocaleResovler bean that helps to identify which locale is being used
     * We use this CookieLocaleResolver in case the application has to be stateless
     */

    public LocaleResolver getLocaleResolver() {
        this.localeResolver = new CookieLocaleResolver();
        return this.localeResolver;
    }
    
    /**
     * Register a LocaleChangeInterceptor to allow specifying the desired locale on every request
     */
    public LocaleChangeInterceptor getInterceptorRegistery() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }
    
    /**
     * <h3> Resolving local for I18n </h3>
     * SessionLocaleResolver resolves <b> locales </b> by inspecting a predefined attribute in a user’s session. 
     * If the session attribute doesn’t exist, 
     * this locale resolver determines the default locale from the accept-language HTTP header.
     */
    public SessionLocaleResolver getLocalResolver() {
    	SessionLocaleResolver localResolver = new SessionLocaleResolver();
    	localResolver.setDefaultLocale(DEFAULT_LOCAL);
    	return localResolver ;
    }
    
    
    
}
