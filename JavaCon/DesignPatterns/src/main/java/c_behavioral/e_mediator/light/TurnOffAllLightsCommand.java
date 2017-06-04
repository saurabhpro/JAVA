package c_behavioral.e_mediator.light;

//concrete command
public class TurnOffAllLightsCommand implements Command {

	private Mediator med;

	public TurnOffAllLightsCommand(Mediator med) {
		this.med = med;
	}

	@Override
	public void execute() {
		med.turnOffAllLights();
	}
}