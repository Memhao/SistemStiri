package com.api.event;

import java.util.Vector;

public interface IEvent {
	
	/**
	 * Get type of this event
	 * @return type of event 
	 */
	String getType();
	
	Vector<String> getAttributes();

}
