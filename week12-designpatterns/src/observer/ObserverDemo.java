package observer;

public class ObserverDemo {

	public static void main(String[] args) {
		//create subject
		ChatRoom room = new ChatRoom();
		
		//create observers
		Observer client1 = new ChatClient("Client 1", room);
		Observer client2 = new ChatClient("Client 2", room);
		Observer client3 = new SuperClient("Client 3", room);
		
		//now send message to subject
		room.postMessage("New Message");
		room.postMessage("Message 2");
	}

}