package com.api.event;


public interface IFilter {
	
	/**
	 * 
	 * @param vector are provided by listeners(subscribers) to express their preferences for certain events
	 * @return true if a certain event that provides information for this method satisfy a certain filter specified by subscriber, else false 
	 */
	boolean verify(IEvent event);
}
