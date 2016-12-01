package main;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import com.api.event.Dispatcher;
import com.api.event.IEvent;
import com.api.event.IFilter;
import com.application.actors.Editor;
import com.application.actors.News;
import com.application.actors.Reader;
import com.application.filters.SportFilter;
import com.application.filters.WeatherFilter;
public class Main {
	public static void main(String argv[])
	{
		Dispatcher dispatcher = new Dispatcher();
		
		Queue<IEvent> events = new LinkedList<IEvent>();
		
		
		Reader r0 = new Reader("Eminescu", events);
		Reader r1 = new Reader("Veronica", events);
		Reader r2 = new Reader("Ion", events);
		
		Editor e0 = new Editor("Einstain, BBC", events);
		Editor e1 = new Editor("Tesla, BBC", events);
		
		dispatcher.subscribeListener(new SportFilter(), r0);
		dispatcher.subscribeListener(new WeatherFilter(), r0);
		dispatcher.subscribeListener(new WeatherFilter(), r1);
		
		
		dispatcher.subscribeListener(new SportFilter(), r2);
		dispatcher.subscribeListener(new IFilter() {
			private Vector<String> domains;
			
			{
				// TODO Auto-generated constructor stub
				this.domains = new Vector<String>();
				this.domains.addElement("SPORT");
				this.domains.addElement("FOOTBALL");
			}
			@Override
			public boolean verify(IEvent event) {
				// TODO Auto-generated method stub
				return event.getAttributes().equals(domains);
			}
		}, r2);
		dispatcher.subscribeListener(new IFilter() {
			
			@Override
			public boolean verify(IEvent event) {
				// TODO Auto-generated method stub
				return true;
			}
		}, e0);
		dispatcher.subscribeListener(new IFilter() {
			
			@Override
			public boolean verify(IEvent event) {
				// TODO Auto-generated method stub
				return true;
			}
		}, e1);
		
		Vector<String> category0= new Vector<String>();
		category0.add("SPORT");
		category0.add("FOOTBALL");
		
		
		Vector<String> category1= new Vector<String>();
		category1.add("SPORT");
		
		Vector<String> category2= new Vector<String>();
		category2.add("WEATHER");
		
		News news0 = new News("Becali is on the floor[SPORT,FOOTBAL]","...",category0, "Einstain", "ROITERS",  new Date(), new Date());
		News news1 = new News("Welcome to the tolo[SPORT]","...",category1, "Tesla", "HELLO",  new Date(), new Date());
		News news2 =new News("Today is raining with blood[WEATHER]","...",category2, "Hitler", "ZDOGA",  new Date(), new Date());
		
		e0.newsAppeared(news0);
		e0.newsAppeared(news1);
		e0.newsAppeared(news2);
		e0.newsAppeared(news1);
		
		e1.newsUpdated(news2);
		e1.newsUpdated(news1);
		e1.newsDeleted(news2);
		e0.newsDeleted(news1);
		e0.newsDeleted(news0);
		
		
		r0.newsRead(news1);
		r1.newsRead(news1);
		r0.newsRead(news0);
		r1.newsRead(news2);
		
		
		
		while (!events.isEmpty()) {
			IEvent evt = events.remove();
			dispatcher.publish(evt);
		}
		
//	    EventRouter dispatcher = new EventRouter();
//	    
//	    Queue<Event> eventsGenerated = new LinkedList<Event>();
//	    Reader r0 = new Reader("Eminescu", eventsGenerated);
//	    Reader r1 = new Reader("Veronica", eventsGenerated);
//	    
//	    r0.addNewsFilter(Domain.SPORT);
//	    r0.addNewsFilter(Domain.BREXIT);
//	    r1.addNewsFilter(Domain.SPORT);
//	    
//	    Editor e = new Editor("Sun Tzu", eventsGenerated);
//	    dispatcher.registerListener(AppearEvent.class,r0);
//	    dispatcher.registerListener(UpdateEvent.class, r0);
//	    dispatcher.registerListener(DeletionEvent.class, r0);
//	    
//	    dispatcher.registerListener(AppearEvent.class,r1);
//	    dispatcher.registerListener(UpdateEvent.class, r1);
//	    dispatcher.registerListener(DeletionEvent.class, r1);
//
//	    
//	    dispatcher.registerListener(ReadNewsEvent.class, e);
//	    
//	    e.appearNews(new News("Becali is on the stage", Domain.SPORT, "Ionescu", "XXX", new Date(), new Date()));
//	    e.appearNews(new News("Mutu trage iar pe nas", Domain.SPORT, "Videsuc", "Xff", new Date(), new Date()));
//	    e.appearNews(new News("Trump is winning the election in Moscow", Domain.BREXIT, "Trump", "Wtf", new Date(), new Date()));
//	   
//	    e.updateNews(new News("Trump is losing the election in Moscow", Domain.BREXIT, "Trump", "Wtf", new Date(), new Date()));
//	    r0.imReadingNews();
//	    r0.imReadingNews();
//	    e.deletionNews(new News("Title1", Domain.SPORT, "MeXme", "XXX", new Date(), new Date()));
//	    
//	    
//	    while (!eventsGenerated.isEmpty()) {
//	        Event evt = eventsGenerated.remove();
//	        dispatcher.dispatch(evt);
//	      }
//	    
	    
		
	}
}
