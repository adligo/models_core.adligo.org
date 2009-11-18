package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.InvokerNames;
import org.adligo.i.adi.client.Registry;

public class ModelsCoreValidationConstantsObtainer {

	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(InvokerNames.CONSTANTS_FACTORY);
	
	public static I_ModelsCoreValidationConstants getConstants() {
		I_ModelsCoreValidationConstants constants = (I_ModelsCoreValidationConstants) 
						CONSTANTS_FACTORY.invoke(I_ModelsCoreValidationConstants.class);
		return constants;
	}
}
