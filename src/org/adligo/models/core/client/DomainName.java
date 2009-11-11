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
public class DomainName implements IsSerializable, I_NamedId, I_Mutable, I_Validateable {
	private static final Log log = LogFactory.getLog(DomainName.class);
	
	public static final String DOMAIN_NAME = "DomainName";
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	
	private NamedId namedId;
	private String[] components;
	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public DomainName() {
		namedId = new NamedId();
	}
	
	public DomainName(DomainName other) throws InvalidParameterException {
		I_DomainNameValidationConstants constants = (I_DomainNameValidationConstants) 
		CONSTANTS_FACTORY.invoke(I_DomainNameValidationConstants.class);

		namedId = new NamedId(other.namedId);
		if (StringUtils.isEmpty(namedId.getName())) {
			throw new InvalidParameterException(constants.getEmptyError(), DOMAIN_NAME);
		}

		components = new String[other.components.length];
		for (int i = 0; i < other.components.length; i++) {
			components[i] = other.components[i];
		}
	}
	
	public DomainName(String name) throws InvalidParameterException {
		setNameP(name, null);
	}

	public DomainName(String name, StorageIdentifier id) throws InvalidParameterException {
		setNameP(name, id);
	}
	
	private void setNameP(String p_name, StorageIdentifier id) throws InvalidParameterException {
		validate(p_name);
		namedId = new NamedId(p_name, id);
		
		char [] chars = p_name.toCharArray();
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
		return namedId.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof DomainName) {
			DomainName other = (DomainName) obj;
			if (namedId == null) {
				if (other.namedId != null)
					return false;
			} else if (!namedId.equals(other.namedId))
				return false;
			return true;
		}
		return false;
	}

	public String toString() {
		if (namedId == null) {
			return "'empty domain'";
		}
		if (namedId.getName() == null) {
			return "'empty domain'";
		}
		return namedId.getName();
	}

	public boolean isMutable() {
		return false;
	}

	public boolean isValid() {
		if (namedId == null) {
			return false;
		}
		if (namedId.getName() == null) {
			return false;
		}
		return true;
	}

	public StorageIdentifier getId() {
		return namedId.getId();
	}

	public String getName() {
		return namedId.getName();
	}
	
	
}
