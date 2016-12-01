package com.application.actors;

import java.util.Queue;

import com.api.event.IEvent;
import com.api.event.IListener;
import com.application.events.NewsAppearEvent;
import com.application.events.NewsDeleteEvent;
import com.application.events.NewsEvent;
import com.application.events.NewsUpdateEvent;

public class Editor extends EventGenerator implements IListener{
	private String name;
	private int noOfReaders;
	public Editor(String name, Queue<IEvent> eventQueue) {
		super(eventQueue);
		this.name = name;
		this.noOfReaders = 0;
	}
	
	
	@Override
	public void dispatch(IEvent event) {
		// TODO Auto-generated method stub
		if(event.getType() == NewsEvent.NEWS_READ_EVENT)
		{
			noOfReaders++;
			System.out.println("Somebody is interested in my news");
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
