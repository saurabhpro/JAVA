/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.c_behavioral.h_state;

class Fan {

	private final State fanOffState;
	private final State fanLowState;
	private final State fanMedState;
	private final State fanHighState;

	private State state;

	public Fan() {
		fanOffState = new FanOffState(this);
		fanLowState = new FanLowState(this);
		fanMedState = new FanMedState(this);
		fanHighState = new FanHighState(this);

		state = fanOffState;
	}

	public void pullChain() {
		state.handleRequest();
	}

	public String toString() {
		return state.toString();
	}

	public State getFanOffState() {
		return fanOffState;
	}

	public State getFanLowState() {
		return fanLowState;
	}

	public State getFanMedState() {
		return fanMedState;
	}

	public State getFanHighState() {
		return fanHighState;
	}

	public void setState(State state) {
		this.state = state;
	}
}


