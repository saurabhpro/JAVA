package c_behavioral.b_command;

//invoker
class Switch {

	public void storeAndExecute(Command command) {
		command.execute();
	}
}
