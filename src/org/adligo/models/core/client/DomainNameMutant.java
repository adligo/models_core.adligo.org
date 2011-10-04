package org.adligo.models.core.client;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.util.client.StringUtils;

public class DomainNameMutant implements I_DomainNameMutant, I_Validateable, I_Mutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(DomainName.class);
	

	public static final String DOMAIN_NAME = "DomainName";
	
	private NamedIdMutant namedId = new NamedIdMutant();
	private String[] components;
	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public DomainNameMutant() {
	}
	
	public DomainNameMutant(I_NamedId other) throws InvalidParameterException {

		if (other == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getDomainNameEmptyError(), DOMAIN_NAME);
		}
		setName(other.getName());
		I_StorageIdentifier id = other.getId();
		if (id != null) {
			setId(other.getId());
		}
	}
	
	public DomainNameMutant(String name) throws InvalidParameterException {
		setName(name);
	}

	public DomainNameMutant(String name, I_StorageIdentifier id) throws InvalidParameterException {
		setName(name);
		if (id != null) {
			setId(id);
		}
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


	public boolean isValid() {
		try {
			DomainNameMutant o = new DomainNameMutant(this);
		} catch (InvalidParameterException x) {
			return false;
		}
		return true;
	}


	@Override
	public boolean isMutable() {
		return true;
	}
	
	/**
	 * builds a dn (distinguished name dc=adligo,dc=com) from a domain name (adligo.com)
	 * @param domain
	 * @return
	 * @throws InvalidParameterException
	 */
	public static String toDn(String domain) throws InvalidParameterException {
		DomainNameMutant name = new DomainNameMutant(domain);
		
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

	public I_StorageIdentifier getId() {
		return namedId.getId();
	}

	public void setId(I_StorageIdentifier p_id)
			throws InvalidParameterException {
		namedId.setId(p_id);
	}

	public String getName() {
		return namedId.getName();
	}

	public void setName(String p_name) throws InvalidParameterException {
		validate(p_name);
		namedId.setName(p_name);
		
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

	public int hashCode() {
		return namedId.hashCode();
	}

	public boolean equals(Object obj) {
		return namedId.equals(obj);
	}
	
	public String toString() {
		return namedId.getName();
	}
}
