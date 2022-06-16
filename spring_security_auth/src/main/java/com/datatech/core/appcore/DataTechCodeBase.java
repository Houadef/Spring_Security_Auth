package com.datatech.core.appcore;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.datatech.core.logging.DataTechLogManager;

public class DataTechCodeBase extends DataTechLogManager implements DataTechKernelObject {
	
	public Logger log = LogManager.getLogger();
	
	public int getHttpStatusCode(Object httpStatus) {
		
		if (httpStatus != null) {
	        Integer statusCode = Integer.valueOf(httpStatus.toString());
	        log.info(statusCode.toString());
	        return statusCode;
		}
		else {		
			return 0;
		}
	}
	
	
	
}
