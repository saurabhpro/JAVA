package c_behavioral.a_chain.ceo;

public abstract class Handler {

	Handler successor;

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	protected abstract void handleRequest(Request request);

}
