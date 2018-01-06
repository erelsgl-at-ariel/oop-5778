package observer;

/**
 * Adatped from https://www.journaldev.com/1739/observer-design-pattern-in-java
 * @author erelsgl
 */
public interface Observer {
	//method to update the observer, used by Subject
	public void update(Subject subject);
}