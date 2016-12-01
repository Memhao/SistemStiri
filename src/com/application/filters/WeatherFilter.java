package com.application.filters;

import java.util.Vector;

import com.api.event.IEvent;
import com.api.event.IFilter;

public class WeatherFilter implements IFilter{

	private Vector<String> domains;
	public WeatherFilter() {
		this.domains = new Vector<String>();
		this.domains.addElement("WEATHER");
	}
	@Override
	public boolean verify(IEvent event) {
		// TODO Auto-generated method stub
		return event.getAttributes().equals(domains);
	}

}
