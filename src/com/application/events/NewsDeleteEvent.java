package com.application.events;

import com.application.actors.INews;

public class NewsDeleteEvent extends NewsEvent{

	public NewsDeleteEvent( INews news) {
		super(NewsEvent.NEWS_DELETE_EVENT, news);
		// TODO Auto-generated constructor stub
	}

}
