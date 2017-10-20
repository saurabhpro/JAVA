package com.saurabh.expensetrackerwalnut.service;

import com.opencsv.CSVReader;
import com.saurabh.expensetrackerwalnut.api.TimeUtils;
import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.saurabh.expensetrackerwalnut.api.CSVCustomFixer.fixInputFromCSV;
import static com.saurabh.expensetrackerwalnut.api.CategoryProducer.determineCategory;
import static com.saurabh.expensetrackerwalnut.api.ModeOfExpense.determineModeOfExpense;

@Service
public class CSVParserImpl implements CSVParser<WalnutRow>, TimeUtils {

	private static final Logger logger = LoggerFactory.getLogger(CSVParserImpl.class);
	private static final int PreFaceLines = 4;

	static LocalDate fromDate;
	static LocalDate toDate;

	private WalnutRow fillWalnutObject(String line, int id) {
		WalnutRow walnutRow = new WalnutRow();

		int i = 0;
		String[] part = line.split(CSV_SEPARATOR);

		walnutRow.setID(id);

		walnutRow.setDateTime(TimeUtils.parseToDateTime(part[i++].trim(), part[i++].trim()));

		walnutRow.setPlace(part[i++].trim());

		walnutRow.setAmount(Float.parseFloat(part[i++]));

		walnutRow.setModeOfExpense(determineModeOfExpense(part[i++].trim()));

		walnutRow.setExpense("Yes".equals(part[i++].trim()));

		if (i < part.length)
			walnutRow.setCategory(determineCategory(part[i++].trim()));

		if (i < part.length)
			walnutRow.setTags(Arrays.stream(part[i++].split(MISPLACED_COMMA_REPLACEMENT)).map(String::trim).collect(Collectors.toList()));

		if (i < part.length)
			walnutRow.setNote(part[i]);

		return walnutRow;
	}

	@Override
	public void parseCSVHeader(String filePath) {

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

			String[] line;
			int lineCount = 0;
			while ((line = reader.readNext()) != null && (++lineCount < PreFaceLines)) {
				if (lineCount == 2) {
					fromDate = TimeUtils.getLocalDate(line[1], DATE_WITH_YEAR_IN_FOUR_DIGIT);
					toDate = TimeUtils.getLocalDate(line[3], DATE_WITH_YEAR_IN_FOUR_DIGIT);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<WalnutRow> parseCSVBody(String filePath) {
		int lineCount = 0;

		List<WalnutRow> walnutRowList = null;

		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			walnutRowList = new ArrayList<>();

			//noinspection StatementWithEmptyBody
			while (br.readLine() != null && ++lineCount <= PreFaceLines) {
				// skip first 4 lines
			}

			int lineNo = 0;
			while ((line = br.readLine()) != null && !StringUtils.isEmpty(line)) {
				line = fixInputFromCSV(line);

				logger.info(line);

				walnutRowList.add(fillWalnutObject(line, ++lineNo));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return walnutRowList;
	}
}

