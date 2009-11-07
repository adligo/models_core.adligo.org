package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_DomainValidationConstants;

public class Domain extends NamedId {
	public static final String VALIDATE = "validate";
	
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	
	public static String toDn(String domain) throws InvalidParameterException {
		validate(domain);
		
		//j2me doesn't have string builder
		StringBuffer sb = new StringBuffer();
		
		boolean first = true;
		int index = domain.indexOf('.');
		while (index != -1) {
			if (index == domain.length()) {
				index = -1;
			} else {
				if (!first) {
					sb.append(",");
				}
				String dc = domain.substring(0, index);
				sb.append("dc=");
				sb.append(dc);
				domain = domain.substring(index + 1, domain.length());
				index = domain.indexOf('.');
				first = false;
			}
		}
		if (!first) {
			sb.append(",");
			sb.append("dc=");
			sb.append(domain);
		} else {
			sb.append("dc=");
			sb.append(domain);
		}
		return sb.toString();
	}
	
	public static void validate(String domain) throws InvalidParameterException {
		I_DomainValidationConstants constants = (I_DomainValidationConstants) 
				CONSTANTS_FACTORY.invoke(I_DomainValidationConstants.class);
		
		if (StringUtils.isEmpty(domain)) {
			throw new InvalidParameterException(constants.getEmptyError(), VALIDATE);
		}
		domain = domain.trim();
		if (domain.length() < 4) {
			throw new InvalidParameterException(constants.getToShortError(), VALIDATE);
		}
		int dot = domain.indexOf(".");
		if (dot == -1) {
			throw new InvalidParameterException(constants.getNoDotError(), VALIDATE);
		}
		if (dot == 0) {
			throw new InvalidParameterException(constants.getDotCantBeFirst(), VALIDATE);
		}
		dot = -1;
		char [] chars = domain.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c =  chars[i];
			if (c == ' ') {
				throw new InvalidParameterException(constants.getNoSpaceError(), VALIDATE);
			} else if (c == '.') {
				if (dot == i-1) {
					throw new InvalidParameterException(constants.getDotCantBeConsecutive(), VALIDATE);
				}
				dot = i;
			}
		}
		if (dot == domain.length() - 1) {
			throw new InvalidParameterException(constants.getDotCantBeLast(), VALIDATE);
		}
	}
}
