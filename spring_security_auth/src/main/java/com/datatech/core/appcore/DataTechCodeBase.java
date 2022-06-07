package com.datatech.core.appcore;

public class DataTechCodeBase implements DataTechKernelObject {

	
	public int getHttpStatusCode(Object httpStatus) {
		if (httpStatus != null) {
	        Integer statusCode = Integer.valueOf(httpStatus.toString());
	        return statusCode;
		}
		else {		
			return 0;
		}
	}
	
	
}
