package com.saurabh.expensetrackerwalnut.api;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.saurabh.expensetrackerwalnut.service.CSVParser.CSV_SEPARATOR;
import static com.saurabh.expensetrackerwalnut.service.CSVParser.MISPLACED_COMMA_REPLACEMENT;

@Component
public class CSVCustomFixer {

	public static String fixInputFromCSV(String line) {
		line = fixAmountValueFromCSV(line);
		line = fixPlacesFromCSV(line);
		line = fixTagsArrayFromCSV(line);

		return line;
	}

	static String fixPlacesFromCSV(String line) {
		Pattern pattern = Pattern.compile("\"([a-zA-Z0-9, ]+)\"");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			String tags = matcher.group(1).replace(CSV_SEPARATOR, MISPLACED_COMMA_REPLACEMENT);
			line = line.substring(0, matcher.start()) + tags + line.substring(matcher.end());
		}

		return line;

	}

	static String fixTagsArrayFromCSV(String line) {
		Pattern pattern = Pattern.compile("\"(\\#[a-zA-Z, #]+)\"");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			String tags = matcher.group(1).replace(CSV_SEPARATOR, MISPLACED_COMMA_REPLACEMENT);
			line = line.substring(0, matcher.start()) + tags + line.substring(matcher.end());
		}
		return line;
	}

	static String fixAmountValueFromCSV(String line) {
		Pattern pattern = Pattern.compile("\"([0-9]+,[0-9]+[.]?[0-9]+)\"");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			float amount = Float.parseFloat(matcher.group(1).replace(CSV_SEPARATOR, ""));
			line = line.substring(0, matcher.start()) + amount + line.substring(matcher.end());
		}
		return line;
	}

}
