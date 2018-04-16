package com.saurabh.genericexcelconverter.web.transformer;

import com.saurabh.genericexcelconverter.api.model.Note;
import com.saurabh.genericexcelconverter.web.dto.NoteDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class will have transformers from and to different types we need. A
 * common class is used in this instance due to the simplicity of the
 * application.
 *
 * @author dinuka
 */
public class DTOToDomainTransformer {

	/**
	 * This method will trasform an instance of {@link NoteDTO}
	 * to {@link Note}
	 *
	 * @param memberDTO an instance of {@link NoteDTO} with the details
	 *                  of the member.
	 * @return an instance of {@link Note} with the details
	 * of the member.
	 */
	public static Note transform(final NoteDTO memberDTO) {
		return new Note(LocalDateTime.parse(memberDTO.getDate(), DateTimeFormatter.ISO_DATE_TIME), memberDTO.getContent(), memberDTO.getComment());
	}
}
