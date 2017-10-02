package d_InterfaceSegregation.problem;

public class PDFFileProcessor implements Stream {
	@Override
	public String read() {
		return "This is the content of USS Discovery";
	}

	/*
	An Interface shouldn't force a Class to implement a method it doesn't want to,
	AKA - make slim interfaces not Fat ones
	 */
	@Override
	public void write(String data) {
		throw new RuntimeException("Illegal Access Detected to this PDF - Can't Perform write Operation");
	}
}
