package com.api.event;

public interface IListener {
	/**
	 * Describes the behavior for this listener when receives an event
	 * @param event to which this listener should react
	 */
	void dispatch(IEvent event);
}
