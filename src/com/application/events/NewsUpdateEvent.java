package com.application.events;

import com.application.actors.INews;

public class NewsUpdateEvent extends NewsEvent{

	public NewsUpdateEvent(INews news) {
		super(NewsEvent.NEWS_UPDATE_EVENT, news);
		// TODO Auto-generated constructor stub
	}

}
