/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package c_behavioral.g_observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverEverydayDemo {

	public static void main(String args[]) {
		TwitterStream messageStream = new TwitterStream();

		Client client1 = new Client("Bryan");

		Client client2 = new Client("Mark");

		messageStream.addObserver(client1);
		messageStream.addObserver(client2);

		messageStream.someoneTweeted();
	}
}

// concrete subject
class TwitterStream extends Observable {

	public void someoneTweeted() {
		setChanged();
		notifyObservers();
	}
}

//concrete observer
class Client implements Observer {
	private final String name;

	Client(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update " + name + "'s stream, someone tweeted something.");
	}
}