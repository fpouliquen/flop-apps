
package org.flop.fsm.service;

import java.util.List;

public interface MappingService {

	/**
	 * Converts the given object into objects of the given destination class.
	 * 
	 * @param sourcesObjects
	 * @param destinationClass
	 * @return The mapped objects list.
	 */
	public <T> List<T> map(List<? extends Object> sourcesObjects, Class<T> destinationClass);
}
