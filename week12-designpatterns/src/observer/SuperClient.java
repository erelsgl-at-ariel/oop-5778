package observer;

public class SuperClient implements Observer {

	private String name;

	public SuperClient(String name, ChatRoom room) {
		this.name=name;
		room.register(this);
	}

	@Override
	public void update(Subject subject) {
		System.out.println("Super client!!!");
		System.out.println("BEEP!!!");
		
	}

}
