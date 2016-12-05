package com.application.actors;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

import com.api.event.IEvent;
import com.api.event.IListener;
import com.application.events.NewsAppearEvent;
import com.application.events.NewsDeleteEvent;
import com.application.events.NewsEvent;
import com.application.events.NewsUpdateEvent;
import com.application.events.ReadNewsEvent;

public class Editor extends EventGenerator implements IListener{
	private String name;
	private int noOfReaders;
	private Map<Vector<String>,Integer> domains;
	public Editor(String name, Queue<IEvent> eventQueue) {
		super(eventQueue);
		this.name = name;
		this.noOfReaders = 0;
		this.domains = new HashMap<Vector<String>,Integer>();
	}
	/**
	 * Will announce the others that this Editor writes news in a certain domain
	 * @param domain 
	 */
	public void subscribeDomain(Vector<String> domain)
	{
		this.domains.put(domain, 0);
	}
	/**
	 * check that a certain Reader are interested in my domains ( I write for the SPORTS and SCIENCE section as EDITOR for e.g.)
	 */
	@Override
	public void dispatch(IEvent event) {
		// TODO Auto-generated method stub

		if(event.getType() == NewsEvent.NEWS_READ_EVENT)
		{
			ReadNewsEvent nwevent = (ReadNewsEvent)event;
			if(domains.keySet().contains(nwevent.getAttributes()))
			{
				this.domains.put(nwevent.getAttributes(), domains.get(nwevent.getAttributes()) + 1);
				System.out.println("Somebody is interested in my news");
			}
			
		}
		for ( Map.Entry<Vector<String>, Integer> entry : domains.entrySet()) {
		    Vector<String> key = entry.getKey();
		    Integer tab = entry.getValue();
			System.out.println(key+":No of user: "+tab);
		}
	
	}
	public String toString(){
		return this.name + ":" + this.noOfReaders;
	}

	
	
	/**
	 * Event generator method
	 * @param news
	 */
	public void newsAppeared(INews news)
	{
		eventQueue.add(new NewsAppearEvent(news));
	}
	/**
	 * Event generator method
	 * @param news
	 */
	public void newsDeleted(INews news)
	{
		eventQueue.add(new NewsDeleteEvent(news));
	}
	/**
	 * Event generator method
	 * @param news
	 */
	public void newsUpdated(INews news)
	{
		eventQueue.add(new NewsUpdateEvent(news));
	}
	


}
