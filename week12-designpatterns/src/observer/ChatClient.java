package observer;

/**
 * Adatped from https://www.journaldev.com/1739/observer-design-pattern-in-java
 * @author erelsgl
 */
public class ChatClient implements Observer {
	private String name;
	
	public ChatClient(String name, ChatRoom room) {
		this.name=name;
		room.register(this);
	}
	
	@Override public void update(Subject room) {
		String msg = (String) room.getUpdate(this);
		System.out.println(name+":: A new message::"+msg);
	}
}