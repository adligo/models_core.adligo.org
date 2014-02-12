package org.adligo.models.core.shared;

import org.adligo.i.adi.shared.I18nConstantsFactory;


public class ModelsCoreRegistry {

	public static void setup() {
		//setup english constants for servers unless overridden
		I18nConstantsFactory.INSTANCE.put(I_ModelsCoreConstants.class, 
				new ModelsCoreEnglishConstants());
		
	}
}
