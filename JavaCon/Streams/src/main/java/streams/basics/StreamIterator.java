/*
 * Copyright (c) 2018 Saurabh Kumar
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
