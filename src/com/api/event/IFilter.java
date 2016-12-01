package com.api.event;


public interface IFilter {
	
	/**
	 * 
	 * @param event that are provided by event generators
	 * @return true if event passed as parameter matches subscriber's defined filter
	 */
	boolean verify(IEvent event);
}
