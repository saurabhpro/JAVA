package com.saurabh.genericexcelconverter.api.service;

import com.saurabh.genericexcelconverter.api.model.MonthNotes;
import com.saurabh.genericexcelconverter.api.model.Note;
import com.saurabh.genericexcelconverter.web.dto.NoteDTO;

/**
 * This interface defines the functionality exposed on the justice league
 * management system.
 *
 * @author dinuka
 */

public interface NoteService {

	/**
	 * This method will add a new member to the system.
	 *
	 * @param justiceLeagueMember an instance of {@link NoteDTO} with the member
	 *                            details.
	 */
	void addNote(final NoteDTO justiceLeagueMember);

	/**
	 * This method will add a new member to the system.
	 *
	 * @param note an instance of {@link Note} with the member
	 *             details.
	 */
	void addNote(final MonthNotes note);
}
