package com.api.event;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Dispatcher implements IDispatcher {

	private Map<IListener,HashSet<IFilter>> listenersFilters;
	
	
	public Dispatcher() {
		listenersFilters = new HashMap<IListener,HashSet<IFilter>>();
	}
	@Override
	public void subscribeListener(IFilter filter, IListener listener) {
		if(this.listenersFilters.get(listener) == null)
		{
			this.listenersFilters.put(listener, new HashSet<IFilter>());
		}
		this.listenersFilters.get(listener).add(filter);
	}
	
	@Override
	public void unsubscribeListener(IFilter filter, IListener listener) {
		// TODO Auto-generated method stub
		if(this.listenersFilters.get(listener).size() == 0)
		{
			return;
		}else if(this.listenersFilters.get(listener).contains(filter))
		{
			this.listenersFilters.get(listener).remove(filter);	
		}
		
	}

	@Override
	public void publish(IEvent event) {
		// TODO Auto-generated method stub
		Set<IListener> listeners = this.listenersFilters.keySet();
		for(IListener listener : listeners)
		{
			HashSet<IFilter> filters = this.listenersFilters.get(listener);
			for(IFilter filter: filters)
			{
				if(filter.verify(event))
				{
					listener.dispatch(event);
				}
			}
		}
	}

}
