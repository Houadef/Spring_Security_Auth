package com.datatech.core.module.conf.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datatech.core.module.conf.I18n.DataTechCoreI18nConf;

@Configuration
public class DataTechCoreObject {

	
	
	@Bean
	public DataTechCoreI18nConf dataTechCoreI18nConf() {
		DataTechCoreI18nConf dataTechCoreI18nConfObject = new DataTechCoreI18nConf();
		return dataTechCoreI18nConfObject;
	}
	
	
}
