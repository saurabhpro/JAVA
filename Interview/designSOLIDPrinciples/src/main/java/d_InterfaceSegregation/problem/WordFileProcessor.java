package d_InterfaceSegregation.problem;

public class WordFileProcessor implements Stream {

	//This is fine

	@Override
	public void write(String data) {
		System.out.println("writing data : [" + data + "]");
	}

	@Override
	public String read() {
		return "This is the content of USS Discovery";
	}
}
