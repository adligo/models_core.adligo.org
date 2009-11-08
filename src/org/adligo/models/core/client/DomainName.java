package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.util.client.ArrayCollection;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_DomainNameValidationConstants;

/**
 * immutable Class to represent a domain name ie adligo.com
 * @author scott
 *
 */
public class DomainName extends NamedId {
	private static final Log log = LogFactory.getLog(DomainName.class);
	
	public static final String DOMAIN_NAME = "DomainName";
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	
	private ArrayCollection components = new ArrayCollection();
	private String asString;
	public DomainName(String name) throws InvalidParameterException {
		validate(name);
		asString = name;
		
		char [] chars = name.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '.') {
				addComponent(sb);
				sb = new StringBuffer();
			} else {
				sb.append(c);
			}
		}
		addComponent(sb);
	}

	private void addComponent(StringBuffer sb) {
		if (log.isDebugEnabled()) {
			log.debug("adding component " + sb.toString());
		}
		components.add(sb.toString());
	}
	
	public DomainName(DomainName other) {
		components = other.components;
		asString = other.asString;
	}
	
	public static String toDn(String domain) throws InvalidParameterException {
		DomainName name = new DomainName(domain);
		
		//j2me doesn't have string builder
		StringBuffer sb = new StringBuffer();
		
		ArrayCollection compts = name.components;
		for (int i = 0; i < compts.size(); i++) {
			if (i != 0) {
				sb.append(",");
			}
			sb.append("dc=");
			sb.append(compts.get(i));
		}
		return sb.toString();
	}
	
	public static void validate(String domain) throws InvalidParameterException {
		I_DomainNameValidationConstants constants = (I_DomainNameValidationConstants) 
				CONSTANTS_FACTORY.invoke(I_DomainNameValidationConstants.class);
		
		if (StringUtils.isEmpty(domain)) {
			throw new InvalidParameterException(constants.getEmptyError(), DOMAIN_NAME);
		}
		domain = domain.trim();
		if (domain.length() < 4) {
			throw new InvalidParameterException(constants.getToShortError(), DOMAIN_NAME);
		}
		int dot = domain.indexOf(".");
		if (dot == -1) {
			throw new InvalidParameterException(constants.getNoDotError(), DOMAIN_NAME);
		}
		if (dot == 0) {
			throw new InvalidParameterException(constants.getDotCantBeFirst(), DOMAIN_NAME);
		}
		dot = -1;
		char [] chars = domain.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c =  chars[i];
			if (c == ' ') {
				throw new InvalidParameterException(constants.getNoSpaceError(), DOMAIN_NAME);
			} else if (c == '.') {
				if (dot == i-1) {
					throw new InvalidParameterException(constants.getDotCantBeConsecutive(), DOMAIN_NAME);
				}
				dot = i;
			}
		}
		if (dot == domain.length() - 1) {
			throw new InvalidParameterException(constants.getDotCantBeLast(), DOMAIN_NAME);
		}
	}

	@Override
	public int hashCode() {
		return asString.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainName other = (DomainName) obj;
		if (asString == null) {
			if (other.asString != null)
				return false;
		} else if (!asString.equals(other.asString))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return asString;
	}
	
	
}
