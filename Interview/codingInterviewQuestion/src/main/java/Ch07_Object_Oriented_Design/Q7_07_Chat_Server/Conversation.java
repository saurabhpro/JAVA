package Ch07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.ArrayList;

abstract class Conversation {
	final ArrayList<User> participants = new ArrayList<>();
	private final ArrayList<Message> messages = new ArrayList<>();
	private int id;

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public boolean addMessage(Message m) {
		messages.add(m);
		return true;
	}

	public int getId() {
		return id;
	}
}
