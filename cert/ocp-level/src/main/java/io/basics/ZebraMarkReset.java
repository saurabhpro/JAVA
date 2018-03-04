package io.basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static io.FilePaths.BASE_RELATIVE_PATH;

public class ZebraMarkReset implements Serializable {
	private static final long serialUID = 1L;
	private static String birthPlace = "Africa";    // the static value will not be serialized; it will be available on the class after deserialization.
	private transient String name = "George";
	private transient Integer age;
	private List<ZebraMarkReset> friends = new ArrayList<>();
	private Object tail = null;

	{
		age = 10;
	}

	public ZebraMarkReset() {
		this.name = "Sophia";
	}


	/**
	 * If the stream does support the mark() operation, then the result would be XYZY,
	 * because the reset() operation puts the stream back in the position
	 * before the mark() was called, and skip(1) will skip X
	 */
	private static String pullBytes(InputStream is, int count) throws IOException {
		is.mark(count);
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++)
			sb.append((char) is.read());
		is.reset();
		final long skip = is.skip(1);
		sb.append((char) is.read());
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		final String bytes = pullBytes(new FileInputStream(BASE_RELATIVE_PATH + "log.txt"), 3);
	}
}

/**
 * ava will call the constructor for the first non-serializable no-argument parent class during deserialization,
 * skipping any constructors and default ini- tializations for serializable classes in between, including Eagle and Bird itself.
 */
class Bird implements Serializable {
	protected transient String name = "Bridget";

	public Bird() {
		this.name = "Matt";
	}

	public String getName() {
		return name;
	}

	// the caller cannot change the serialized value of name with setName(), since name is marked transient.
	public void setName(String name) {
		this.name = name;
	}
}

class Eagle extends Bird implements Serializable {
	{
		this.name = "Janette";
	}

	public Eagle() {
		this.name = "Daniel";
	}
}