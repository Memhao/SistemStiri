package com.api.event;

public interface IDispatcher {
	
	/**
	 * Subscribe listeners for events that are strained by a filters
	 * @param filter what events a listener are registered 
	 * in other words a class may register(listen) for more events
	 * @param listener is class that are interested in events specified by filter
	 */
	public void subscribeListener(IFilter filter,IListener listener);
	
	
	/**
	 * Unsubscribe a listener if it is no longer interested in listening for certain events
	 * @param filter what events a listener are registered 
	 * @param listener is class that are interested in events specified by filter
	 */
	
	public void unsubscribeListener(IFilter filter, IListener listener);
	/**
	 * Listeners received events in which they are interested in via filters
	 * @param event to be dispatch accordingly to its filter and listeners
	 */
	public void publish(IEvent event);
	
}
