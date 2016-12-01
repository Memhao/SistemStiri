package com.application.events;

import com.application.actors.INews;

public class NewsAppearEvent extends NewsEvent{

	public NewsAppearEvent(INews news) {
		super(NewsEvent.NEWS_APPEAR_EVENT, news);
		// TODO Auto-generated constructor stub
	}

}
