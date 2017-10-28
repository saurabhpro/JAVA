/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package streams.basics;

import java.util.stream.Stream;

/**
 * Created by Saurabh on 2/28/2016.
 */
public class StreamIterator {
	public static void main(String[] args) {
		//create infinite stream, which dont need to be terminated
		Stream.iterate(1L, n -> n * 5)
				.skip(2) //skips first 2 numbers
				.limit(10)
				.forEach(System.out::println);

//		List grades = gradeScores.parallelStream()
//				.filter((Grade grade) -> grade.getScore() > 40)
//				.filter((Grade grade) -> grade.getSubject() == Subject.SCIENCE)
//				.collect(Collectors.toList());
	}
}
