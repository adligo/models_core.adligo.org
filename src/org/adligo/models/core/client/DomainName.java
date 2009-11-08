package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.util.client.ArrayCollection;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_DomainNameValidationConstants;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * immutable Class to represent a domain name ie adligo.com
 * @author scott
 *
 */
public class DomainName extends NamedId implements IsSerializable {
	private static final Log log = LogFactory.getLog(DomainName.class);
	
	public static final String DOMAIN_NAME = "DomainName";
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	
	private String[] components;
	private String asString;
	
	/**
	 * for serilization
	 */
	public DomainName() {}
	
	public DomainName(DomainName other) {
		components = new String[other.components.length];
		for (int i = 0; i < other.components.length; i++) {
			components[i] = other.components[i];
		}
		asString = other.asString;
	}
	
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
		if (components == null) {
			components = new String[1];
			components[0] = sb.toString();
		} else {
			String [] new_components = new String[components.length + 1];
			for (int i = 0; i < components.length; i++) {
				new_components[i] = components[i];
			}
			new_components[new_components.length - 1] = (sb.toString());
			components = new_components;
		}
		
	}
	
	public static String toDn(String domain) throws InvalidParameterException {
		DomainName name = new DomainName(domain);
		
		//j2me doesn't have string builder
		StringBuffer sb = new StringBuffer();
		
		String [] compts = name.components;
		for (int i = 0; i < compts.length; i++) {
			if (i != 0) {
				sb.append(",");
			}
			sb.append("dc=");
			sb.append(compts[i]);
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
		domain = domain.toLowerCase();
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

	public int hashCode() {
		return asString.hashCode();
	}

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

	public String toString() {
		return asString;
	}
	
	
}