package com.application.filters;

import java.util.Vector;

import com.api.event.IEvent;
import com.api.event.IFilter;

public class SportFilter implements IFilter{
	private Vector<String> domains;
	
	public SportFilter() {
		// TODO Auto-generated constructor stub
		this.domains = new Vector<String>();
		this.domains.addElement("SPORT");
	}
	@Override
	public boolean verify(IEvent event) {
		// TODO Auto-generated method stub
		return event.getAttributes().equals(domains);
	}

}
