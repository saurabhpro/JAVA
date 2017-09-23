/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
