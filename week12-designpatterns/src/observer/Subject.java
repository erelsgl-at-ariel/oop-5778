package observer;

/**
 * Adatped from https://www.journaldev.com/1739/observer-design-pattern-in-java
 * @author erelsgl
 */
public interface Subject {

	//method to register a new observer
	public void register(Observer obj);
	
	//method to notify observers of change
	public void notifyObservers();
	
	//method to get updates from subject
	public Object getUpdate(Observer obj);
}
