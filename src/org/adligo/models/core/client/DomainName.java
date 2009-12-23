package org.adligo.models.core.client;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;

/**
 * immutable Class to represent a domain name ie adligo.com
 * @author scott
 *
 */
public class DomainName implements I_Serializable, I_NamedId, I_Mutable, I_Validateable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(DomainName.class);
	
	public static final String DOMAIN_NAME = "DomainName";
	
	protected NamedId namedId;
	protected String[] components;
	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public DomainName() {
		namedId = new NamedId();
	}
	
	public DomainName(DomainName other) throws InvalidParameterException {

		if (other == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getDomainNameEmptyError(), DOMAIN_NAME);
		}
		namedId = new NamedId(other.namedId);
		if (StringUtils.isEmpty(namedId.getName())) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getDomainNameEmptyError(), DOMAIN_NAME);
		}

		components = new String[other.components.length];
		for (int i = 0; i < other.components.length; i++) {
			components[i] = other.components[i];
		}
	}
	
	public DomainName(String name) throws InvalidParameterException {
		setNameP(name, null);
	}

	public DomainName(String name, StringIdentifier id) throws InvalidParameterException {
		setNameP(name, id);
	}
	
	private void setNameP(String p_name, StringIdentifier id) throws InvalidParameterException {
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
	
	/**
	 * builds a dn (distinguished name dc=adligo,dc=com) from a domain name (adligo.com)
	 * @param domain
	 * @return
	 * @throws InvalidParameterException
	 */
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
	
	/**
	 * builds a domain name (adligo.org) from a dn (distinguished name dc=adligo,dc=com)
	 * @param dn
	 * @return
	 * @throws InvalidParameterException
	 */
	public static String fromDn(String dn) throws InvalidParameterException {
		
		//j2me doesn't have string builder
		StringBuffer sb = new StringBuffer();
		int dcIndex = dn.indexOf("dc");
		boolean first = true;
		while (dcIndex != -1) {
			int eIndex = dn.indexOf("=", dcIndex + 1);
			if (eIndex != -1) {
				int cIndex = dn.indexOf(",", eIndex + 1);
				if (cIndex > eIndex) {
					String comp = dn.substring(eIndex + 1, cIndex);
					if (!first) {
						sb.append(".");
					}
					sb.append(comp);
					first = false;
				} else {
					String comp = dn.substring(eIndex + 1, dn.length());
					if (!first) {
						sb.append(".");
					}
					sb.append(comp);
					first = false;
				}
			}
			dcIndex = dn.indexOf("dc", dcIndex + 1);
		}
		return sb.toString();
	}
	
	public static void validate(String domain) throws InvalidParameterException {
		
		if (StringUtils.isEmpty(domain)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getDomainNameEmptyError(), DOMAIN_NAME);
		}
		domain = domain.trim();
		domain = domain.toLowerCase();
		if (domain.length() < 4) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getDomainNameToShortError(), DOMAIN_NAME);
		}
		int dot = domain.indexOf(".");
		if (dot == -1) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getDomainNameNoDotError(), DOMAIN_NAME);
		}
		if (dot == 0) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getDomainNameDotCantBeFirst(), DOMAIN_NAME);
		}
		dot = -1;
		char [] chars = domain.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c =  chars[i];
			if (c == ' ') {
				throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
						.getDomainNameNoSpaceError(), DOMAIN_NAME);
			} else if (c == '.') {
				if (dot == i-1) {
					throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
							.getDomainNameDotCantBeConsecutive(), DOMAIN_NAME);
				}
				dot = i;
			}
		}
		if (dot == domain.length() - 1) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getDomainNameDotCantBeLast(), DOMAIN_NAME);
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

	public I_StorageIdentifier getId() {
		return namedId.getId();
	}

	public String getName() {
		return namedId.getName();
	}
	
	
}
