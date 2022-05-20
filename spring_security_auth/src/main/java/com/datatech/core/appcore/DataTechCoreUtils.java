package com.datatech.core.appcore;

public class DataTechCoreUtils implements EliTechCoreObject {

	public static boolean isEmptyOrNullOrBlanc(String param) {
		if (param.isEmpty()) 
			return true;
				else
					if (param.isBlank())
						return true;
					else		
		return false;
	}
	
}
