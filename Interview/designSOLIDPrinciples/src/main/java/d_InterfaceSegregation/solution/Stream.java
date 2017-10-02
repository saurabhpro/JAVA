package d_InterfaceSegregation.solution;

public interface Stream extends ReadStream, WriteStream {
}

interface ReadStream {
	String read();
}

interface WriteStream {
	void write(String data);
}

