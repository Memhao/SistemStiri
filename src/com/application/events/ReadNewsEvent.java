package com.application.events;


import com.application.actors.INews;

public class ReadNewsEvent extends NewsEvent{

	public ReadNewsEvent( INews news) {
		super(NewsEvent.NEWS_READ_EVENT, news);
		// TODO Auto-generated constructor stub
	}
}
