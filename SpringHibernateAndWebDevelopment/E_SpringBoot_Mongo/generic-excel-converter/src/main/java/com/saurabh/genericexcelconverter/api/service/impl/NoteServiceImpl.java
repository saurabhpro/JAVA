package com.saurabh.genericexcelconverter.api.service.impl;

import com.saurabh.genericexcelconverter.api.constants.MessageConstants;
import com.saurabh.genericexcelconverter.api.dao.NoteRepository;
import com.saurabh.genericexcelconverter.api.model.MonthNotes;
import com.saurabh.genericexcelconverter.api.model.Note;
import com.saurabh.genericexcelconverter.api.service.NoteService;
import com.saurabh.genericexcelconverter.web.dto.NoteDTO;
import com.saurabh.genericexcelconverter.web.transformer.DTOToDomainTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * This service class implements the {@link NoteService} to
 * provide the functionality required for the justice league system.
 *
 * @author dinuka
 */
@Service
public class NoteServiceImpl implements NoteService {
	private final NoteRepository noteRepository;
	private Logger logger = Logger.getLogger(NoteServiceImpl.class.getName());

	@Autowired
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addNote(NoteDTO justiceLeagueMember) {
		Note dbMember = noteRepository.findByDate(justiceLeagueMember.getDate());

		if (dbMember != null) {
			throw new IllegalArgumentException(MessageConstants.ErrorMessages.MEMBER_ALREDY_EXISTS);
		}
		Note memberToPersist = DTOToDomainTransformer.transform(justiceLeagueMember);
		noteRepository.insert(memberToPersist);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addNote(MonthNotes note) {
		final List<NoteDTO> noteList = note.getNoteList();
		if (noteList != null) {
			noteList.forEach((noteDTO) -> {
				Note dbMember = noteRepository.findByDate(noteDTO.getDate());

				if (dbMember != null) {
					//throw new IllegalArgumentException(MessageConstants.ErrorMessages.MEMBER_ALREDY_EXISTS);
					logger.warning("Member already exists");
				} else
					noteRepository.insert(DTOToDomainTransformer.transform(noteDTO));
			});
		}
	}
}
