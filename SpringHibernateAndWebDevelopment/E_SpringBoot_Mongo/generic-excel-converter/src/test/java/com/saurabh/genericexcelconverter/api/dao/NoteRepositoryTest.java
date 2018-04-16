package com.saurabh.genericexcelconverter.api.dao;

import com.saurabh.genericexcelconverter.api.model.Note;
import com.saurabh.genericexcelconverter.util.BaseIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

class NoteRepositoryTest extends BaseIntegrationTest {

	private final LocalDateTime dateTime = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
	@Autowired
	private NoteRepository justiceLeagueRepo;

	/**
	 * This method will test if we can successfully retrieve the justice league
	 * members using there name.
	 */
	@Test
	void findByDate() {
		Note expected = new Note(dateTime, "Super speed", "Central City");
		mongoTemplate.save(expected);

		Note actual = justiceLeagueRepo.findByDate(dateTime.toString());

		Assertions.assertEquals(expected, actual);
	}
}