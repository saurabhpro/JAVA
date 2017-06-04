package b_structural.b_bridge.MovieBridge.formatter;

import b_structural.b_bridge.MovieBridge.model.Detail;

import java.util.List;

public interface Formatter {
	String format(String header, List<Detail> details);
}
