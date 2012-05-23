package org.adligo.models.core.client;

import java.io.Serializable;
/**
 * This interface allows usage of the models in this
 * package to be extended to have custom information
 * specific to the systems requirements (ie the jpeg byte [] of a picture of the person).
 * For example the system may have a heavy tracking 
 * requirement which tracks when rows were created,
 * by who, some sort of batching, history, exc.
 * This allows you to plugin all of this kind of information
 * at the class (row) level.
 *   
 * @author scott
 *
 */
public interface I_CustomInfo extends Serializable {
	/**
	 * This method should provide the immutable/immutable interface class
	 * which provides field specific information about this instance ie;
	 * getEdited (the timestamp this instance was changed)
	 * getEditedBy (the user id who changed this instance)
	 * exc
	 * 
	 * @return
	 */
	public Class getDetailClass();
	
	/**
	 * Implementations of this method should create a immutable copy or clone of this instance.
	 * 
	 * @return
	 */
	public I_CustomInfo toImmutable() throws ValidationException;
	
	/**
	 * Implementations of this method should create a mutable copy or clone of this instance.
	 * 
	 * @return
	 */
	public I_CustomInfo toMutant() throws ValidationException;
	/**
	 * if true this instance can be cast to a I_Validateable.
	 * @return
	 */
	public boolean isValidatable();
}
