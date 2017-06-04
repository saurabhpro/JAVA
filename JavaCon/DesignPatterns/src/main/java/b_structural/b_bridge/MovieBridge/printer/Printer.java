package b_structural.b_bridge.MovieBridge.printer;

import b_structural.b_bridge.MovieBridge.formatter.Formatter;
import b_structural.b_bridge.MovieBridge.model.Detail;

import java.util.List;

public abstract class Printer {

	public String print(Formatter formatter) {
		return formatter.format(getHeader(), getDetails());
	}

	abstract protected List<Detail> getDetails();

	abstract protected String getHeader();
}
