package org.adligo.models.core.shared;

import org.adligo.i.adi.shared.I_Invoker;
import org.adligo.i.adi.shared.InvokerNames;
import org.adligo.i.adi.shared.Registry;

public class ModelsCoreConstantsObtainer {

	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(InvokerNames.CONSTANTS_FACTORY);
	
	public static I_ModelsCoreConstants getConstants() {
		I_ModelsCoreConstants constants = (I_ModelsCoreConstants) 
						CONSTANTS_FACTORY.invoke(I_ModelsCoreConstants.class);
		return constants;
	}
}
