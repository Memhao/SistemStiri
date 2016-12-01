package com.application.events;


import java.util.Vector;

import com.api.event.IEvent;
import com.application.actors.INews;

public abstract class NewsEvent implements IEvent{
	private INews news;
	private String eventType;
	
	
	public static final String NEWS_APPEAR_EVENT = "NEWS APPEARED";
	public static final String NEWS_UPDATE_EVENT = "NEWS UPDATED";
	public static final String NEWS_DELETE_EVENT = "NEWS DELETED";
	public static final String NEWS_READ_EVENT = "NEWS READ";
	
	
	public NewsEvent(String eventType, INews news) {
		this.eventType = eventType;
		this.news = news;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return eventType;
	}
	@Override
	public Vector<String> getAttributes() {
		// TODO Auto-generated method stub
		return news.getDomains();
	}
	public INews getNews()
	{
		return this.news;
	}


}
