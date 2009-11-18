package org.adligo.models.core.client;

import org.adligo.i.adi.client.I18nConstantsFactory;

public class ModelsCoreEnglishConstantsFactory {
	
	public ModelsCoreEnglishConstantsFactory() {
		I18nConstantsFactory fact = I18nConstantsFactory.INSTANCE;
		fact.put(I_ModelsCoreConstants.class, new ModelsCoreEnglishConstants());
	};
}
