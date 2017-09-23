package c_behavioral.g_observer.obs;

import java.util.ArrayDeque;
import java.util.Deque;

class MessageStream extends Subject {

	private final Deque<String> messageHistory = new ArrayDeque<>();

	@Override
	String getState() {
		return messageHistory.getLast();
	}

	@Override
	void setState(String message) {
		messageHistory.add(message);
		this.notifyObservers();
	}
}
