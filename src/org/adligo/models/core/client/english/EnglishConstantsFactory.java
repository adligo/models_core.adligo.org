package org.adligo.models.core.client.english;

import org.adligo.models.core.client.ConstantsFactory;
import org.adligo.models.core.client.i18n.I_AddressValidationConstants;
import org.adligo.models.core.client.i18n.I_DomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_EmailValidationConstants;
import org.adligo.models.core.client.i18n.I_OrganizationValidationConstants;
import org.adligo.models.core.client.i18n.I_PersonValidationConstants;
import org.adligo.models.core.client.i18n.I_PhoneNumberValidationConstants;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;

public class EnglishConstantsFactory {
	
	public EnglishConstantsFactory() {
		ConstantsFactory fact = ConstantsFactory.INSTANCE;
		fact.put(I_UserValidationConstants.class, new UserValidationConstants());
		fact.put(I_DomainNameValidationConstants.class, new DomainValidationConstants());
		fact.put(I_EmailValidationConstants.class, new EmailValidationConstants());
		fact.put(I_AddressValidationConstants.class, new AddressValidationConstants());
		fact.put(I_OrganizationValidationConstants.class, new OrganizationsValidationConstants());
		fact.put(I_PersonValidationConstants.class, new PersonValidationConstants());
		fact.put(I_PhoneNumberValidationConstants.class, new PhoneNumberValidationConstants());
	};
}
