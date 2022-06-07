package com.datatech.core.appcore;

import org.hibernate.boot.registry.StandardServiceRegistry;

import com.datatech.core.module.conf.DataTechCoreBaseParameters;

public interface DataTechKernelObject extends DataTechCoreBaseParameters{

	public static StandardServiceRegistry registry = null; 
	
}
