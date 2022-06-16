package com.datatech.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datatech.core.appcore.DataTechCodeBase;
import com.datatech.core.module.conf.datasource.DataTechPersistanceUtil;
import com.datatech.core.module.manage.account.user.UserEntity;

@Configuration
public class DataTechEntityClassList extends DataTechCodeBase{
 		
	@Bean(name="EntityMappingDefiner")
	public boolean loadEntityMappingconfig() {		
		DataTechPersistanceUtil.buildConfiguration();
		DataTechPersistanceUtil.addAnnotatedClass(UserEntity.class);
		return true;
	}
	
	
}
