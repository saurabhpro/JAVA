/*
 * Copyright (c) 2018 Saurabh Kumar
 */

//: innerclasses/greenhouse_TIJ.controller/Controller.java
// The reusable framework for control systems.
package greenhouse_TIJ.controller;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	// A class from java.util to hold Event objects:
	private final List<Event> eventList = new ArrayList<>();

	public void addEvent(Event c) {
		eventList.add(c);
	}

	public void run() {
		while (eventList.size() > 0)
			// Make a copy so you're not modifying the list
			// while you're selecting the elements in it:
			for (Event e : new ArrayList<>(eventList))
				if (e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
	}
} ///:~
