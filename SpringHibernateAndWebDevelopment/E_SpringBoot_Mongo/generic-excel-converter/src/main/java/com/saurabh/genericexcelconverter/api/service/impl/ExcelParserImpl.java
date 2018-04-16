package com.saurabh.genericexcelconverter.api.service.impl;

import com.saurabh.genericexcelconverter.api.constants.MessageConstants;
import com.saurabh.genericexcelconverter.api.model.MonthNotes;
import com.saurabh.genericexcelconverter.api.service.ExcelParser;
import com.saurabh.genericexcelconverter.web.dto.NoteDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.elasticsearch.common.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ExcelParserImpl implements ExcelParser {
	protected Integer year;

	@Override
	public List<MonthNotes> parse(int year) {
		long time1 = System.nanoTime();
		Path path = Paths.get(Objects.requireNonNull(MessageConstants.getFileName(year)));
		Sheet sheet = new XLSXSheetCreator().getSheet(path);
		this.year = year;
		List<MonthNotes> monthNotes = new ArrayList<>();

		Arrays.stream(Month.values())
				.parallel()
				.forEachOrdered((month) -> monthNotes.add(new MonthNotes(month, read(sheet, month))));

		System.out.println("time elapsed: " + (System.nanoTime() - time1));

		return monthNotes;
	}

	@Transactional
	List<NoteDTO> read(Sheet sheet, Month month) {
		List<NoteDTO> notes = new ArrayList<>(31);
		String content;
		Comment comment;

		LocalDateTime tempDate = java.time.LocalDateTime.of(year, month, 1, 0, 0, 0);

		for (int i = 3; i < month.maxLength(); i++, tempDate = tempDate.plusDays(1)) {
			content = sheet.getRow(i)
					.getCell(month.getValue())
					.getStringCellValue();

			if (!Strings.isNullOrEmpty(content)) {
				comment = sheet.getRow(i)
						.getCell(month.getValue(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellComment();

				if (comment != null)
					notes.add(new NoteDTO(tempDate.toString(), content, comment.getString().getString()));
				else
					notes.add(new NoteDTO(tempDate.toString(), content, null));
			}
		}

		return notes.size() > 0 ? notes : null;
	}

	private Month getMonth(Cell cell) {
		Month month;
		String monthAsString = null;
		try {
			monthAsString = cell.getStringCellValue();
			month = Month.valueOf(monthAsString);

		} catch (Exception e) {
			System.err.println("Wrong month name detected: " + monthAsString);
			throw e;
		}

		return month;
	}
}
