package observer;

import java.util.*;

/**
 * Adatped from https://www.journaldev.com/1739/observer-design-pattern-in-java
 * @author erelsgl
 */
public class ChatRoom implements Subject {
	private List<Observer> observers = new ArrayList<>(); 
	private String message;
	private boolean changed;
	
	@Override public void register(Observer obj) {
		if(obj == null) 
			throw new NullPointerException("Null Observer");
		synchronized (observers) {
			if(!observers.contains(obj)) 
				observers.add(obj);
		}
	}

	@Override public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (observers) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obs : observersLocal) {
			obs.update(this);
		}
	}

	@Override public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}

}