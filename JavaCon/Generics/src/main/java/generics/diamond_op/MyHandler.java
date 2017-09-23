package generics.diamond_op;

abstract class MyHandler<T> {

	private T content;

	MyHandler(T content) {
		this.content = content;
		System.out.println("constructor for MyHandler with content: " + content.toString());
	}

	T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	abstract void handle();
}