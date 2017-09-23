package b_structural.b_bridge.MovieBridge.printer;

import b_structural.b_bridge.MovieBridge.model.Detail;
import b_structural.b_bridge.MovieBridge.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviePrinter extends Printer {

	private final Movie movie;

	public MoviePrinter(Movie movie) {
		this.movie = movie;
	}

	@Override
	protected List<Detail> getDetails() {
		List<Detail> details = new ArrayList<>();

		details.add(new Detail("Title", movie.getTitle()));
		details.add(new Detail("Year", movie.getYear()));
		details.add(new Detail("Runtime", movie.getRuntime()));

		return details;
	}

	@Override
	protected String getHeader() {
		return movie.getClassification();
	}

}
