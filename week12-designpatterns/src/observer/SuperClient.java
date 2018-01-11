package observer;

public class SuperClient implements Observer {

	private String name;

	public SuperClient(String name, ChatRoom room) {
		this.name=name;
		room.register(this);
	}

	@Override
	public void update(Subject room) {
		String msg = (String) room.getUpdate(this);
		System.out.println("BEEP!! "+name+":: A new message::"+msg);
		
	}

}
