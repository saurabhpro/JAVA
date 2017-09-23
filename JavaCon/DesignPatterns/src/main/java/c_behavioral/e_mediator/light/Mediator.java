package c_behavioral.e_mediator.light;

import java.util.ArrayList;
import java.util.List;

class Mediator {

	private final List<Light> lights = new ArrayList<>();

	public void registerLight(Light light) {
		lights.add(light);
	}

	public void turnOnAllLights() {
		for (Light light : lights) {
			if (!light.isOn()) {
				light.toggle();
			}
		}
	}

	public void turnOffAllLights() {
		for (Light light : lights) {
			if (light.isOn()) {
				light.toggle();
			}
		}
	}
}
