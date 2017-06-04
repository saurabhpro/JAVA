package b_structural.b_bridge.MovieBridge;

import b_structural.b_bridge.MovieBridge.formatter.Formatter;
import b_structural.b_bridge.MovieBridge.formatter.HtmlFormatter;
import b_structural.b_bridge.MovieBridge.formatter.PrintFormatter;
import b_structural.b_bridge.MovieBridge.model.Movie;
import b_structural.b_bridge.MovieBridge.printer.MoviePrinter;
import b_structural.b_bridge.MovieBridge.printer.Printer;

public class BridgeDemo {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setClassification("Action");
		movie.setTitle("John Wick");
		movie.setRuntime("2:15");
		movie.setYear("2014");

		Formatter printFormatter = new PrintFormatter();
		Printer moviePrinter = new MoviePrinter(movie);

		String printedMaterial = moviePrinter.print(printFormatter);

		System.out.println(printedMaterial);


		Formatter htmlFormatter = new HtmlFormatter();

		String htmlMaterial = moviePrinter.print(htmlFormatter);

		System.out.println(htmlMaterial);
	}

}
