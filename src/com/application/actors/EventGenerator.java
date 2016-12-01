package com.application.actors;

import java.util.Queue;

import com.api.event.IEvent;

public abstract class EventGenerator {
	protected Queue<IEvent> eventQueue;
	public EventGenerator(Queue<IEvent> eventQueue)
	{
		this.eventQueue = eventQueue;
	}
	@Override
	public String toString() {
		return "EventGenerator [eventQueue=" + eventQueue + "]";
	}
	
}
