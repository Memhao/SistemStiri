package com.application.actors;

import java.util.Queue;

import com.api.event.IEvent;
import com.api.event.IListener;
import com.application.events.NewsAppearEvent;
import com.application.events.NewsDeleteEvent;
import com.application.events.NewsEvent;
import com.application.events.NewsUpdateEvent;
import com.application.events.*;

public class Reader extends EventGenerator implements IListener{
	private String name;
	public Reader(String name,Queue<IEvent> eventQueue){
		super(eventQueue);
		this.name = name;
	}
	/**
	 * Show the behavior of Reader when an event occurs
	 */
	@Override
	public void dispatch(IEvent event) {
		switch (event.getType()) {
		case NewsEvent.NEWS_APPEAR_EVENT:
			NewsAppearEvent appevent = ((NewsAppearEvent)event);
			System.out.println("["+this.name+"]" + "Fresh news:" +appevent.getNews().getTitle()+ appevent.getNews().getContent());
			break;
		case NewsEvent.NEWS_UPDATE_EVENT:
			NewsUpdateEvent updaeevent = ((NewsUpdateEvent)event);
			System.out.println("["+this.name+"]" + "Updated news:" + updaeevent.getNews().getTitle()+ updaeevent.getNews().getContent());
			break;
		case NewsEvent.NEWS_DELETE_EVENT:
			NewsDeleteEvent deleteevent = ((NewsDeleteEvent)event);
			System.out.println("["+this.name+"]" + "Deleted news"+deleteevent.getNews().getTitle()  + deleteevent.getNews().getContent()+ " No longer available in system");
			break;
		default:
			break;
		}
	}

	/**
	 * Event generator method
	 * @param news
	 */
	public void newsRead(INews news)
	{
		eventQueue.add(new ReadNewsEvent(news));
	}
	@Override
	public String toString() {
		return "Reader [name=" + name + "]";
	}
}
