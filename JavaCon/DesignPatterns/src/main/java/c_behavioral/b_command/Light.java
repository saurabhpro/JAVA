package c_behavioral.b_command;

//receiver
class Light {

	private boolean isOn = false;

	boolean isOn() {
		return isOn;
	}

	void toggle() {
		if (isOn) {
			off();
			isOn = false;
		} else {
			on();
			isOn = true;
		}
	}

	void on() {
		System.out.println("Light switched on.");
	}

	private void off() {
		System.out.println("Light switched off.");
	}
}
