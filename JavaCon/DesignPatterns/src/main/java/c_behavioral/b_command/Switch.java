package c_behavioral.b_command;

//invoker
public class Switch {

	public void storeAndExecute(Command command) {
		command.execute();
	}
}
