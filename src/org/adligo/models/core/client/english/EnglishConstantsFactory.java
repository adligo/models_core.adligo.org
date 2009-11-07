package org.adligo.models.core.client.english;

import org.adligo.models.core.client.ConstantsFactory;
import org.adligo.models.core.client.i18n.I_DomainValidationConstants;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;

public class EnglishConstantsFactory {
	
	public EnglishConstantsFactory() {
		ConstantsFactory fact = ConstantsFactory.INSTANCE;
		fact.put(I_UserValidationConstants.class, new UserValidationConstants());
		fact.put(I_DomainValidationConstants.class, new DomainValidationConstants());
	};
}
